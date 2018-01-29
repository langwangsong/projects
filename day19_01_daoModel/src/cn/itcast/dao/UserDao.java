package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.User;

public interface UserDao extends Dao<User> {
	List<User> findUsers(int startIndex,int size);
}
