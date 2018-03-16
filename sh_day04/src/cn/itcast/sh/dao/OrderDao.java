package cn.itcast.sh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.sh.domain.Customer;
import cn.itcast.sh.domain.Order;
import cn.itcast.sh.utils.HibernateUtils;

public class OrderDao {

	public static List<Order> findByCid(Integer cid) {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		List<Order> orders = session.createQuery("from Order o where o.customer.cid = ?").setParameter(0, cid).list();
		tx.commit();
		session.close();
		return orders;
	}
	
}
