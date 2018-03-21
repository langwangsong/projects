package cn.itcast.spring.demo5;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo5 {
	@Test
	public void demo1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService orderService = (OrderService) applicationContext.getBean("orderService");
		orderService.save();
	}
}
