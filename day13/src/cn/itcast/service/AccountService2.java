package cn.itcast.service;

import cn.itcast.dao.AccountDao2;
import cn.itcast.utils.MyJdbcUtils2;

/**
 * 转账业务层
 * @author Mr_lang
 *
 */
public class AccountService2 {
	public void gopay(String fromuser,String touser,double money) throws Exception{
		try {
			//直接开启事务
			MyJdbcUtils2.startTransaction();
			//调用持久层，完成事务
			AccountDao2 dao = new AccountDao2();
			//扣钱
			dao.payFromuser(fromuser, money);
			//收钱
			dao.payTouser(touser, money);
			//提交事务
			MyJdbcUtils2.commitTransaction();
		} catch (Exception e) {
			MyJdbcUtils2.rollbackTransaction();
			throw e;
		}finally{
			//关闭连接
			MyJdbcUtils2.closeConn();
		}
	}
}
