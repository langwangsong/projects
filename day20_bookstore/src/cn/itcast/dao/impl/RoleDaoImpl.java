package cn.itcast.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.RoleDao;
import cn.itcast.domain.Resource;
import cn.itcast.domain.Role;

public class RoleDaoImpl extends JdbcDaoSupport implements RoleDao {

	@Override
	public List<Role> findAll() {
		String sql = "select * from roles";
		return query(sql,new BeanListHandler<Role>(Role.class));
	}

	@Override
	public void save(Role role) {
		String sql = "insert into roles (name,description) values (?,?)";
		update(sql,role.getName(),role.getDescription());
	}

	@Override
	public Role findById(String roleId) {
		// 角色的基本信息
		String sql = "select * from roles where id=?";
		Role role = query(sql,new BeanHandler<Role>(Role.class),roleId);
		//角色对应的资源
		if(role != null){
			sql = "select * from resources where id in (select res_id from resource_role where role_id=?)";
			List<Resource> resources = query(sql,new BeanListHandler<Resource>(Resource.class),roleId);
			role.setResources(resources);
		}
		return role;
	}

	@Override
	public void grantResource2Role(String roleId, String[] resIds) {
		//删除当前角色已经对应的资源关系
		String sql = "delete from resource_role where role_id=?";
		update(sql,roleId);
		//重新建立新的对应关系
		sql = "insert into resource_role (res_id,role_id) values (?,?)";
		if(resIds!=null&&resIds.length!=0){
			for (String resId : resIds) {
				update(sql,resId,roleId);
			}
		}
	}

}
