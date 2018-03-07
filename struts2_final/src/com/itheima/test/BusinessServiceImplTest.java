package com.itheima.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.itheima.domain.User;
import com.itheima.service.BusinessService;
import com.itheima.service.impl.BusinessServiceImpl;

public class BusinessServiceImplTest {
	private BusinessService s = new BusinessServiceImpl();
	@Test
	public void testLogin() {
		User user = s.login("user1", "123");
		assertNotNull(user);
		user = s.login("user1", "321");
		assertNull(user);
	}

	@Test
	public void testFindAllUsers() {
		List<User> users = s.findAllUsers();
		for(User user:users){
			System.out.println(user);
		}
	}

	@Test
	public void testAddUser() {
		User u = new User();
		u.setUserName("abc");
		s.addUser(u);
	}

	@Test
	public void testFindUserById() {
		User u = s.findUserById(3);
		System.out.println(u);
	}

	@Test
	public void testUpdateUser() {
		User u = s.findUserById(3);
		u.setLogonName("dddddddd");
		s.updateUser(u);
	}

	@Test
	public void testDeleteUser() {
		s.deleteUser(3);
	}

	@Test
	public void testFindUsersByCondition() {
		List<User> users = s.findUsersByCondition(null, null, "本科", "false");
		for (User user : users) {
			System.out.println(user);
		}
	}

}
