package cn.itcast.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.itcast.domain.User;

public class HibernateTest02 {
	@Test
	public void testAdd(){
		/**
		 * 1、加载hibernate配置文件及映射文件
		 * 2、得到SessionFactory对象（好比数据库连接池）
		 * 3、得到session对象（好比数据库连接Connection）
		 * 4、开启事务
		 * 5、执行CRUD操作
		 * 6、提交或回滚事务
		 * 7、关闭资源（session关闭，SessionFactory关闭）
		 */
		//1、加载hibernate配置文件及映射文件
		Configuration cfg = new Configuration().configure();
		//cfg.addResource("cn/itcast/domain/User.hbm.xml");//用代码加载映射文件
		//cfg.addClass(User.class);
		
		//2、得到SessionFactory对象（好比数据库连接池）
		SessionFactory sf = cfg.buildSessionFactory();
		//3、得到session对象（好比数据库连接Connection）
		Session session = sf.openSession();
		//4、开启事务
		Transaction tx = session.beginTransaction();
		//5、执行CRUD操作
		User u = new User("admin","admin");
		session.save(u);
		//6、提交或回滚事务 tx.rollback()
		tx.commit();
		//7、关闭资源
		session.close();
		sf.close();
	}
	@Test
	public void testDelete(){
		/**
		 * 1、加载hibernate配置文件及映射文件
		 * 2、得到SessionFactory对象（好比数据库连接池）
		 * 3、得到session对象（好比数据库连接Connection）
		 * 4、开启事务
		 * 5、执行CRUD操作
		 * 6、提交或回滚事务
		 * 7、关闭资源（session关闭，SessionFactory关闭）
		 */
		//1、加载hibernate配置文件及映射文件
		Configuration cfg = new Configuration().configure();
		//2、得到SessionFactory对象（好比数据库连接池）
		SessionFactory sf = cfg.buildSessionFactory();
		//3、得到session对象（好比数据库连接Connection）
		Session session = sf.openSession();
		//4、开启事务
		Transaction tx = session.beginTransaction();
		//5、执行CRUD操作
		User u =(User) session.get(User.class, "402881e462086e440162086e450a0000");//从数据库表中查询指定id的记录
		session.delete(u);
		//6、提交或回滚事务 tx.rollback()
		tx.commit();
		//7、关闭资源
		session.close();
		sf.close();
	}
	@Test
	public void testUpdate(){
		/**
		 * 1、加载hibernate配置文件及映射文件
		 * 2、得到SessionFactory对象（好比数据库连接池）
		 * 3、得到session对象（好比数据库连接Connection）
		 * 4、开启事务
		 * 5、执行CRUD操作
		 * 6、提交或回滚事务
		 * 7、关闭资源（session关闭，SessionFactory关闭）
		 */
		//1、加载hibernate配置文件及映射文件
		Configuration cfg = new Configuration().configure();
		//2、得到SessionFactory对象（好比数据库连接池）
		SessionFactory sf = cfg.buildSessionFactory();
		//3、得到session对象（好比数据库连接Connection）
		Session session = sf.openSession();
		//4、开启事务
		Transaction tx = session.beginTransaction();
		//5、执行CRUD操作
		User u =(User) session.get(User.class, "402881e462086e440162086e450a0000");//从数据库表中查询指定id的记录
		u.setUsername("admin1");
		u.setPassword("admin1");
		session.update(u);
		//6、提交或回滚事务 tx.rollback()
		tx.commit();
		//7、关闭资源
		session.close();
		sf.close();
	}
}
