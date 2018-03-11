package cn.itcast.hibernate.demo2;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate.demo1.Customer;
import cn.itcast.hibernate.utils.HibernateUtils;

/**
 * 测试Hibernate的持久化的状态
 * @author Mr_lang
 *
 */
public class HibernateDemo1 {
	@Test
	/**
	 * 区分持久化对象的三种状态
	 */
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Customer customer = new Customer();//瞬时态：没有持久化标识OID，没有与session关联
		customer.setName("老王");
		customer.setAge(19);
		Serializable cid = session.save(customer);//持久态： 有唯一标识OID。与session关联
		System.out.println(customer.getName());
		
		tx.commit();
		session.close();
		System.out.println(customer.getName());//脱管态：有唯一标识，没有与session关联
	}
	@Test
	/**
	 * 持久态的对象可以自动更新数据库
	 */
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//获得持久态的：
		Customer customer = (Customer) session.get(Customer.class, 1);
		customer.setName("小王");
		//session.update(customer);
		tx.commit();
		session.close();
	}
}
