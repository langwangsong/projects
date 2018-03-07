package com.itheima.service;

import java.util.List;

import com.itheima.domain.User;

public interface BusinessService {
	/**
	 * 用户登录
	 * @param logonName 用户的登录名
	 * @param logonPwd 密码
	 * @return 如果用户名或密码错误，返回null，否则返回User对象
	 */
	User login(String logonName,String logonPwd);
	/**
	 * 返回所有用户
	 * @return
	 */
	List<User> findAllUsers();
	/**
	 * 添加用户
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 根据ID查询用户
	 * @param UserId
	 */
	User findUserById(Integer userID);
	/**
	 * 修改用户信息
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * 根据id删除用户
	 * @param userId
	 */
	void deleteUser(Integer userID);
	/**
	 * 按照条件查询
	 * 如果四个参数都是null说明忽略这些条件
	 * 任意一个不为null，作为and查询条件
	 * hasFile：如果为null,忽略条件。如果为true,查询有简历的，如果为false，查询没有简历的
	 * @param userName 用户名
	 * @param sex 性别
	 * @param education 学历
	 * @param hasFile 是否上传学历
	 * @return 查询结果
	 */
	List<User> findUsersByCondition(String userName,String sex,String education,String hasFile);
}
