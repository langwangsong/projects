package cn.itcast.hibernate.demo2;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate.domain.Customer;
import cn.itcast.hibernate.domain.Order;
import cn.itcast.hibernate.utils.HibernateUtils;

/**
 * Hibernate的检索方式：HQL检索
 * @author Mr_lang
 *
 */
public class HibernateDemo1 {
	/**
	 * 数据的初始化
	 */
	@Test
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//初始化1个客户
		Customer c1 = new Customer();
		c1.setCname("c3");
		c1.setCage(38);
		//10个订单
		for (int i = 1; i <= 10; i++) {
			Order o = new Order();
			o.setAddr(i+"弄");
			o.setCustomer(c1);
			c1.getOrders().add(o);
			session.save(o);
		}
		session.save(c1);
		tx.commit();
		session.close();
	}
	/**
	 * HQL的简单查询
	 */
	@Test
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//1.查询所有的客户：
		//Query q = session.createQuery("from Customer");
		//2.起别名查询
		//Query q = session.createQuery("from Customer c");
		Query q = session.createQuery("select c from Customer c");
		
		List<Customer> list = q.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		tx.commit();
		session.close();
	}
	/**
	 * HQL的多态查询
	 */
	@Test
	public void demo3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		List list = session.createQuery("from java.lang.Object").list();
		System.out.println(list);
		tx.commit();
		session.close();
	}
	/**
	 * HQL的排序查询
	 */
	@Test
	public void demo4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		List list = session.createQuery("from Customer order by cage desc").list();
		System.out.println(list);
		tx.commit();
		session.close();
	}
	/**
	 * HQL的分页查询
	 */
	@Test
	public void demo5(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//查询所有的订单，并对其进行分页。每页显示10条
		Query q = session.createQuery("from Order");
		q.setFirstResult(20);
		q.setMaxResults(10);
		List list = q.list();
		System.out.println(list);
		tx.commit();
		session.close();
	}
	/**
	 * HQL的单个查询
	 */
	@Test
	public void demo6(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//查询所有的订单，并对其进行分页。每页显示10条
		Customer c = (Customer) session.createQuery("from Customer where cname='c2'").uniqueResult();
		System.out.println(c);
		tx.commit();
		session.close();
	}
	/**
	 * HQL的条件查询
	 * 	两种方式设置参数：
	 * 		按位置绑定参数
	 * 		按名称绑定参数
	 */
	@Test
	public void demo7(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//查询年龄大于20
		//List<Customer> cs = session.createQuery("from Customer where cage > ?").setInteger(0, 20).list();
		//List<Customer> cs = session.createQuery("from Customer where cage > :aaa").setInteger("aaa", 30).list();
		List<Customer> cs = session.createQuery("from Customer where cname like :bbb and cage > :aaa").setInteger("aaa", 30).setString("bbb", "c%").list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		tx.commit();
		session.close();
	}
	/**
	 * HQL的投影查询
	 */
	@Test
	public void demo8(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//查询所有员工的名称
		//List<Integer> cs = session.createQuery("select cage from Customer").list();
		//所有员工的名称和年龄
		//List<Object[]> cs = session.createQuery("select cname,cage from Customer").list();
		//使用个构造方法的形式
		List<Customer> cs = session.createQuery("select new Customer(cname,cage) from Customer").list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		tx.commit();
		session.close();
	}
	/**
	 * HQL的聚合函数
	 */
	@Test
	public void demo9(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//统计订单个数
		Long c = (Long) session.createQuery("select count(*) from Customer").uniqueResult();
		System.out.println(c);
		tx.commit();
		session.close();
	}
	/**
	 * HQL的分组查询
	 */
	@Test
	public void demo10(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//每个客户的订单个数
		List<Object[]> os =session.createQuery("select c.cname,count(*) from Order o,Customer c where o.customer.cid = c.cid group by c.cname").list();
		for (Object[] o : os) {
			System.out.println(Arrays.toString(o));
		}
		tx.commit();
		session.close();
	}
	/**
	 * HQL的内连接查询
	 */
	@Test
	public void demo11(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//HQL内连接：封装到Object数组中
		//隐式内连接 select * from A,B where A.id=B.id;
		//显示内连接
		/*List<Object[]> cs = session.createQuery("from Customer c inner join c.orders").list();
		for (Object[] object : cs) {
			System.out.println(Arrays.toString(object));
		}*/
		//HQL迫切内连接   inner join fetch :数据封装到对象
		List<Customer> cs = session.createQuery("select distinct c from Customer c inner join fetch c.orders").list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		tx.commit();
		session.close();
	}
	/**
	 * HQL的命名查询
	 */
	@Test
	public void demo12(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		List<Customer> cs =session.getNamedQuery("findAll").list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		tx.commit();
		session.close();
	}
	
}
