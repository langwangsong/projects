package cn.itcast.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.Student;
import cn.itcast.util.HibernateUtil;

public class HibernateDemo {
	@Test(timeout=1000) //属性timeout=1000毫秒。测试方法的执行效率，超时也算失败
	public void test(){
		Student s = new Student();
		s.setName("王乐");
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();//开启事务
		session.save(s);//保存数据
		tx.commit();//提交事务
		session.close();//释放资源
	}
}
