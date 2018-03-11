package cn.itcast.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.itcast.domain.User;

public class HibernateTest04 {
	@Test
	public void testQueryOne(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//CRUD
		User user = (User) session.get(User.class,"402880e8620a05af01620a05b0430000");
		System.out.println(user);
		
		tx.commit();
		session.close();
		sf.close();
	}
	@Test //查询所有， 使用HQL语句来实现，hibernate query language -->  select 属性  from 类名 where 属性名=?
	public void testQueryAll(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//CRUD
		//Query q = session.createQuery("from User");
		//Query q = session.createQuery("from User where id = '402880e8620a05af01620a05b0430000'");
		//Query q = session.createQuery("from User where id = ?");//占位符参数
		//q.setString(0, "402880e8620a05af01620a05b0430000");
		//Query q = session.createQuery("from User where id =:idss");//命名参数  :后面加一个名称   :id
		//q.setString("idss", "402880e8620a05af01620a05b0430000");
		//Query q = session.createQuery("from User where id =:idss");
		//q.setParameter("idss", "402880e8620a05af01620a05b0430000");
		//Query q = session.createQuery("select id,username,password from User where id =:idss");
		//q.setParameter("idss", "402880e8620a05af01620a05b0430000");
		//Query q = session.createQuery("select * from User as u");  :错误的
		/*List<Object[]> list = q.list();
		for (Object[] obj : list) {
			System.out.println(obj[0]+","+obj[1]+","+obj[2]);
		}*/
		/*Query q = session.createQuery("select count(*) from User as u");
		Object obj = q.uniqueResult();
		System.out.println(obj);*/
		
		/*Query q = session.createQuery("select new User(u.id,u.username,u.password) from User u");
		List<User> list = q.list();
		for (User u : list) {
			System.out.println(u);
		}*/
		
		tx.commit();
		session.close();
		sf.close();
	}
	@Test //QBC查询：query by criteria
	public void testCriteriaAll(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//Criteria对象
		Criteria c = session.createCriteria(User.class);
		c.add(Restrictions.eq("id", "402880e8620e2bd901620e2bda8b0000"));//添加条件
		List<User> list = c.list();
		for (User u : list) {
			System.out.println(u);
		}
		tx.commit();
		session.close();
		sf.close();
	}
	@Test //sql语句查询
	public void testBySQL(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//SQL语句查询
		/*SQLQuery query = session.createSQLQuery("select * from user");
		query.addEntity(User.class);//添加列到对象的属性上
		List<User> list = query.list();*/
		List<User> list = session.createSQLQuery("select * from user").addEntity(User.class).list();
		for (User user : list) {
			System.out.println(user);
		}
		tx.commit();
		session.close();
		sf.close();
	}
}
