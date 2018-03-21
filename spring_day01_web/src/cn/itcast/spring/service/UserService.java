package cn.itcast.spring.service;

import javax.annotation.Resource;

import cn.itcast.spring.web.UserDao;

public class UserService {
	@Resource
	private UserDao userDao;
	public void save(){
		System.out.println("UserService中的save方法执行了...");
		userDao.save();
	}
}
