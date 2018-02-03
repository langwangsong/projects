package cn.itcast.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.ResourceDao;
import cn.itcast.domain.Resource;

public class ResourceDaoImpl extends JdbcDaoSupport implements ResourceDao {
	@Override
	public List<Resource> findAll() {
		String sql = "select * from resources";
		return query(sql,new BeanListHandler<Resource>(Resource.class));
	}

	@Override
	public void save(Resource resource) {
		String sql = "insert into resources (name,uri) values (?,?)";
		update(sql,resource.getName(),resource.getUri());
	}

}
