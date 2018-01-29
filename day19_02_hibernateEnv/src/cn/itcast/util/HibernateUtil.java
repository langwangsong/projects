package cn.itcast.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	static{
		Configuration cfg = new Configuration();//创建配置对象
		cfg.configure();//读取hibernate.cfg.xmlzhong的内容
		sessionFactory = cfg.buildSessionFactory();
	}
	//Hibernate中的所有操作都是基于session的
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
}
