package cn.itcast.spring.demo4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo4 {
	@Test
	public void demo1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Product product = (Product) applicationContext.getBean("product");
		Car car = (Car) applicationContext.getBean("car");
		System.out.println(product);
		System.out.println(car);
	}
}
