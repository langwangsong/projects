package cn.itcast.spring.demo3;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 基于AspectJ的XML方式的声明式事务管理
 * @author Mr_lang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class SpringDemo3 {
	@Resource(name="accountService")
	private AccountService accountService;
	@Test
	public void demo1(){
		accountService.transfer("老王", "任童", 300d);
	}
}
