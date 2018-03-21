package cn.itcast.spring.demo2;

import org.junit.Test;

public class SpringDemo2 {
	@Test
	public void demo1(){
		OrderDao orderDao = new OrderDao();
		OrderDao proxy = new MyCglibProxy(orderDao).createProxy();
		proxy.add();
	}
}
