package cn.itcast.sh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.sh.domain.Customer;
import cn.itcast.sh.utils.HibernateUtils;

public class CustomerDao {
	//DAO查询所有客户
	public static List<Customer> findAll() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		List<Customer> list = session.createQuery("from Customer").list();
		tx.commit();
		session.close();
		return list;
	}

}
