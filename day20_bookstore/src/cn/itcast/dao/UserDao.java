package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.User;

public interface UserDao {

	List<User> findAll();

	void save(User user);

	User findUserById(String userId);

	void grantRole2User(String userId, String[] roleIds);

	User find(String username, String password);

}
