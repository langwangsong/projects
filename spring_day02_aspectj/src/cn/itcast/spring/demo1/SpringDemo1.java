package cn.itcast.spring.demo1;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 基于AspectJ的注解开发的测试类
 * @author Mr_lang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDemo1 {
	@Resource(name="customerDao")
	private CustomerDao customerDao;
	@Test
	public void demo1(){
		customerDao.add();
		customerDao.delete();
		customerDao.update();	
		customerDao.find();
	}
}
