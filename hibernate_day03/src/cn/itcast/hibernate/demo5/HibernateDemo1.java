package cn.itcast.hibernate.demo5;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate.domain.Customer;
import cn.itcast.hibernate.utils.HibernateUtils;

/**
 * Hibernate的抓取策略
 * 	<set>集合端
 * @author Mr_lang
 *
 */
public class HibernateDemo1 {
	/**
	 * 测试默认的情况：
	 */
	@Test
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//查询1号客户
		Customer c = (Customer) session.get(Customer.class, 1);//发送查询1号客户的SQL
		System.out.println(c);
		System.out.println(c.getOrders().size());//发送查询1号客户所有订单的SQL
		tx.commit();
		session.close();
	}
	/**
	 * 测试fetch="join"的情况：发送一条连接查询查询其关联对象
	 * 	如果fetch="join" 那么lazy会被忽略
	 */
	@Test
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//查询1号客户
		Customer c = (Customer) session.get(Customer.class, 1);//发送一条迫切左外连接查询其关联对象
		System.out.println(c);
		System.out.println(c.getOrders().size());//不发送SQL
		tx.commit();
		session.close();
	}
	/**
	 * 测试fetch="select"的情况：发送一条查询语句.....和默认的一样
	 * 	如果lazy="true"
	 */
	@Test
	public void demo3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//查询1号客户
		Customer c = (Customer) session.get(Customer.class, 1);///发送查询1号客户的SQL
		System.out.println(c);
		System.out.println(c.getOrders().size());//发送查询1号客户所有订单的SQL
		tx.commit();
		session.close();
	}
	/**
	 * 测试fetch="select"的情况：
	 * 	如果lazy="false"
	 */
	@Test
	public void demo4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//查询1号客户
		Customer c = (Customer) session.get(Customer.class, 1);///发送两条select SQL语句，查询1号客户的SQL,查询订单的SQL
		System.out.println(c);
		System.out.println(c.getOrders().size());//不发送SQL
		tx.commit();
		session.close();
	}
	/**
	 * 测试fetch="select"的情况：
	 * 	如果lazy="extra":
	 */
	@Test
	public void demo5(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//查询1号客户
		Customer c = (Customer) session.get(Customer.class, 1);///发送查询1号客户的SQL
		System.out.println(c);
		System.out.println(c.getOrders().size());//发送select count(*) 的SQL where cnum=?
		tx.commit();
		session.close();
	}
	/**
	 * 测试fetch="subselect"的情况： 发送一条子查询查询其关联对象（****不能用 get测试，必须使用list方法）
	 * 	lazy="true"
	 */
	@Test
	public void demo6(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//查询所有客户
		List<Customer> cs = session.createQuery("from Customer").list();//发送查询所有客户的SQL
		for (Customer c : cs) {
			System.out.println(c);
			System.out.println(c.getOrders().size());//发送一条子查询查询所有客户订单的SQL
		}
		tx.commit();
		session.close();
	}
	/**
	 * 测试fetch="subselect"的情况： 发送一条子查询查询其关联对象（****不能用 get测试，必须使用list方法）
	 * 	lazy="false"
	 */
	@Test
	public void demo7(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//查询所有客户
		List<Customer> cs = session.createQuery("from Customer").list();//发送查询所有客户的SQL
		for (Customer c : cs) {
			System.out.println(c);
			System.out.println(c.getOrders().size());//发送查询数量的SQL
		}
		tx.commit();
		session.close();
	}
	/**
	 * 测试fetch="subselect"的情况： 发送一条子查询查询其关联对象（****不能用 get测试，必须使用list方法）
	 * 	lazy="extra"
	 */
	@Test
	public void demo8(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//查询所有客户
		List<Customer> cs = session.createQuery("from Customer").list();//发送查询所有客户的SQL，同时发送子查询查询客户的订单的SQL
		for (Customer c : cs) {
			System.out.println(c);
			System.out.println(c.getOrders().size());//不发送SQL
		}
		tx.commit();
		session.close();
	}
}
