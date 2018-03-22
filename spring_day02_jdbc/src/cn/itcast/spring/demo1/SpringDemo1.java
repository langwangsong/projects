package cn.itcast.spring.demo1;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDemo1 {
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Test
	public void demo1(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///springday02");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.execute("create table user (id int primary key auto_increment,name varchar(20))");
	}
	@Test
	public void demo2(){
		jdbcTemplate.execute("create table user (id int primary key auto_increment,name varchar(20))");
	}
}
