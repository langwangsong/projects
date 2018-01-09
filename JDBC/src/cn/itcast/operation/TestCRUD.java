package cn.itcast.operation;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import cn.itcast.entity.User;

public class TestCRUD {
	@Test // 查询所有的用户信息
	public void testSelectAll() throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =	null;
		List<User> list = null;
		try {
			//1、注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2、创建连接Connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","root");
			//3、得到执行SQL语句的Statement对象
			stmt = conn.createStatement();
			//4、执行sql语句，并返回结果
			rs = stmt.executeQuery("select * from users");
			//5、 处理结果
			list =new ArrayList<User>();
			while(rs.next()){
				User u =new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setBirthday(rs.getDate(5));
				list.add(u);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs=null;
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stmt=null;
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn=null;
			}
		}
		//6、关闭资源
		for(User u:list){
			System.out.println(u);
		}
	}
	@Test
	public void testAddUser(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =	null;
		List<User> list = null;
		try {
			//1、注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2、创建连接Connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","root");
			//3、得到执行SQL语句的Statement对象
			stmt = conn.createStatement();
		   //4、执行sql语句，并返回结果
			int i = stmt.executeUpdate("insert into users values(4,'feiqing','1234165','feiqing@126.com','1990-7-9')");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs=null;
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stmt=null;
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn=null;
			}
		}
		//6、关闭资源
	}
	@Test
	public void testDeleteUser(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =	null;
		List<User> list = null;
		try {
			//1、注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2、创建连接Connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","root");
			//3、得到执行SQL语句的Statement对象
			stmt = conn.createStatement();
		   //4、执行sql语句，并返回结果
			int i = stmt.executeUpdate("delete from users where id = 4");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs=null;
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stmt=null;
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn=null;
			}
		}
		//6、关闭资源
	}
}
