package cn.itcast.spring.demo4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean的完整生命周期的测试
 * @author Mr_lang
 *
 */
public class SpringDemo4 {
	@Test
	public void demo1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService orderService = (OrderService) applicationContext.getBean("orderService");
		orderService.save();
		orderService.update();
		applicationContext.close();
	}
}
