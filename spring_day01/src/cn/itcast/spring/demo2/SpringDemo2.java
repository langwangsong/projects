package cn.itcast.spring.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean的实例化的三种方式：
 * @author Mr_lang
 *
 */
public class SpringDemo2 {
	/**
	 * 无参数的构造方法的实例化（默认的）
	 */
	@Test
	public void demo1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean1 b1 = (Bean1) ac.getBean("bean1");
		System.out.println(b1);
	}
	/**
	 * 静态工厂的实例化
	 */
	@Test
	public void demo2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean2 b2 = (Bean2) ac.getBean("bean2");
		System.out.println(b2);
	}
	/**
	 * 实例工厂的实例化
	 */
	@Test
	public void demo3(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean3 b3 = (Bean3) ac.getBean("bean3");
		System.out.println(b3);
	}
}
