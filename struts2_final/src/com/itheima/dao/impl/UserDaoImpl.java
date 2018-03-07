package com.itheima.dao.impl;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.util.C3P0Util;

public class UserDaoImpl implements UserDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	@Override
	public void saveUser(User user) {
		String sql ="insert into S_User (userName,logonName,logonPwd,"
				+ "sex,birthday,education,telephone,interest,path,filename,remark)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			qr.update(sql,user.getUserName(),user.getLogonName(),user.getLogonPwd(),
					user.getSex(),user.getBirthday(),user.getEducation(),user.getTelephone(),
					user.getInterest(),user.getPath(),user.getFilename(),user.getRemark());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	@Override
	public void updateUser(User user) {
		String sql ="update S_User set userName=?,logonName=?,logonPwd=?,"
				+ "sex=?,birthday=?,education=?,telephone=?,interest=?,"
				+ "path=?,filename=?,remark=? where userId=?";
		try {
			qr.update(sql,user.getUserName(),user.getLogonName(),user.getLogonPwd(),
					user.getSex(),user.getBirthday(),user.getEducation(),user.getTelephone(),
					user.getInterest(),user.getPath(),user.getFilename(),user.getRemark(),user.getUserID());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	@Override
	public void deleteUser(Integer userId) {
		String sql ="delete from S_User where userId=?";
		try {
			qr.update(sql,userId);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	@Override
	public User findUser(String logonName, String logonPwd) {
		try {
			User user = new User();
			user.setLogonName(logonName);
			user.setLogonPwd(logonPwd);
			List<User> users = find(user);
			if(users==null || users.size()==0){
				return null;
			}else if(users.size()!=1){
				throw new RuntimeException("查询结果不唯一");
			}else{
				return users.get(0);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> findAll() {
		try {
			return find(new User());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public User findUserById(Integer userID) {
		try {
			User user = new User();
			user.setUserID(userID);
			List<User> users = find(user);
			if(users==null || users.size()==0){
				return null;
			}else if(users.size()!=1){
				throw new RuntimeException("查询结果不唯一");
			}else{
				return users.get(0);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public List<User> findUser(String userName, String sex, String education, String hasFile) {
		try {
			User user = new User();
			user.setUserName(userName);
			user.setSex(sex);
			user.setEducation(education);
			user.setFilename(hasFile);
			return find(user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 按照给定的example进行查询，如果对象中的字段不为null，都作为and的查询条件
	 * @param example
	 * @return
	 * @throws Exception 
	 */
	private List<User> find(User example) throws Exception{
		StringBuffer sql=new StringBuffer("select * from S_User where 1=1 ");
//		List params = new ArrayList(0);//组织条件所用到的参数
		//得到example所有的属性，把不为null的属性作为查询条件
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class,Object.class);//获取User自己的JavaBean的属性
		PropertyDescriptor pds[] = beanInfo.getPropertyDescriptors();//得到属性描述器
		for(PropertyDescriptor pd:pds){
			//调用读属性，调用getXXX()
			Method method = pd.getReadMethod();
			Object rtValue = method.invoke(example, null);//调用getXXX()，得到返回值
			//判断 返回值是不是null，不是null，作为一个查询条件
			if(rtValue!=null){
				String fieldName = pd.getName();//属性名getUsername,属性名username
				if(fieldName.equals("userID")){
					sql.append("and "+fieldName+"="+rtValue+" ");
				}else if("userName".equals(fieldName)){
					//用户名：模糊查询
					sql.append("and "+fieldName+" like '%"+rtValue+"%' ");
				}else if("filename".equals(fieldName)){
					if("true".equals(rtValue)){
						sql.append("and "+fieldName+" is not null ");
					}else{
						sql.append("and "+fieldName+" is null ");
					}
				}else{
					sql.append("and "+fieldName+"='"+rtValue+"' ");
				}
			}
		}
		return qr.query(sql.toString(), new BeanListHandler<User>(User.class));
	}
/*	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setUserID(1);
		user.setEducation("研究生");
		user.setFilename("false");
		user.setUserName("刘");
		new UserDaoImpl().find(user);
	}*/
}
