package cn.itcast.hibernate.demo5;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate.domain.Customer;
import cn.itcast.hibernate.domain.Order;
import cn.itcast.hibernate.utils.HibernateUtils;

/**
 * Hibernate的抓取策略：
 * 	批量抓取
 * @author Mr_lang
 *
 */
public class HibernateDemo3 {
	/**
	 * 查询客户，抓取订单
	 * 	<set> ...batch-size="3"
	 */
	@Test
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		List<Customer> cs = session.createQuery("from Customer").list();
		for (Customer c : cs) {
			System.out.println(c);
			System.out.println(c.getOrders().size());
		}
		
		tx.commit();
		session.close();
	}
	/**
	 * 查询订单，抓取客户
	 * 	 在一的一方的<class>上配置batch-size
	 */
	@Test
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		List<Order> os = session.createQuery("from Order").list();
		for (Order o : os) {
			System.out.println(o);
			System.out.println(o.getCustomer().getCname());
		}
		
		tx.commit();
		session.close();
	}
}
