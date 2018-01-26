package cn.itcast.jsonlib;

import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 测试JSONLib工具类使用
 * @author Mr_lang
 *
 */
public class JsonDemo {
	@Test
	public void run1(){
		//把JavaBean转换成json的数据格式的字符串
		JSONObject json = new JSONObject();
		json.put("name", "张三");
		json.put("age", 18);
		System.out.println(json.toString());
	}
	@Test
	public void run2(){
		//把JavaBean转换成json的数据格式的字符串
		JSONObject json = new JSONObject();
		User user = new User();
		user.setUsername("张三");
		user.setPassword("123");
		json.put("user", user);
		//先使用eval执行下
		//alert(p.user.username)；
		System.out.println(json.toString());
	}
	@Test
	public void run3(){
		User user = new User();
		user.setUsername("张三");
		user.setPassword("123");
		JSONObject json = JSONObject.fromObject(user);
		System.out.println(json.toString());
	}
	@Test
	public void run4(){
		JSONArray json = new JSONArray();
		User user = new User();
		user.setUsername("张三");
		user.setPassword("123");
		json.add(user);
		//alert(p[0].username)
		System.out.println(json.toString());
	}
}
