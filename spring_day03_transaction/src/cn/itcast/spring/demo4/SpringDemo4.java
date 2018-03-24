package cn.itcast.spring.demo4;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 基于AspectJ的注解方式的声明式事务管理
 * @author Mr_lang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext4.xml")
public class SpringDemo4 {
	@Resource(name="accountService")
	private AccountService accountService;
	@Test
	public void demo1(){
		accountService.transfer("任童", "老王", 300d);
	}
}
