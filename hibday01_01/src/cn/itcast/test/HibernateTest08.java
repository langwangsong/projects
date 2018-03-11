package cn.itcast.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.User;
import cn.itcast.utils.HibernateUtil;
/**
 * 测试不开启事务也可以实现事务的自动提交
 * @author Mr_lang
 *
 */
public class HibernateTest08 {
	@Test 
	public void testHibernateUtilGet(){
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		//CRUD
		Query query = session.createQuery("from User");
		query.setFirstResult(3);//(2-1)*3第二页的3条
		query.setMaxResults(3);
		List<User> users = query.list();
		for (User user : users) {
			System.out.println(user);
		}
		tx.commit();
		session.close();
	}
}
