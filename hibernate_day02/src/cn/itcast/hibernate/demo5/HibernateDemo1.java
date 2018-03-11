package cn.itcast.hibernate.demo5;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate.utils.HibernateUtils;

/**
 * 
 * 一对多的关联关系的测试类
 * @author Mr_lang
 *
 */
public class HibernateDemo1 {
	/**
	 * 向部门和员工表中保存数据
	 */
	@Test
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//创建两个部门
		Department department1 = new Department();
		department1.setDname("教学部");
		Department department2 = new Department();
		department2.setDname("学工部");
		//创建三个员工
		Employee employee1=new Employee();
		employee1.setEname("张三");
		employee1.setAge(3);
		Employee employee2=new Employee();
		employee2.setEname("李四");
		employee2.setAge(4);
		Employee employee3=new Employee();
		employee3.setEname("王五");
		employee3.setAge(5);
		//设置关联关系
		department1.getEmployees().add(employee1);
		department1.getEmployees().add(employee2);
		department2.getEmployees().add(employee3);
		employee1.setDepartment(department1);
		employee2.setDepartment(department1);
		employee3.setDepartment(department2);
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.save(department1);
		session.save(department2);
		tx.commit();
		session.close();
	}
	/**
	 * 保存数据，是保存一方
	 */
	@Test
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//创建一个部门
		Department department1 = new Department();
		department1.setDname("就业部");
		//创建一个员工
		Employee employee3=new Employee();
		employee3.setEname("赵六");
		employee3.setAge(6);
		//设置关联关系
		department1.getEmployees().add(employee3);
		employee3.setDepartment(department1);
		
		//session.save(employee3);//持久态：报异常：瞬时对象异常，持久态关联了一个瞬时态
		session.save(department1);//
		
		tx.commit();
		session.close();
	}
	/**级联保存
	 * 	保存部门级联员工
	 * 	在部门端配置<set>上配置cascade="save-update"
	 */
	@Test
	public void demo3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//创建一个部门
		Department department1 = new Department();
		department1.setDname("就业部");
		//创建一个员工
		Employee employee3=new Employee();
		employee3.setEname("赵六");
		employee3.setAge(6);
		//设置关联关系
		department1.getEmployees().add(employee3);
		employee3.setDepartment(department1);

		session.save(department1);//
		
		tx.commit();
		session.close();
	}
	/**级联保存
	 * 	保存员工级联部门
	 * 	在员工端配置<many-to-one>上配置cascade="save-update"
	 */
	@Test
	public void demo4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//创建一个部门
		Department department1 = new Department();
		department1.setDname("就业部");
		//创建一个员工
		Employee employee3=new Employee();
		employee3.setEname("赵七");
		employee3.setAge(6);
		//设置关联关系
		department1.getEmployees().add(employee3);
		employee3.setDepartment(department1);

		session.save(employee3);//
		
		tx.commit();
		session.close();
	}
	/**
	 * 测试级联保存的导航
	 * 	双方都配置了 cascade
	 */
	@Test
	public void demo5(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//创建1个部门
		Department department1 = new Department();
		department1.setDname("教学部");
		//创建三个员工
		Employee employee1=new Employee();
		employee1.setEname("张三");
		employee1.setAge(3);
		Employee employee2=new Employee();
		employee2.setEname("李四");
		employee2.setAge(4);
		Employee employee3=new Employee();
		employee3.setEname("王五");
		employee3.setAge(5);
		//设置关联关系
		employee1.setDepartment(department1);
		department1.getEmployees().add(employee2);
		department1.getEmployees().add(employee3);
		
		session.save(employee1);//发送几条insert语句。。。4条
		//session.save(employee1);//3条
		//session.save(employee2);//一条
		tx.commit();
		session.close();
	}
	/**
	 * 删除效果
	 * 	删除部门，级联员工
	 */
	@Test
	public void demo6(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Department d1 = (Department) session.get(Department.class, 1);
		session.delete(d1);
		tx.commit();
		session.close();
	}
	/**
	 * 删除效果
	 * 	删除员工，级联部门
	 */
	@Test
	public void demo7(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Employee e1 = (Employee) session.get(Employee.class,3);
		session.delete(e1);
		tx.commit();
		session.close();
	}
	/**
	 * 孤儿删除
	 */
	@Test
	public void demo8(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Department d1 = (Department) session.get(Department.class, 1);
		Employee e1 = (Employee) session.get(Employee.class,1);
		d1.getEmployees().remove(e1);
		tx.commit();
		session.close();
	}
	/**
	 * 双向维护，产生多余的SQL
	 * 	配置inverse="true"：在一的一方放弃
	 */
	@Test
	public void demo9(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Department d1 = (Department) session.get(Department.class, 2);
		Employee e1 = (Employee) session.get(Employee.class,1);
		d1.getEmployees().add(e1);
		e1.setDepartment(d1);
		tx.commit();
		session.close();
	}
	/**
	 * cascade和inverse的区别
	 * 	在部门端配置：cascade="save-update"  inverse="true"
	 * 		cascade :决定关联对象是否保存到数据库
	 * 		inverse :决定的外键
	 */
	@Test
	public void demo10(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Department d1 = (Department) session.get(Department.class, 2);
		d1.setDname("教学部1");
		Employee e1 = (Employee) session.get(Employee.class,1);
		e1.setEname("仁通");
		e1.setAge(18);
		
		d1.getEmployees().add(e1);
		session.save(d1);
		
		tx.commit();
		session.close();
	}
}
