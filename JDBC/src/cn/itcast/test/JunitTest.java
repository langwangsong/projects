package cn.itcast.test;

import org.junit.Assert;
import org.junit.Test;

import cn.itcast.demo.Calc;
//测试方法不能有返回值类型，且不能有参数
public class JunitTest {
	@Test
	public void testAdd(){
		Calc c = new Calc();
		Assert.assertEquals(9, c.add(3, 6));
	}
	@Test
	public void testDiv(){
		Calc c = new Calc();
		Assert.assertEquals(3, c.div(10,3),0.4);
	}
}
