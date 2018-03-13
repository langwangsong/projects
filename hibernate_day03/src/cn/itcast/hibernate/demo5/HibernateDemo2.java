package cn.itcast.hibernate.demo5;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate.domain.Order;
import cn.itcast.hibernate.utils.HibernateUtils;

/**
 * Hibernate的抓取策略
 * <maony-to-one>
 * @author Mr_lang
 *
 */
public class HibernateDemo2 {
	/**
	 * 默认情况：
	 */
	@Test
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//查询订单
		Order o = (Order) session.get(Order.class, 1);//发送一条查询订单的SQL
		System.out.println(o);
		System.out.println(o.getCustomer().getCname());//发送一条查询客户的SQL
		tx.commit();
		session.close();
	}
	/**
	 * fetch="join" ：发送一条迫切左外连接查询
	 * 	lazy 失效
	 */
	@Test
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//查询订单
		Order o = (Order) session.get(Order.class, 1);//发送一条迫切左外连接查询其关联对象
		System.out.println(o);
		System.out.println(o.getCustomer().getCname());//不发送SQL
		tx.commit();
		session.close();
	}
	/**
	 * fetch="select" ：发送一条普通SQL查询
	 * 	lazy="false"
	 */
	@Test
	public void demo3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//查询订单
		Order o = (Order) session.get(Order.class, 1);//发送两条SQL，一条查询订单，一条查询客户
		System.out.println(o);
		System.out.println(o.getCustomer().getCname());//不发送SQL
		tx.commit();
		session.close();
	}
	/**
	 * fetch="select" ：发送一条普通SQL查询
	 * 	lazy="proxy"  
	 * 		proxy:代理。当前的对象（客户）是否采用延迟，代理给Customer端的<class>上的lazy处理
	 * 			<class>上的lazy如果为true. 那么proxy相当于true
	 * 			<class>上的lazy如果为false. 那么proxy相当于false
	 */
	@Test
	public void demo4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//查询订单
		Order o = (Order) session.get(Order.class, 1);//发送一条查询订单SQL
		System.out.println(o);
		System.out.println(o.getCustomer().getCname());//发送一条查询客户SQL
		tx.commit();
		session.close();
	}
}
