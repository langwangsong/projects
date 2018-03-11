package cn.itcast.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.User;
import cn.itcast.utils.HibernateUtil;
/**
 * 测试表结构的生成
 * @author Mr_lang
 *
 */
public class HibernateTest09 {
	@Test 
	public void testHibernateUtilGet(){
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(new User("abc","马乐"));
		tx.commit();
		session.close();
	}
}
