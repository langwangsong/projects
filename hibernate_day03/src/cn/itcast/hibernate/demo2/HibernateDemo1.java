package cn.itcast.hibernate.demo2;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate.domain.Customer;
import cn.itcast.hibernate.domain.Order;
import cn.itcast.hibernate.utils.HibernateUtils;

/**
 * Hibernate的检索方式：HQL检索
 * @author Mr_lang
 *
 */
public class HibernateDemo1 {
	/**
	 * 数据的初始化
	 */
	@Test
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//初始化1个客户
		Customer c1 = new Customer();
		c1.setCname("c3");
		c1.setCage(28);
		//10个订单
		for (int i = 1; i <= 10; i++) {
			Order o = new Order();
			o.setAddr(i+"弄");
			o.setCustomer(c1);
			c1.getOrders().add(o);
			session.save(o);
		}
		session.save(c1);
		tx.commit();
		session.close();
	}
	/**
	 * HQL的简单查询
	 */
	@Test
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//1.查询所有的客户：
		//Query q = session.createQuery("from Customer");
		//2.起别名查询
		//Query q = session.createQuery("from Customer c");
		Query q = session.createQuery("select c from Customer c");
		
		List<Customer> list = q.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		tx.commit();
		session.close();
	}
	/**
	 * HQL的多态查询
	 */
	@Test
	public void demo3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		List list = session.createQuery("from java.lang.Object").list();
		System.out.println(list);
		tx.commit();
		session.close();
	}
}
