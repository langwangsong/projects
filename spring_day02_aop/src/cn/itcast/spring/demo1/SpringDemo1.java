package cn.itcast.spring.demo1;

import org.junit.Test;

/**
 * JDK的动态代理的测试类
 * @author Mr_lang
 *
 */
public class SpringDemo1 {
	@Test
	public void demo1(){
		UserDao userDao = new UserDaoImpl();
		UserDao proxy = new MyJDKProxy(userDao).createProxy();
		proxy.add();
	}
}
