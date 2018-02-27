package com.itheima.test;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Calendar;

import org.junit.Test;

import com.itheima.domain.User;
import com.itheima.exception.UserExistException;
import com.itheima.service.BusinessService;
import com.itheima.service.impl.BusinessServiceImpl;

public class BusinessServiceImplTest {
	private BusinessService s = new BusinessServiceImpl();
	@Test(expected=com.itheima.exception.UserExistException.class)
	public void testRegist() throws UserExistException{
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setEmail("admin@admin.admin");
		Calendar c = Calendar.getInstance();
		c.set(2018, 2, 4);
		Date birthday = c.getTime();
		user.setBirthday(birthday);
		s.regist(user);
	}
	
	@Test
	public void testLogin(){
		User user = s.login("admin", "admin");
		assertNotNull(user);
		user = s.login("admin", "123");
		assertNull(user);
	}
	public static void main(String[] args) {
		int a=1;
		int s=1;
		for (int i = 2; i <=24; i++) {
			int t = s;
			s = s+a;
			a = t;
		}
		System.out.println(s);	
	}
}
