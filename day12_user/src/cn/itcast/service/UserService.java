package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.UserDaoImpl;
import cn.itcast.domain.User;

/**
 * 用户相关的业务逻辑
 * @author Mr_lang
 *
 */
public class UserService {
	/**
	 * 保存用户
	 * @param user
	 * @throws Exception 
	 */
	public void saveUser(User user) throws Exception{
		//调用持久层保存数据
		UserDao dao = new UserDaoImpl();
		dao.save(user);
	}
	/**
	 * 登录的功能
	 * @param user
	 * @return
	 */
	public User loginUser(User user){
		UserDao dao = new UserDaoImpl();
		return dao.loginUser(user);
	}
}
