package cn.itcast.utils;

import java.util.UUID;

import org.junit.Test;

/**
 * UUID可以生成唯一的字符串
 * @author Mr_lang
 *
 */
public class MyUUIDUtils {
	@Test
	public void run(){
		System.out.println(UUID.randomUUID().toString().replace("-",""));
	}
	//生成唯一的字符串
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-","");
	}
}
