package cn.itcast.demo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import cn.itcast.domain.Account;
import cn.itcast.utils.MyJdbcUtils3;

/**
 * 测试9个实现类
 * @author Mr_lang
 *
 */
public class ResultSetHandlerDemo {
	/**
	 * 把一条记录封装到JavaBean对象中。（掌握）
	 */
	@Test
	public void run1(){
		QueryRunner runner = new QueryRunner(MyJdbcUtils3.getDataSource());
		try {
			String sql = "select * from t_account where id = ?";
			Account ac = runner.query(sql, new BeanHandler<Account>(Account.class),2);
			System.out.println(ac);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 把一条记录封装到JavaBean对象中，再把这些JavaBean封装到List集合中。（掌握）
	 */
	@Test
	public void run2(){
		QueryRunner runner = new QueryRunner(MyJdbcUtils3.getDataSource());
		try {
			String sql = "select * from t_account";
			List<Account> acList = runner.query(sql, new BeanListHandler<Account>(Account.class));
			for (Account ac : acList) {
				System.out.println(ac);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 把一条记录封装到数组中
	 */
	@Test
	public void run3(){
		QueryRunner runner = new QueryRunner(MyJdbcUtils3.getDataSource());
		try {
			String sql = "select * from t_account where id = ?";
			Object[] arr = runner.query(sql, new ArrayHandler(),2);
			System.out.println(Arrays.toString(arr));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 把一条记录封装到数组中，再把这些数据封装到List集合中
	 */
	@Test
	public void run4(){
		QueryRunner runner = new QueryRunner(MyJdbcUtils3.getDataSource());
		try {
			String sql = "select * from t_account";
			List<Object []> arrList = runner.query(sql, new ArrayListHandler());
			for (Object[] objects : arrList) {
				System.out.println(Arrays.toString(objects));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 把一条记录封装到Map集合
	 */
	@Test
	public void run5(){
		QueryRunner runner = new QueryRunner(MyJdbcUtils3.getDataSource());
		try {
			String sql = "select * from t_account where id = ?";
			Map<String, Object> map = runner.query(sql, new MapHandler(),2);
			System.out.println(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 把一条记录封装到Map集合，再把这些map封装到List集合中
	 */
	@Test
	public void run6(){
		QueryRunner runner = new QueryRunner(MyJdbcUtils3.getDataSource());
		try {
			String sql = "select * from t_account";
			List<Map<String,Object>> mapList = runner.query(sql, new MapListHandler());
			for (Map<String, Object> map : mapList) {
				System.out.println(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 *  -- 查询的是某个字段的值，把该值封装到List集合中。（select username from t_account）
	 */
	@Test
	public void run7(){
		QueryRunner runner = new QueryRunner(MyJdbcUtils3.getDataSource());
		try {
			String sql = "select username,money from t_account";
			List<Object> list = runner.query(sql, new ColumnListHandler("money"));
			for (Object object : list) {
				System.out.println(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 *  先把一条记录封装到Map集合中，再把这些Map集合封装到另一个Map集合中。
	 */
	@Test
	public void run8(){
		QueryRunner runner = new QueryRunner(MyJdbcUtils3.getDataSource());
		try {
			String sql = "select * from t_account";
			Map<Object, Map<String, Object>> map = runner.query(sql, new KeyedHandler("username"));
			System.out.println(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 *  封装的结果是聚集函数（select count(*) from t_account;）
	 */
	@Test
	public void run9(){
		QueryRunner runner = new QueryRunner(MyJdbcUtils3.getDataSource());
		try {
			String sql = "select count(*) from t_account";
			long count =(Long) runner.query(sql, new ScalarHandler());
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
