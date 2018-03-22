package cn.itcast.spring.demo2;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class SpringDemo2 {
	@Resource(name="orderDao")
	private OrderDao orderDao;
	@Test
	public void demo1(){
		orderDao.add();
		orderDao.delete();
		orderDao.update();
		orderDao.find();
	}
}
