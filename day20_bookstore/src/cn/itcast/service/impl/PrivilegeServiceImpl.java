package cn.itcast.service.impl;

import java.security.spec.PSSParameterSpec;
import java.util.List;

import cn.itcast.dao.ResourceDao;
import cn.itcast.dao.RoleDao;
import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.ResourceDaoImpl;
import cn.itcast.dao.impl.RoleDaoImpl;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.Resource;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import cn.itcast.service.PrivilegeService;

public class PrivilegeServiceImpl implements PrivilegeService {
	private ResourceDao resourceDao = new ResourceDaoImpl();
	private RoleDao roleDao = new RoleDaoImpl();
	private UserDao userDao = new UserDaoImpl(); 
	@Override
	public List<Resource> findAllResources() {
		return resourceDao.findAll();
	}
	@Override
	public void addResource(Resource resource) {
		resourceDao.save(resource);
	}
	@Override
	public List<Role> findAllRoles() {
		return roleDao.findAll();
	}
	@Override
	public void addRole(Role role) {
		roleDao.save(role);
	}
	@Override
	public Role findRoleById(String roleId) {
		return roleDao.findById(roleId);
	}
	@Override
	public void grantResource2Role(String roleId, String[] resIds) {
		roleDao.grantResource2Role(roleId,resIds);
	}
	@Override
	public List<User> findAllUsers() {
		return userDao.findAll();
	}
	@Override
	public void addUser(User user) {
		userDao.save(user);
	}
	@Override
	public User findUserById(String userId) {
		return userDao.findUserById(userId);
	}
	@Override
	public void grantRole2User(String userId, String[] roleIds) {
		userDao.grantRole2User(userId,roleIds);
	}
	@Override
	public User login(String username, String password) {
		return userDao.find(username,password);
	}

}
