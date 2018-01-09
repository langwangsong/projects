package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import cn.itcast.entity.User;
// 测试的方法不能有返回值，且不能有参数
public class JDBCTest2 {
	@Test
	public void Test1() throws Exception{
		//1、注册驱动
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Class.forName("com.mysql.jdbc.Driver");
		//2、创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","root");
		//3、得到执行sql语句的Statement对象（小货车）
		Statement stmt = conn.createStatement();
		//4、执行sql语句并返回结果
		ResultSet rs = stmt.executeQuery("select * from users");
		//5、处理结果
		while(rs.next()){
			System.out.println(rs.getObject("id")+" "+
					rs.getObject("name")+" "+rs.getObject(3)+" "+
					rs.getObject(4)+" "+rs.getObject(5));
			System.out.println("--------------------------------------");
		}
		//6、关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}
	@Test
	public void Test2() throws Exception{
		//1、注册驱动
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Class.forName("com.mysql.jdbc.Driver");
		//2、创建连接
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","root");
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "root");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1", info);
		//3、得到执行sql语句的Statement对象（小货车）
		Statement stmt = conn.createStatement();
		//4、执行sql语句并返回结果
		ResultSet rs = stmt.executeQuery("select * from users");
		//5、处理结果
		while(rs.next()){
			System.out.println(rs.getObject(1)+" "+
					rs.getObject(2)+" "+rs.getObject(3)+" "+
					rs.getObject(4)+" "+rs.getObject(5));
			System.out.println("--------------------------------------");
		}
		//6、关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}
	@Test
	public void Test3() throws Exception{
		//1、注册驱动
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Class.forName("com.mysql.jdbc.Driver");
		//2、创建连接
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","root");
		//Properties info = new Properties();
		//info.setProperty("user", "root");
		//info.setProperty("password", "root");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1?user=root&password=root");
		//3、得到执行sql语句的Statement对象（小货车）
		Statement stmt = conn.createStatement();
		//4、执行sql语句并返回结果
		ResultSet rs = stmt.executeQuery("select * from users");
		//5、处理结果
		while(rs.next()){
			System.out.println(rs.getObject(1)+" "+
					rs.getObject(2)+" "+rs.getObject(3)+" "+
					rs.getObject(4)+" "+rs.getObject(5));
			System.out.println("--------------------------------------");
		}
		//6、关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}
	@Test //执行添加操作
	public void Test4() throws Exception{
		//1、注册驱动
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Class.forName("com.mysql.jdbc.Driver");
		//2、创建连接
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","root");
		//Properties info = new Properties();
		//info.setProperty("user", "root");
		//info.setProperty("password", "root");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1?user=root&password=root");
		//3、得到执行sql语句的Statement对象（小货车）
		Statement stmt = conn.createStatement();
		//4、执行sql语句并返回结果
		//ResultSet rs = stmt.executeQuery("select * from users");
		int i=stmt.executeUpdate("insert into users values(5,'zl','666','zl@163.com','2015-9-10')");
		//5、处理结果
		System.out.println(i+"行被插入");
		if(i>0)
			System.out.println("success");
		/*while(rs.next()){
			System.out.println(rs.getObject(1)+" "+
					rs.getObject(2)+" "+rs.getObject(3)+" "+
					rs.getObject(4)+" "+rs.getObject(5));
			System.out.println("--------------------------------------");
		}*/
		//6、关闭资源
		//rs.close();
		stmt.close();
		conn.close();
	}
	@Test //只用java对象封装数据
	public void Test5() throws Exception{
		//1、注册驱动
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Class.forName("com.mysql.jdbc.Driver");
		//2、创建连接
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","root");
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "root");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1", info);
		//3、得到执行sql语句的Statement对象（小货车）
		Statement stmt = conn.createStatement();
		//4、执行sql语句并返回结果
		ResultSet rs = stmt.executeQuery("select * from users");
		//5、处理结果
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setBirthday(rs.getDate(5));
			list.add(user);
		}
		//6、关闭资源
		rs.close();
		stmt.close();
		conn.close();
		for(User u : list){
			System.out.println(u);
		}
	}
	@Test //取表中最后一行
	public void Test6() throws Exception{
		//1、注册驱动
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Class.forName("com.mysql.jdbc.Driver");
		//2、创建连接
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","root");
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "root");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1", info);
		//3、得到执行sql语句的Statement对象（小货车）
		Statement stmt = conn.createStatement();
		//4、执行sql语句并返回结果
		ResultSet rs = stmt.executeQuery("select * from users");
		//5、处理结果
		rs.afterLast();
		rs.previous();
		User user = new User();
		//while(rs.next()){
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setBirthday(rs.getDate(5));
		//}
		//6、关闭资源
		rs.close();
		stmt.close();
		conn.close();
		System.out.println(user);
	}
	@Test //关闭资源
	public void Test7() throws Exception{
		Connection conn =null;
		Statement stmt=null;
		ResultSet rs = null;
		User user = null;
		try{
			//1、注册驱动
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Class.forName("com.mysql.jdbc.Driver");
			//2、创建连接
			//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","root");
			Properties info = new Properties();
			info.setProperty("user", "root");
			info.setProperty("password", "root");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1", info);
			//3、得到执行sql语句的Statement对象（小货车）
			stmt = conn.createStatement();
			//4、执行sql语句并返回结果
			rs = stmt.executeQuery("select * from users");
			//5、处理结果
			rs.afterLast();
			rs.previous();
			user = new User();
			//while(rs.next()){
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setBirthday(rs.getDate(5));
			//}
			System.out.println(user);
			//6、关闭资源
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				rs=null;
			}
			if(stmt!=null){
				try{
					stmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				stmt=null;
			}
			if(conn!=null){
				try{
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				conn=null;
			}
		}
	}
}
