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
/**
 * API详解
 * @author Mr_lang
 *
 */
public class HibernateTest05 {
	@Test
	public void testQueryOne(){
		Configuration cfg = new Configuration().configure("abc.cfg.xml");
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
	@Test //预定义sql的查询  （命名查询）
	/*	<sql-query name="queryBySQL">
			select * from User;
		</sql-query>
	*/
	public void testQueryByNamed(){
		Configuration cfg = new Configuration().configure("abc.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//CRUD
		//List<User> users =session.getNamedQuery("queryBySQL").list();
		List<User> users =session.getNamedQuery("queryByHQL").list();
		for (User user : users) {
			System.out.println(user);
		}
		tx.commit();
		session.close();
		sf.close();
	}
}
