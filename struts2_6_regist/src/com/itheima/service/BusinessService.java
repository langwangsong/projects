package com.itheima.service;

import com.itheima.domain.User;
import com.itheima.exception.UserExistException;

public interface BusinessService {
	/**
	 * 新用户注册
	 * @param user 用户注册的信息
	 * @throws UserExistException 如果用户存在，抛出此异常
	 */
	void regist(User user) throws UserExistException;
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 如果不正确，返回null，否则返回User对象
	 */
	User login(String username,String password);
}
