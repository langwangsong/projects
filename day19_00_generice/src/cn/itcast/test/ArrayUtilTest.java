package cn.itcast.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import cn.itcast.util.ArrayUtil;

public class ArrayUtilTest {

	@Test
	public void testExchange() {
		Integer ii[] = {1,2,3,4,5,6,7,8,9,0};
		ArrayUtil.exchange(ii, 1, 4);
		System.out.println(Arrays.asList(ii));
	}
	@Test
	public void testReverse() {
		Integer ii[] = {1,2,3,4,5,6,7,8,9,0};
		ArrayUtil.reverse(ii);
		System.out.println(Arrays.asList(ii));
	}
}
