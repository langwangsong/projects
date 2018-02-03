package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Role;

public interface RoleDao {

	List<Role> findAll();

	void save(Role role);

	Role findById(String roleId);

	void grantResource2Role(String roleId, String[] resIds);

}
