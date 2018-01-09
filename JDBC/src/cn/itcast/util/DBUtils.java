package cn.itcast.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils{
	//得到连接Connection
	public static Connection getConn() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","root");
	}
	//关闭所有资源
	public static void closeAll(ResultSet rs,Statement stmt,Connection conn){
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
}
