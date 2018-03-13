package cn.itcast.hibernate.demo4;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate.domain.Customer;
import cn.itcast.hibernate.utils.HibernateUtils;

/**
 * 测试类级别的延迟
 * @author Mr_lang
 *
 */
public class HibernateDemo1 {
	@Test
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = (Customer) session.load(Customer.class, 1);
		Hibernate.initialize(c);
		System.out.println(c);
		tx.commit();
		session.close();
	}
}
