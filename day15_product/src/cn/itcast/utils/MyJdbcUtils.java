package cn.itcast.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBC第三个工具类（使用的连接池获取连接）
 * @author Mr_lang
 *
 */
public class MyJdbcUtils {
		private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
		public static DataSource getDataSource(){
			return dataSource;
		}
		
		/**
		 * 得到连接Connection
		 * 开始修改：
		 * 	第一步先从tl获取conn
		 * 	如果是第一次，、。。。
		 * @return
		 * @throws Exception
		 */
		public static Connection getConn() throws Exception{
			 //从连接池返回链接
			return dataSource.getConnection();
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
