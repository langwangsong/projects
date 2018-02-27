package com.itheima.dao.Impl;

import java.sql.Date;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.util.C3P0Util;

public class UserDaoImpl implements UserDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	@Override
	public boolean checkUsername(String username) {
		try {
			User user = qr.query("select * from users where username=?", new BeanHandler<User>(User.class),username);
			return user==null?false:true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void saveUser(User user) {
		try {
			qr.update("insert into users (username,password,email,birthday) values (?,?,?,?)",
						user.getUsername(),user.getPassword(),user.getEmail(),user.getBirthday());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User findUser(String username, String password) {
		try {
			User user = qr.query("select * from users where username=? and password=?", new BeanHandler<User>(User.class),username,password);
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
