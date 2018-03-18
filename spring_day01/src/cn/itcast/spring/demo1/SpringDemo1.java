package cn.itcast.spring.demo1;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

/**
 * Spring的IOC的入门测试类
 * @author Mr_lang
 *
 */
public class SpringDemo1 {
	/**
	 * 传统方式：
	 */
	@Test
	public void demo1(){
		UserService userService = new UserServiceImpl();
		userService.sayHello();
	}
	/**
	 * 使用Spring的方式获得UserService的对象
	 */
	@Test
	public void demo2(){
		//创建一个工厂：
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过工厂获得Bean的实例
		UserService userService = (UserService) applicationContext.getBean("userService");
		
		userService.sayHello();
	}
	/**
	 * 使用Spring读取磁盘路径下的配置文件
	 */
	@Test
	public void demo3(){
		//创建一个工厂：
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("C:\\Users\\Mr_lang\\Desktop\\applicationContext.xml");
		//通过工厂获得Bean的实例
		UserService userService = (UserService) applicationContext.getBean("userService");
		
		userService.sayHello();
	}
	/**
	 * 使用Spring早期的工厂对象：BeanFactory
	 */
	@Test
	public void demo4(){
		//创建一个工厂：
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		//通过工厂获得Bean的实例
		UserService userService = (UserService) beanFactory.getBean("userService");
		
		userService.sayHello();
	}
	/**
	 * 使用Spring早期的工厂对象：BeanFactory.读取磁盘路径下的配置文件
	 */
	@Test
	public void demo5(){
		//创建一个工厂：
		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("C:\\Users\\Mr_lang\\Desktop\\applicationContext.xml"));
		//通过工厂获得Bean的实例
		UserService userService = (UserService) beanFactory.getBean("userService");
		
		userService.sayHello();
	}
}
