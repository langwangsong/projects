package cn.itcast.spring.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo3 {
	@Test
	public void demo1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
		Bean1 bean2 = (Bean1) applicationContext.getBean("bean1");
		System.out.println(bean1 == bean2);
		applicationContext.close();
	}
}
