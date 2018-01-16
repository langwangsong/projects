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
public class MyJdbcUtils2 {
		private static final String DRIVERCLASS ;
		private static final String URL ;
		private static final String USERNAME ;
		private static final String PASSWORD ;
		//静态代码块
		static{
			Properties pro = new Properties();
			InputStream inputStream = MyJdbcUtils2.class.getClassLoader().getResourceAsStream("db.properties");
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
		//定义
		private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
		/**
		 * 得到连接Connection
		 * 开始修改：
		 * 	第一步先从tl获取conn
		 * 	如果是第一次，、。。。
		 * @return
		 * @throws Exception
		 */
		public static Connection getConn() throws Exception{
			Class.forName(DRIVERCLASS);
			// 从tl获取conn
			 Connection conn = tl.get();
			 if(conn==null){
				 //说明是第一次
				 conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				 //存入tl中
				 tl.set(conn);
			 }
			 //返回链接
			return conn;
		}
		//开启事务
		public static void startTransaction() throws Exception{
			//从tl中获取conn，直接开启事务
			Connection conn = getConn();
			if(conn != null){
				conn.setAutoCommit(false);
			}
		}
		//提交事务
		public static void commitTransaction() throws Exception{
			//从tl中获取conn，直接开启事务
			Connection conn = getConn();
			if(conn != null){
				conn.commit();
			}
		}
		//回滚事务
		public static void rollbackTransaction() throws Exception{
			//从tl中获取conn，直接开启事务
			Connection conn = getConn();
			if(conn != null){
				conn.rollback();
			}
		}
		//关闭连接
		public static void closeConn() throws Exception{
			//从tl中获取conn，直接开启事务
			Connection conn = getConn();
			if(conn != null){
				conn.close();
			}
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
