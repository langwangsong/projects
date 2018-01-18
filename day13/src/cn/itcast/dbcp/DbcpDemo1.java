package cn.itcast.dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import cn.itcast.utils.MyJdbcUtils;

/**
 * DBCP的连接池的测试
 * @author Mr_lang
 *
 */
public class DbcpDemo1 {
	/**
	 * 测试DBCP连接池，手动设置4个参数
	 */
	@Test
	public void run1(){
		Connection conn =null;
		PreparedStatement stmt = null;
		try {
			//原来：自己获取连接（创建的），现在：从连接池中获取连接
			//创建连接池的对象BasicDataSource已经实现DataSource接口，如果实现了该接口，实现getConnection（）方法
			BasicDataSource dataSource = new BasicDataSource();
			//设置4个参数
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql:///mysql1");
			dataSource.setUsername("root");
			dataSource.setPassword("root");
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
	/**
	 * 测试配置文件的方式
	 */
	@Test
	public void run2(){
		Connection conn =null;
		PreparedStatement stmt = null;
		try {
			Properties pro = new Properties();
			
			InputStream in = DbcpDemo1.class.getClassLoader().getResourceAsStream("dbcp.properties");
			//加载
			pro.load(in);
			//使用BasicDataSourceFactory类
			DataSource dataSource = BasicDataSourceFactory.createDataSource(pro);
			//直接调用该方法，获取连接(从连接池中获取到的连接，该连接是由连接池来维护的)
			conn= dataSource.getConnection();
			String sql = "update t_account set money = 1000 where username='冠希'";
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
