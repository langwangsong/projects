package cn.itcast.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.dao.Dao;
import cn.itcast.util.HibernateUtil;
//借助Hibernate等类似的ORM框架
public abstract class BaseDao<T> implements Dao<T> {

	private Class clazz; //JavaBean的类型
/*	public BaseDao(Class clazz){//使用者注入进来
		this.clazz=clazz;
	}*/
	//给clazz赋值，方便知道操作的是哪个类。目标
	public BaseDao(){
		 // this  : 创建的是哪个对象就是哪个。比如 UserDaoImpl
		Class c1 = this.getClass(); // 比如：UserDaoImpl 的字节码
		ParameterizedType ptype = (ParameterizedType) c1.getGenericSuperclass(); //得到带有泛型信息的父类型 BaseDao<User>
		clazz = (Class) ptype.getActualTypeArguments()[0];//得到实际的参数类型     User
	}
	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(t);
		tx.commit();
		s.close();
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(t);
		tx.commit();
		s.close();
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		T t = findOne(id);
		s.delete(t);
		tx.commit();
		s.close();
	}

	@Override
	public T findOne(Serializable id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		T t = (T) s.get(clazz, id);//class:leiming 类名：Hibernate要确定从哪张表中查，给定了类型，也就知道了哪张表
						 //Serializable: id:主键
		tx.commit();
		s.close();
		return t;
	}

}
