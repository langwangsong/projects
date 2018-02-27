package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao {
	/**
	 * 检查用户是否存在
	 * @param username 用户名
	 * @return 存在返回true 不存在返回false
	 */
	boolean checkUsername(String username);
	/**
	 * 保存信息到user表
	 * @param user
	 */
	void saveUser(User user);
	/**
	 * 根据用户名和密码查询用户记录
	 * @param username
	 * @param password
	 * @return 没查到返回null
	 */
	User findUser(String username, String password);
	
}
