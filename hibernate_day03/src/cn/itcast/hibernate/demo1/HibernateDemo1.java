package cn.itcast.hibernate.demo1;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate.utils.HibernateUtils;

/**
 * 多对多的测试
 * @author Mr_lang
 *
 */
public class HibernateDemo1 {
	@Test
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//创建两个学生
		Student s1 = new Student();
		s1.setSname("张三");
		Student s2 = new Student();
		s2.setSname("李四");
		//创建三门课程
		Course c1 = new Course();
		c1.setCname("java");
		Course c2 = new Course();
		c2.setCname("c++");
		Course c3 = new Course();
		c3.setCname("sql");
		
		//设定关系：
		
		s1.getCourses().add(c1);
		s1.getCourses().add(c2);
		s2.getCourses().add(c2);
		s2.getCourses().add(c3);
		c1.getStudents().add(s1);
		c2.getStudents().add(s1);
		c2.getStudents().add(s2);
		c3.getStudents().add(s2);
		
		session.save(s1);
		session.save(s2);
		session.save(c1);
		session.save(c2);
		session.save(c3);
		
		tx.commit();
		session.close();
	}
	/**
	 * 级联操作
	 * 	保存学生级联课程
	 * 	在学生端配置：cascade="save-update"
	 */
	@Test
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//创建两个学生
		Student s1 = new Student();
		s1.setSname("张三");
		//创建三门课程
		Course c1 = new Course();
		c1.setCname("java");
		
		//设定关系：
		
		s1.getCourses().add(c1);
		c1.getStudents().add(s1);
		
		session.save(s1);
		
		tx.commit();
		session.close();
	}
	/**
	 * 级联操作
	 * 	保存课程级联学生
	 * 	在课程端配置：cascade="save-update"
	 */
	@Test
	public void demo3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//创建两个学生
		Student s1 = new Student();
		s1.setSname("张三");
		//创建三门课程
		Course c1 = new Course();
		c1.setCname("java");
		
		//设定关系：
		
		s1.getCourses().add(c1);
		c1.getStudents().add(s1);
		
		session.save(c1);
		
		tx.commit();
		session.close();
	}
	/**
	 * 级联操作
	 * 	删除学生级联课程
	 * 	在学生端配置cascade="delete"
	 */
	@Test
	public void demo4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Student s = (Student) session.get(Student.class, 1);
		
		session.delete(s);
		
		tx.commit();
		session.close();
	}
	/**
	 * 级联操作
	 * 	删除课程级联学生
	 * 	在课程端配置cascade="delete"
	 */
	@Test
	public void demo5(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Course c = (Course) session.get(Course.class, 3);
		
		session.delete(c);
		
		tx.commit();
		session.close();
	}
	/**
	 * 学生选课操作
	 */
	@Test
	public void demo6(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		/**
		 * 让1号学生选择3号课
		 */
		/*Student s = (Student) session.get(Student.class, 1);
		Course c = (Course) session.get(Course.class, 3);
		
		s.getCourses().add(c);*/
		/**
		 * 让2号学生退选2号课程，改选1号课程
		 */
		Student s = (Student) session.get(Student.class, 2);
		Course c2 = (Course) session.get(Course.class, 2);
		Course c1 = (Course) session.get(Course.class, 1);
		s.getCourses().remove(c2);
		s.getCourses().add(c1);
		
		tx.commit();
		session.close();
	}
}
