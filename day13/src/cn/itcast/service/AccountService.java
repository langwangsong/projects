package cn.itcast.service;

import java.sql.Connection;
import java.sql.SQLException;

import cn.itcast.dao.AccountDao;
import cn.itcast.utils.MyJdbcUtils;

/**
 * 转账业务层
 * @author Mr_lang
 *
 */
public class AccountService {
	public void gopay(String fromuser,String touser,double money) throws Exception{
		//添加事务
		Connection conn = null;
		try {
			//获取到连接
			conn =MyJdbcUtils.getConn();
			//开启事务
			conn.setAutoCommit(false);
			//调用持久层，完成事务
			AccountDao dao = new AccountDao();
			//扣钱
			dao.payFromuser(conn, fromuser, money);
			//收钱
			dao.payTouser(conn, touser, money);
			//提交事务
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			//让servlet也提示信息
			throw e;
		}finally{
			//关闭conn对象
			if(conn !=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
