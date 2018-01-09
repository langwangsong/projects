package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
import com.mysql.jdbc.Driver;
// 测试的方法不能有返回值，且不能有参数
public class JDBCTest1 {
	@Test
	public void Test1() throws SQLException{
		//1、注册驱动
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//2、创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","root");
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
}
