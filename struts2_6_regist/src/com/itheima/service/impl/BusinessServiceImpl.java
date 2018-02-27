package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.dao.Impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.exception.UserExistException;
import com.itheima.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	private UserDao dao = new UserDaoImpl();
	@Override
	public void regist(User user) throws UserExistException {
		//判断参数是否OK
		if(user == null)
			throw new IllegalArgumentException("保存的用户信息不能为null");
		//检查用户名是否已经存在
		boolean exist = dao.checkUsername(user.getUsername());
		if(exist){
			throw new UserExistException(user.getUsername()+"已经存在了");
		}
		//执行保存操作
		dao.saveUser(user);
	}

	@Override
	public User login(String username, String password) {
		return dao.findUser(username,password);
	}
}
