package cn.itcast.hibernate.demo1;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate.domain.Customer;
import cn.itcast.hibernate.utils.HibernateUtils;
import edu.emory.mathcs.backport.java.util.Arrays;

/**
 * Hibernate的二级缓存的测试类 ：
 * @author Mr_lang
 *
 */
public class HibernateDemo1 {
	/**
	 * 没有配置二级缓存
	 */
	@Test
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Customer c1 = (Customer) session.get(Customer.class, 1);//发送SQL
		System.out.println(c1);
		tx.commit();
		session.close();
		session = HibernateUtils.openSession();
		tx=session.beginTransaction();
		Customer c2 = (Customer) session.get(Customer.class, 1);//发送SQL
		System.out.println(c2);
		tx.commit();
		session.close();
	}
	/**
	 * 已配置二级缓存
	 */
	@Test
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c1 = (Customer) session.get(Customer.class, 1);//发送SQL
		Customer c2 = (Customer) session.get(Customer.class, 1);//不发送SQL，一级缓存数据
		System.out.println(c1==c2);//true
		
		tx.commit();
		session.close();
		
		session = HibernateUtils.openSession();
		tx=session.beginTransaction();
		Customer c3 = (Customer) session.get(Customer.class, 1);//不发送SQL，使用了二级缓存数据
		Customer c4 = (Customer) session.get(Customer.class, 1);//不发送SQL，使用了一级缓存数据
		System.out.println(c3==c4);//true
		System.out.println(c1==c3);//false
		tx.commit();
		session.close();
	}
	/**
	 * 二级缓存的集合缓存区
	 */
	@Test
	public void demo3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c1 = (Customer) session.get(Customer.class, 1);//发送SQL
		System.out.println(c1.getOrders().size());
		
		tx.commit();
		session.close();
		
		session = HibernateUtils.openSession();
		tx=session.beginTransaction();
		
		Customer c2 = (Customer) session.get(Customer.class, 1);//不发送SQL，使用了二级缓存数据
		System.out.println(c2.getOrders().size());//不发送SQL，使用的是集合缓存区 
		
		tx.commit();
		session.close();
	}
	/**
	 * list方法向二级缓存存放数据，但是不会使用二级缓存的数据
	 */
	@Test
	public void demo4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> cs = session.createQuery("from Customer").list();//会发送
		for (Customer c : cs) {
			System.out.println(c);
		}
		tx.commit();
		session.close();
		
		session = HibernateUtils.openSession();
		tx = session.beginTransaction();
		
		/*cs = session.createQuery("from Customer").list();//会发送
		for (Customer c : cs) {
			System.out.println(c);
		}*/
		
		Customer c = (Customer) session.get(Customer.class, 1);
		System.out.println(c);
		
		tx.commit();
		session.close();
	}
	/**
	 * 使用Iterate方法
	 */
	@Test
	public void demo5(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Iterator<Customer> its = session.createQuery("from Customer").iterate();//发送查询所有客户的cid
		while(its.hasNext()){
			Customer c = its.next(); //根据ID去查询所有数据
			System.out.println(c);
		}
		
		tx.commit();
		session.close();
	}
	/**
	 * 二级缓存中使用Iterate方法
	 */
	@Test
	public void demo6(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Iterator<Customer> its1 = session.createQuery("from Customer").iterate();//发送查询所有客户的cid
		while(its1.hasNext()){
			Customer c = its1.next(); //根据ID去查询所有数据
			System.out.println(c);
		}
		
		tx.commit();
		session.close();
		
		session = HibernateUtils.openSession();
		tx = session.beginTransaction();
		
		Iterator<Customer> its2 = session.createQuery("from Customer").iterate();//发送查询所有客户的cid
		while(its2.hasNext()){
			Customer c = its2.next(); //不发送，使用二级缓存的数据
			System.out.println(c);
		}
		
		tx.commit();
		session.close();
	}
	/**
	 * 以及缓存的更新会同步到二级缓存中
	 */
	@Test
	public void demo7(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c1 = (Customer) session.get(Customer.class, 1);
		c1.setCname("最新名字");
		
		tx.commit();
		session.close();
		
		session = HibernateUtils.openSession();
		tx = session.beginTransaction();
		
		Customer c2 = (Customer) session.get(Customer.class, 1);
		System.out.println(c2);
		tx.commit();
		session.close();
	}
	/**
	 * 将二级缓存中的数据写到硬盘中
	 */
	@Test
	public void demo8(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		session.createQuery("from Order").list();
		tx.commit();
		session.close();
	}
	/**
	 * 更新时间戳区作用
	 */
	@Test
	public void demo9(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Customer c1 = (Customer) session.get(Customer.class, 1);
		session.createQuery("update Customer set cname='任妹妹' where cid=1").executeUpdate();
		tx.commit();
		session.close();
		
		session = HibernateUtils.openSession();
		tx = session.beginTransaction();
		Customer c2 = (Customer) session.get(Customer.class, 1);
		System.out.println(c2);
		tx.commit();
		session.close();
	}
	/**
	 * 查询缓存区
	 */
	@Test
	public void demo10(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Object[]> ls = session.createQuery("select cname,cage from Customer").setCacheable(true).list();
		for (Object[] object : ls) {
			System.out.println(Arrays.toString(object));
		}
		tx.commit();
		session.close();
		
		session = HibernateUtils.openSession();
		tx = session.beginTransaction();
		
		ls = session.createQuery("select cname,cage from Customer").setCacheable(true).list();
		for (Object[] object : ls) {
			System.out.println(Arrays.toString(object));
		}
		
		tx.commit();
		session.close();
	}
}
