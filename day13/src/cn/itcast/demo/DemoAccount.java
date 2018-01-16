package cn.itcast.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import cn.itcast.utils.MyJdbcUtils;

/**
 * 完成转钱的操作（添加事务）
 * @author Mr_lang
 *
 */
public class DemoAccount {
	/**
	 * 模拟测试
	 */
	@Test
	public void run(){
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//获取链接
			conn = MyJdbcUtils.getConn();
			//设置事务不默认提交
			conn.setAutoCommit(false);
			//编写一条SQL语句
			String sql = "update t_account set money = money + ? where username = ?";
			//预编译我的sql语句
			stmt = conn.prepareStatement(sql);
			//先扣除冠希1000元
			stmt.setDouble(1, -1000);
			stmt.setString(2, "冠希");
			stmt.executeLargeUpdate();
			//========================
			//给美美加1000
			stmt.setDouble(1, 1000);
			stmt.setString(2, "美美");
			stmt.executeUpdate();
			
			//设置异常
			int a=10/0;
			//提交事务
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			//释放资源
			MyJdbcUtils.releaseAll(stmt, conn);
		}
	}
	
}
