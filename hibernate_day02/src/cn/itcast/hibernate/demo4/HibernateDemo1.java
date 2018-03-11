package cn.itcast.hibernate.demo4;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate.demo1.Customer;
import cn.itcast.hibernate.utils.HibernateUtils;

/**
 * Hibernate操作持久化对象的常用的方法
 * @author Mr_lang
 *
 */
public class HibernateDemo1 {
	//save
	@Test
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Customer customer = new Customer();//瞬时态对象
		customer.setName("小风");
		customer.setAge(38);
		
		session.save(customer);//持久态对象
		
		tx.commit();
		session.close();
	}
	//update
		@Test
		public void demo2(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			/**
			 * 修改脱管态的对象
			 */
			/*Customer customer = new Customer();//瞬时态对象
			 * customer.setId(2);//脱管态对象
				customer.setName("大风");
			
				session.update(customer);//持久态对象
			 */			
			/**
			 * 修改持久态对象
			 */
			Customer customer=(Customer) session.get(Customer.class, 1);
			customer.setName("二王");
			session.clear();
			session.update(customer);
			tx.commit();
			session.close();
		}
		/**
		 * saveOrUpdate
		 */
		@Test
		public void demo3(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			/*Customer customer = new Customer();
			customer.setName("任花");
			customer.setAge(13);*/
			
			/*Customer customer = new Customer();
			customer.setId(4);
			customer.setName("任风");
			customer.setAge(31);*/
			
			Customer customer = new Customer();
			customer.setId(4000);
			customer.setName("任风");
			customer.setAge(31);
			session.saveOrUpdate(customer);
			tx.commit();
			session.close();
		}
		/**
		 * 演示 NonUniqueObjectException:不是唯一对象异常，
		 */
		@Test
		public void demo4(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			Customer customer1 = (Customer) session.get(Customer.class, 1);
			Customer customer2 = new Customer();
			customer2.setId(1);
			customer2.setName("任如");
			session.update(customer2);
			tx.commit();
			session.close();
		}
		/**
		 * merge
		 */
		@Test
		public void demo5(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			/*Customer customer = new Customer();
			customer.setName("任如");
			session.merge(customer);*/
			/*Customer customer = new Customer();
			customer.setId(4);
			customer.setName("任如");
			session.merge(customer);*/
			Customer customer1 = (Customer) session.get(Customer.class, 1);
			Customer customer2 = new Customer();
			customer2.setId(1);
			customer2.setName("任如");
			session.merge(customer2);
			tx.commit();
			session.close();
		}
		/**
		 * delete
		 */
		@Test
		public void demo6(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			/*Customer customer = new Customer();
			customer.setId(5);//托管状态
			session.delete(customer);*/
			Customer customer = (Customer) session.get(Customer.class, 5);//持久态，可以级联删除
			session.delete(customer);
			tx.commit();
			session.close();
		}
}
