package cn.itcast.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.itcast.domain.Account;
import cn.itcast.utils.MyDBUtils;
import cn.itcast.utils.MyJdbcUtils3;
import cn.itcast.utils.ResultSetHandler;

/**
 * 编写一个添加数据的方法
 * @author Mr_lang
 *
 */
public class Demo1 {
	/**
	 * 想数据库中添加数据
	 * @param ac
	 */
	public void insert(Account ac){
		Connection conn =null;
		PreparedStatement stmt = null;
		try {
			conn = MyJdbcUtils3.getConn();
			String sql = "insert into t_account values(null,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ac.getUsername());
			stmt.setDouble(2, ac.getMoney());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyJdbcUtils3.releaseAll(stmt, conn);
		}
	}
	/**
	 * 修改信息	
	 * @param ac
	 */
	public void update(Account ac){
		Connection conn =null;
		PreparedStatement stmt = null;
		try {
			conn = MyJdbcUtils3.getConn();
			String sql = "update t_account set username = ? , money = ? where id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ac.getUsername());
			stmt.setDouble(2, ac.getMoney());
			stmt.setInt(3,ac.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyJdbcUtils3.releaseAll(stmt, conn);
		}
	}
	/**
	 * 查询所有的账户的信息
	 * @param id
	 * @return
	 */
	public List<Account> findById(){
		List<Account> acList = new ArrayList<Account>();
		Connection conn =null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = MyJdbcUtils3.getConn();
			String sql = "select * from t_account";
			stmt = conn.prepareStatement(sql);
			//执行查询的方法
			rs = stmt.executeQuery();
			while(rs.next()){
				Account ac = new Account();
				ac.setId(rs.getInt("id"));
				ac.setUsername(rs.getString("username"));
				ac.setMoney(rs.getDouble("money"));
				acList.add(ac);
			}
			return acList;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyJdbcUtils3.releaseAll(rs,stmt, conn);
		}
		return null;
	}
	public Account findAll(int id){
		Connection conn =null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = MyJdbcUtils3.getConn();
			String sql = "select * from t_account where id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			//执行查询的方法
			rs = stmt.executeQuery();
			if(rs.next()){
				Account ac = new Account();
				ac.setId(rs.getInt("id"));
				ac.setUsername(rs.getString("username"));
				ac.setMoney(rs.getDouble("money"));
				return ac;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyJdbcUtils3.releaseAll(rs,stmt, conn);
		}
		return null;
	}
	@Test
	public void run(){
//		Account ac = new Account();
//		ac.setUsername("强哥2");
//		ac.setMoney((double) 1500);
//		ac.setId(7);
//		update(ac);
//		//添加数据的方法
//		//insert(ac);
		//测试自己写的通用的增删改的方法
		//MyDBUtils mydb = new MyDBUtils();
		//mydb.update("delete from t_account where id = ?", 7);
		//mydb.update("insert into t_account values(?,?,?)", 8,"强哥",500);
		/*Account ac = new Account();
		ac = findById(5);
		System.out.println(ac);*/
		/*List<Account> acList = this.findById();
		for(Account al:acList){
			System.out.println(al);
		}*/
		MyDBUtils mydb = new MyDBUtils();
		Account ac = mydb.query("select * from t_account where id = ?", new MyBeanHandler(), 3);
		System.out.println(ac);
	}
	/**
	 * 把一条记录封装到一个JavaBean对象中
	 */
	class MyBeanHandler implements ResultSetHandler<Account>{
		/**
		 * 让我用户自己来封装结果集
		 * @throws SQLException 
		 */
		public Account handle(ResultSet rs) throws SQLException{
			Account ac = new Account();
			if(rs.next()){
				ac.setId(rs.getInt("id"));
				ac.setUsername(rs.getString("username"));
				ac.setMoney(rs.getDouble("money"));
			}
			return ac;
		}
	}
}
