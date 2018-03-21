package cn.itcast.spring.demo3;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
/**
 * 不带有切入点的切面的测试类
 * @author Mr_lang
 *
 */
public class SpringDemo3 {
	
	//@Resource(name="customerDao")
	@Resource(name="customerDaoProxy")
	private CustomerDao customerDao;
	@Test
	public void demo1(){
		customerDao.add();
		customerDao.delete();
		customerDao.update();
		customerDao.find();
	}
}
