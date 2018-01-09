package cn.itcast.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 
 * @author Mr_lang
 *
 */
public class MyJdbcUtils {
		private static final String DRIVERCLASS ;
		private static final String URL ;
		private static final String USERNAME ;
		private static final String PASSWORD ;
		//静态代码块
		static{
			Properties pro = new Properties();
			InputStream inputStream = MyJdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
			try {
				pro.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DRIVERCLASS = pro.getProperty("driverClass");
			URL = pro.getProperty("url");
			USERNAME = pro.getProperty("username");
			PASSWORD = pro.getProperty("password");
		}
		
		//得到连接Connection
		public static Connection getConn() throws Exception{
			Class.forName(DRIVERCLASS);
			return DriverManager.getConnection(URL,USERNAME,PASSWORD);
		}
		//关闭所有资源
		public static void releaseAll(ResultSet rs,Statement stmt,Connection conn){
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
			//关闭所有资源
			public static void releaseAll(Statement stmt,Connection conn){
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
