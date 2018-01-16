package cn.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.itcast.utils.AccountException;
import cn.itcast.utils.MyJdbcUtils2;

/**
 * 持久层
 * @author Mr_lang
 *
 */
public class AccountDao2 {
	/**
	 * 完成转账的扣除汇款人的钱
	 * @param conn
	 * @param fromuser
	 * @param money
	 * @throws Exception 
	 */
	public void payFromuser(String fromuser,double money) throws Exception{
		//使用工具类获得链接
		Connection conn = MyJdbcUtils2.getConn();
		//原来是获取链接
		String sql = "update t_account set money = money - ? where username = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setDouble(1, money);
		stmt.setString(2, fromuser);
		int count = stmt.executeUpdate();
		if(count ==0){
			//手动关闭stmt对象，conn不要关闭
			stmt.close();
			throw new AccountException("扣钱失败");
		}
		stmt.close();
	}
	public void payTouser(String touser,double money) throws Exception{
		//使用工具类获得链接
		Connection conn = MyJdbcUtils2.getConn();
		String sql = "update t_account set money = money + ? where username = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setDouble(1, money);
		stmt.setString(2, touser);
		int count= stmt.executeUpdate();
		if(count ==0){
			//手动关闭stmt对象，conn不要关闭
			stmt.close();
			throw new AccountException("加钱失败");
		}
		stmt.close();
	}
}
