package cn.itcast.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.CategoryDao;
import cn.itcast.manage.domain.Category;

public class CategoryDaoImpl extends JdbcDaoSupport implements CategoryDao {
	public Category findByName(String categoryName) {
		String sql = "select * from categories where name = ?";
		return query(sql, new BeanHandler<Category>(Category.class),categoryName);
	}
	public void save(Category category) {
		String sql = "insert into categories (name,description) values (?,?)";
		update(sql,category.getName(),category.getDescription());
	}
	public Category findById(String categoryId) {
		String sql = "select * from categories where id = ?";
		return query(sql, new BeanHandler<Category>(Category.class),categoryId);
	}
	public List<Category> findAll() {
		String sql = "select * from categories";
		return query(sql, new BeanListHandler<Category>(Category.class));
	}
}
