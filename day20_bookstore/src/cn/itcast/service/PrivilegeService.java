package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Resource;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;

public interface PrivilegeService {

	List<Resource> findAllResources();

	void addResource(Resource resource);

	List<Role> findAllRoles();

	void addRole(Role role);
	/**
	 * 同时查询角色和访问的资源
	 * @param roleId
	 * @return
	 */
	Role findRoleById(String roleId);

	void grantResource2Role(String roleId, String[] resIds);

	List<User> findAllUsers();

	void addUser(User user);
	/**
	 * 同时查询用户和拥有的角色
	 * @param userId
	 * @return
	 */
	User findUserById(String userId);

	void grantRole2User(String userId, String[] roleIds);

	User login(String username, String password);

}
