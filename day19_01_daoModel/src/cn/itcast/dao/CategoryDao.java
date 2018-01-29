package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Category;

public interface CategoryDao extends Dao<Category> {
	List<Category> findAll();
}
