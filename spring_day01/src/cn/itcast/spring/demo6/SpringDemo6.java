package cn.itcast.spring.demo6;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo6 {
	@Test
	public void demo1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext2.xml");
		CollectionBean collectionBean = (CollectionBean) applicationContext.getBean("collectionBean");
		System.out.println(collectionBean);
	}
}
