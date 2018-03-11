package cn.itcast.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate.utils.HibernateUtils;

/**
 * Hibernate的主键生成策略
 * @author Mr_lang
 *
 */
public class HibernateDemo1 {
	@Test//测试 increment：
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Customer customer = new Customer();
		customer.setName("凤姐");
		customer.setAge(23);
		session.save(customer);
		tx.commit();
		session.close();
	}
	@Test//测试 increment：
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Customer customer = new Customer();
		customer.setName("老王");
		customer.setAge(32);
		session.save(customer);
		tx.commit();
		session.close();
	}
}
