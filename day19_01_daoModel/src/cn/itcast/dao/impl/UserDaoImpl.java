package cn.itcast.dao.impl;

import java.io.Serializable;
import java.util.List;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
	
/*	public UserDaoImpl() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}*/

	@Override
	public List<User> findUsers(int startIndex, int size) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
