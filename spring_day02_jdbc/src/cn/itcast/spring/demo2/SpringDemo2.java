package cn.itcast.spring.demo2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用JDBC的模板完成CRUD的操作
 * @author Mr_lang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDemo2 {
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	/**
	 * 保存
	 */
	@Test
	public void demo1(){
		String sql = "insert into user values(null,?)";
		jdbcTemplate.update(sql,"李四");
	}
	/**
	 * 修改
	 */
	@Test
	public void demo2(){
		String sql = "update user set name=? where id=?";
		jdbcTemplate.update(sql, "小王",1);
	}
	/**
	 *删除 
	 */
	@Test
	public void demo3(){
		String sql="delete from user where id=?";
		jdbcTemplate.update(sql, 1);
	}
	/**
	 * 简单查询：统计个数
	 */
	@Test
	public void demo4(){
		String sql = "select count(*) from user";
		int s = jdbcTemplate.queryForInt(sql,null);
		System.out.println(s);
	}
	/**
	 * 简单查询：查询一个用户的名称
	 */
	@Test
	public void demo5(){
		String sql = "select name from user where id = ?";
		String name = jdbcTemplate.queryForObject(sql, String.class, 3);
		System.out.println(name);
	}
	/**
	 * 复杂查询：
	 */
	@Test
	public void demo6(){
		String sql = "select * from user where id = ?";
		User user = jdbcTemplate.queryForObject(sql,new MyRowMapper() , 4);
		System.out.println(user);
	}
	@Test
	public void demo7(){
		String sql = "select * from user";
		List<User> list = jdbcTemplate.query(sql, new MyRowMapper(),null);
		for (User user : list) {
			System.out.println(user);
		}
	}
	class MyRowMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			return user;
		}
		
	}
}
