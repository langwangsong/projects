package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Resource;

public interface ResourceDao {

	List<Resource> findAll();

	void save(Resource resource);

}
