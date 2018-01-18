package cn.itcast.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.itcast.utils.MyJdbcUtils;

/**
 * 测试C3P0
 * @author Mr_lang
 *
 */
public class C3p0Demo {
	/**
	 * 测试手动编码的方式
	 */
	@Test
	public void run1(){
		Connection conn =null;
		PreparedStatement stmt = null;
		try {
			//创建C3P0的连接池对象
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			//设置4大参数
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql:///mysql1");
			dataSource.setUser("root");
			dataSource.setPassword("root");
			//直接调用该方法，获取连接(从连接池中获取到的连接，该连接是由连接池来维护的)
			conn= dataSource.getConnection();
			String sql = "update t_account set money = 10 where username='美美'";
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//释放资源（Conn是归还连接）
			MyJdbcUtils.releaseAll(stmt, conn);
		}
	}
	/**
	 * 测试配置文件的方式,默认读取配置文件
	 */
	@Test
	public void run2(){
		Connection conn =null;
		PreparedStatement stmt = null;
		try {
			//创建C3P0的连接池对象
			ComboPooledDataSource dataSource = new ComboPooledDataSource("myc3p0000");
			//直接调用该方法，获取连接(从连接池中获取到的连接，该连接是由连接池来维护的)
			conn= dataSource.getConnection();
			String sql = "update t_account set money = 1000 where username='美美'";
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//释放资源（Conn是归还连接）
			MyJdbcUtils.releaseAll(stmt, conn);
		}
	}	
}
