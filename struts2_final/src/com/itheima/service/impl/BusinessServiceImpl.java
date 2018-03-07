package com.itheima.service.impl;

import java.util.List;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	private UserDao userDao = new UserDaoImpl();
	@Override
	public User login(String logonName, String logonPwd) {
		return userDao.findUser(logonName,logonPwd);
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAll();
	}

	@Override
	public void addUser(User user) {
		if(user==null){
			throw new IllegalArgumentException("参数不能为null");
		}
		userDao.saveUser(user);
	}

	@Override
	public User findUserById(Integer userID) {
		return userDao.findUserById(userID);
	}

	@Override
	public void updateUser(User user) {
		if(user==null){
			throw new IllegalArgumentException("参数不能为null");
		}
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(Integer userID) {
		userDao.deleteUser(userID);
	}

	@Override
	public List<User> findUsersByCondition(String userName, String sex, String education, String hasFile) {
		if("".equals(userName)){
			userName=null;
		}
		if("".equals(sex)){
			sex=null;
		}
		if("".equals(education)){
			education=null;
		}
		if("".equals(hasFile)){
			hasFile=null;
		}
		return userDao.findUser(userName, sex,education,hasFile);
	}

}
