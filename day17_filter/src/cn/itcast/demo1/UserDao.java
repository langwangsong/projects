package cn.itcast.demo1;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.utils.MyJdbcUtils;

public class UserDao {
	public User login(String username,String password){
		QueryRunner runner = new QueryRunner(MyJdbcUtils.getDataSource());
		String sql = "select * from t_user where username=? and password=?";
		try {
			return runner.query(sql, new BeanHandler<User>(User.class),username,password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询错误");
		}
	}
}
