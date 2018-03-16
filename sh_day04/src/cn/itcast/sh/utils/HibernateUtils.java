package cn.itcast.sh.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	static{
		sf = new Configuration().configure().buildSessionFactory();
	}
	/**
	 * 获取session
	 */
	public static Session openSession(){
		return sf.openSession();
	}
	/**
	 * 获取与本地线程绑定的session
	 */
	public static Session getCurrentSession(){
		return sf.getCurrentSession();
	}
	public static void main(String[] args) {
		HibernateUtils u = new HibernateUtils();
	}
}
