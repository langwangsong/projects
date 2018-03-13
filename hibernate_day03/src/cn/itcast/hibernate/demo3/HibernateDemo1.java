package cn.itcast.hibernate.demo3;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.itcast.hibernate.domain.Customer;
import cn.itcast.hibernate.domain.Order;
import cn.itcast.hibernate.utils.HibernateUtils;

/**
 * Hibernate的检索方式：QBC检索
 * @author Mr_lang
 *
 */
public class HibernateDemo1 {
	/**
	 * 查询所有
	 */
	@Test
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> cs = criteria.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		tx.commit();
		session.close();
	}
	/**
	 * 查询分页
	 */
	@Test
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.setFirstResult(20);
		criteria.setMaxResults(10);
		List<Order> cs = criteria.list();
		for (Order c : cs) {
			System.out.println(c);
		}
		tx.commit();
		session.close();
	}
	/**
	 * 查询排序
	 */
	@Test
	public void demo3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.addOrder(org.hibernate.criterion.Order.desc("cage"));
		List<Customer> cs = criteria.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		tx.commit();
		session.close();
	}
	/**
	 * 查询条件
	 */
	@Test
	public void demo4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.like("cname", "%c%"));
		criteria.add(Restrictions.gt("cage", 30));
		List<Customer> cs = criteria.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		tx.commit();
		session.close();
	}
	/**
	 * 离线条件查询
	 */
	@Test
	public void demo5(){
		DetachedCriteria dtc = DetachedCriteria.forClass(Customer.class);
		dtc.add(Restrictions.gt("cage", 20));
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> cs = dtc.getExecutableCriteria(session).list();
		
		for (Customer c : cs) {
			System.out.println(c);
		}
		tx.commit();
		session.close();
	}
	/**
	 * SQL查询
	 */
	@Test
	public void demo6(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		/*List<Object[]> cs = session.createSQLQuery("select * from customers").list();
		for (Object[] c : cs) {
			System.out.println(Arrays.toString(c));
		}*/
		SQLQuery query = session.createSQLQuery("select * from customers");
		query.addEntity(Customer.class);
		List<Customer> cs = query.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		tx.commit();
		session.close();
	}
}
