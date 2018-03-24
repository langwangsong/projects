package cn.itcast.spring.demo2;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 声明式事务管理的一种：基于TransactionProxyFactoryBean的方式
 * @author Mr_lang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class SpringDemo2 {
	@Resource(name="accountServiceProxy")
	private AccountService accountService;
	@Test
	public void demo1(){
		accountService.transfer("任童", "老王", 100d);
	}
}
