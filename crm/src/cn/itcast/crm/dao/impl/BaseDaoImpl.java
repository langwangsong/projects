package cn.itcast.crm.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.itcast.crm.dao.BaseDao;
import cn.itcast.crm.domain.Department;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class clazz;
	public BaseDaoImpl(){
		//反射泛型：
		//获得子类的class：
		Class c = this.getClass();
		/**
		 * 泛型的基本概念：
		 * List<E>为例：
		 * 	*<>	:念为 typeof
		 * 	*ArrayList<Integer>:
		 * 		*Integer:实际类型参数
		 * 		*ArrayList<Integer>:参数化的类型
		 */
		//获得带有泛型的父类
		Type type = c.getGenericSuperclass();// BaseDaoImpl<Department>
		//转成参数化类型
		ParameterizedType pType = (ParameterizedType) type;
		//获得实际类型参数：
		Type[] types = pType.getActualTypeArguments();
		this.clazz = (Class) types[0];//Department的class
	}
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public T findById(Integer id) {
		return (T) this.getHibernateTemplate().get(this.clazz, id);
	}

	@Override
	public List<T> findAll() {
		String hql = "from "+this.clazz.getSimpleName();
		return (List<T>) this.getHibernateTemplate().find(hql);
	}

	@Override
	public int findCount() {
		String hql = "select count(*) from "+this.clazz.getSimpleName();
		List<Number> list = (List<Number>) this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<T> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(this.clazz);
		return (List<T>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
	}
	
}
