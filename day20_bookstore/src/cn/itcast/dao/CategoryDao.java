package cn.itcast.dao;

import java.util.List;

import cn.itcast.manage.domain.Category;

public interface CategoryDao {
	/**
	 * 根据分类名称查询分类
	 * @param categoryName
	 * @return 没有返回null
	 */
	Category findByName(String categoryName);

	void save(Category category);


	List<Category> findAll();

	Category findById(String categoryId);

}
