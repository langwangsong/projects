package com.itheima.dao;

import java.util.List;

import com.itheima.domain.User;

public interface UserDao {
	/**
	 * 根据用户名和密码查询
	 * @param logonName
	 * @param logonPwd
	 * @return 没有返回null
	 */
	User findUser(String logonName, String logonPwd);
	/**
	 * 查询所有的用户
	 * @return
	 */
	List<User> findAll();
	/**
	 * 保存用户信息
	 * @param user
	 */
	void saveUser(User user);
	/**
	 * 根据id查询用户
	 * @param userId
	 * @return
	 */
	User findUserById(Integer userID);
	/**
	 * 更新用户信息
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * 根据主键删除用户
	 * @param userId
	 */
	void deleteUser(Integer userId);
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
	List<User> findUser(String userName, String sex, String education, String hasFile);
}
