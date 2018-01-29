package cn.itcast.dao.impl;

import java.io.Serializable;
import java.util.List;

import cn.itcast.dao.CategoryDao;
import cn.itcast.domain.Category;

public class CategoryDaoImpl extends BaseDao<Category>  implements CategoryDao {
/*	public CategoryDaoImpl() {
		super(Category.class);//调用父类的默认构造方法
		// TODO Auto-generated constructor stub
	}*/

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
