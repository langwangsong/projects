package cn.itcast.spring.demo4;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDemo4 {
	@Resource(name="productDaoProxy")
	private ProductDao productDao;
	@Test
	public void demo1(){
		productDao.add();
		productDao.delete();
		productDao.update();
		productDao.find();
	}
}
