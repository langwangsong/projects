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
	//DAO保存客户
	public static void save(Customer customer) {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
		session.close();
	}
	//DAO根据ID查询客户
	public static Customer findById(Integer cid) {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Customer c = (Customer) session.get(Customer.class,cid);
		tx.commit();
		session.close();
		return c;
	}
	//DAO修改用户
	public static void update(Customer customer) {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		session.update(customer);
		tx.commit();
		session.close();
	}
	//DAO删除用户
	public static void delete(Customer customer) {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(customer);
		tx.commit();
		session.close();
	}

}
