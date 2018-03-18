package cn.itcast.spring.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试Bean的相关配置
 * @author Mr_lang
 *
 */
public class SpringDemo3 {
	@Test
	public void demo1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService1 = (CustomerService) applicationContext.getBean("customerService");
		CustomerService customerService2 = (CustomerService) applicationContext.getBean("customerService");
		System.out.println(customerService1);
		System.out.println(customerService2);
		
		applicationContext.close();
	}
}
