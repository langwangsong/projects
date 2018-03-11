package cn.itcast.hibernate.demo3;

import java.io.Serializable;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate.demo1.Customer;
import cn.itcast.hibernate.utils.HibernateUtils;

/**
 * 测试Hibernate的以及缓存的类
 * @author Mr_lang
 *
 */
public class HibernateDemo1 {
	/**
	 *以及缓存的管理的方法：
	 *	refresh(Object obj) :快照的数据覆盖了一级缓存的数据
	 */
	@Test
	public void demo7(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, 1);
		customer.setName("小风");
		session.refresh(customer);
		tx.commit();
		session.close();
	}
	/**
	 *以及缓存的管理的方法：
	 *	evict(Object obj) :清空某个对象
	 */
	@Test
	public void demo6(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Customer customer1 = (Customer) session.get(Customer.class, 1);
		session.evict(customer1);
		Customer customer2 = (Customer) session.get(Customer.class, 1);
		tx.commit();
		session.close();
	}
	/**
	 *以及缓存的管理的方法：
	 *	clear() :清空缓存
	 */
	@Test
	public void demo5(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Customer customer1 = (Customer) session.get(Customer.class, 1);
		session.clear();
		Customer customer2 = (Customer) session.get(Customer.class, 1);
		session.flush();
		tx.commit();
		session.close();
	}
	/**
	 *以及缓存的管理的方法：
	 *	flush() :刷出缓存
	 *		*默认刷出时机：执行某些查询的时候，事务提交的时候，或者手动调用flush的时候
	 */
	@Test
	public void demo4(){
		Session session = HibernateUtils.openSession();
		//session.setFlushMode(FlushMode.AUTO);
		
		Transaction tx = session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, 1);
		customer.setName("大王");
		session.flush();
		tx.commit();
		session.close();
	}
	/**
	 * 证明HIbernate的以及缓存的存在
	 */
	@Test
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		/**
		 * 2.先后两次执行get方法
		 */
		Customer customer01 = (Customer) session.get(Customer.class, 1);//发送SQL向缓存中存入一份
		Customer customer02 = (Customer) session.get(Customer.class, 1);//不发送SQL从以及缓存中获取数据
		System.out.println(customer01==customer02);
		
		tx.commit();
		session.close();
	}
	@Test
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		/**
		 * 1.先保存值
		 */
		Customer customer = new Customer();
		customer.setName("老王");
		customer.setAge(20);
		Serializable id = session.save(customer);//保存数据,向缓存中存了一个
		Customer customer2 = (Customer) session.get(Customer.class, id);//没有发送sql语句，直接从缓存中获取
		System.out.println(customer2);
		tx.commit();
		session.close();
	}
}
