package cn.itcast.spring.demo6;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spring.demo3.CustomerDao;
import cn.itcast.spring.demo4.ProductDao;

/**
 * 基于切面信息的自动代理
 * @author Mr_lang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class SpringDemo6 {
	@Resource(name="customerDao")
	private CustomerDao customerDao;
	@Resource(name="productDao")
	private ProductDao productDao;
	@Test
	public void demo1(){
		customerDao.add();
		customerDao.delete();
		customerDao.update();
		customerDao.find();
		productDao.add();
		productDao.delete();
		productDao.update();
		productDao.find();
	}
}
