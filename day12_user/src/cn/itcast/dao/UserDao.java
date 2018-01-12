package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao {
	
	public void save(User user) throws Exception;

	public User loginUser(User user);
}
