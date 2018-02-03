package cn.itcast.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

	@Override
	public List<User> findAll() {
		String sql = "select * from users";
		return query(sql,new BeanListHandler<User>(User.class));
	}

	@Override
	public void save(User user) {
		String sql = "insert into users (username,password) values (?,?)";
		update(sql,user.getUsername(),user.getPassword());
	}

	@Override
	public User findUserById(String userId) {
		String sql = "select * from users where id=?";
		User user = query(sql,new BeanHandler<User>(User.class),userId);
		if(user!=null){
			sql="select * from roles where id in (select role_id from role_user where user_id=?)";
			List<Role> roles = query(sql,new BeanListHandler<Role>(Role.class),userId);
			user.setRoles(roles);
		}
		return user;
	}

	@Override
	public void grantRole2User(String userId, String[] roleIds) {
		//删除当前用户已经对应的角色关系
		String sql = "delete from role_user where user_id=?";
		update(sql,userId);
		//重新建立新的对应关系
		if(roleIds!=null&&roleIds.length!=0){
			sql = "insert into role_user (user_id,role_id) values (?,?)";
			Object params[][] = new Object[roleIds.length][];
			for (int i=0;i<roleIds.length;i++) {
				params[i] = new Object[]{userId,roleIds[i]};
			}
			batch(sql,params);
		}
	}

	@Override
	public User find(String username, String password) {
		String sql = "select * from users where username=? and password=?";
		return query(sql,new BeanHandler<User>(User.class),username,password);
	}

}
