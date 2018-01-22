package cn.itcast.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.itcast.domain.Account;
import cn.itcast.utils.MyJdbcUtils3;

public class DBUtilsDemo {
	/**
	 * 测试DBUtils的曾删改的方法
	 */
	@Test
	public void run1(){
		//先创建QueryRunner类
		QueryRunner runner = new QueryRunner(MyJdbcUtils3.getDataSource());
		//调用update方法，完成增删改的方法
		try {
			runner.update("delete from t_account where id = ?",6);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 测试查询的方法
	 */
	@Test
	public void run2(){
		QueryRunner runner = new QueryRunner(MyJdbcUtils3.getDataSource());
		//测试查询
		try {
			List<Account> acList = runner.query("select * from t_account", new BeanListHandler<Account>(Account.class));
			for(Account ac:acList){
				System.out.println(ac);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 测试和事务有关的方法
	 * @throws Exception 
	 * 
	 */
	@Test
	public void run3() throws Exception{
		//不能知道连接池的参数了
		QueryRunner runner = new QueryRunner();
		Connection conn = null;
		//测试查询
		try {
			conn = MyJdbcUtils3.getConn();
			List<Account> acList = runner.query(conn,"select * from t_account", new BeanListHandler<Account>(Account.class));
			for(Account ac:acList){
				System.out.println(ac);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//自己关闭conn
			DbUtils.close(conn);
		}
	}
	/**
	 * 可以完成SQL语句批量的执行
	 * 需求：让删除掉第一条和第三条记录
	 * @throws Exception
	 */
	@Test
	public void run4(){
		QueryRunner runner = new QueryRunner(MyJdbcUtils3.getDataSource());
		//编写SQL语句
		String sql = "delete from t_account where id = ?";
		//调用批处理的方法，一次执行2条SQL语句
		try {
			runner.batch(sql, new Object[][]{{1},{3}});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
