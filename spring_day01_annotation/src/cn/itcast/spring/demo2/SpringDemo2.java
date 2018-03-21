package cn.itcast.spring.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2 {
	@Test
	public void demo1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");
		customerService.save();
	}
}
