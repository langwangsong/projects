package cn.itcast.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.User;
import cn.itcast.utils.HibernateUtil;
/**
 * 测试工具类的抽取
 * @author Mr_lang
 *
 */
public class HibernateTest07 {
	@Test
	public void testHibernateUtilGet(){
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		//CRUD
		User user =(User) session.get(User.class, "402880e8620a05af01620a05b0430000");//oid加载， 发出sql
		System.out.println(user);
		tx.commit();
		session.close();
	}
	@Test
	public void testHibernateUtilLoad(){
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		//CRUD
		User user =(User) session.load(User.class, "402880e8620a05af01620a05b0430000");//oid加载
		System.out.println(user);//发出sql
		tx.commit();
		session.close();
	}
	/**
	 * load()与get()方法的区别
	 * 	1、load加载数据会采用延迟策略，而get是立即查询
	 * 		延迟加载：当真正使用数据时才会进行加载，否则不加载数据
	 * 	2、load加载的是代理子类对象；而get加载的是本身类对象
	 * 	3、load加载数据当找不到时，会出现异常（不能为null产生代理子类对象）；get不会产生异常
	 */
	/**
	 * SessionFactory默认情况下，内部维护了有一个自己的连接池
	 * 内部维护的连接池是什么呢？
	 * 	通过分析输出的日志，得出连接池的类是：Hibernate built-in connection pool
	 */
}
