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
public class HibernateTest06 {
	@Test
	public void testQueryByNamed(){
		Configuration cfg = new Configuration().configure("def.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session2 = sf.openSession();
		Session session1 = sf.openSession();
		System.out.println(session1==session2);
		Session session3 = sf.getCurrentSession();
		Session session4 = sf.getCurrentSession();
		System.out.println(session3==session4);//出现异常
	}
}
