package cn.itcast.test;

import org.junit.Test;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;

public class DaoTest {
	@Test
	public void testSaveUser(){
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setName("用户一");
		userDao.save(user);
	}
	@Test
	public void testFindUser(){
		UserDao userDao = new UserDaoImpl();
		User user = userDao.findOne(1);
		System.out.println(user);
	}
}
