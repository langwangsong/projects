package cn.itcast.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import cn.itcast.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("findAllUser")
	public String findAllUser(Model model) {
		List<User> list = new ArrayList<User>();
		User user1 = new User();
		user1.setId(1);
		user1.setUsername("张三丰1111");
		user1.setSex("男");
		user1.setBirthday(new Date());
		
		User user2 = new User();
		user2.setId(2);
		user2.setUsername("张三丰1111");
		user2.setSex("男");
		user2.setBirthday(new Date());
		
		User user3 = new User();
		user3.setId(3);
		user3.setUsername("张三丰1111");
		user3.setSex("男");
		user3.setBirthday(new Date());
		
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		model.addAttribute("list",list);
		
		
		return "list";
	}
	@RequestMapping("/update/{id}")
	public String update(@PathVariable Integer id) {
		System.out.println(id);
		return "success";
	}
	@RequestMapping("param")
	public String requestParam(@RequestParam(value="myID",required=true,defaultValue="222")Integer id) {
		System.out.println(id);
		return "success";
	}
/*	//测试同一类进行重定向:第一种方式
	@RequestMapping("add")
	public String add() {
		return "redirect:findAllUser.do";
	}
	//测试同一类进行重定向：第二种方式
	@RequestMapping("add")
	PublicId String add() {
		return "redirect:/user/findAllUser.do";
	}
	//测试跨类进行重定向
	@RequestMapping("add")
	public String add() {
		return "redirect:/order/findOrder.do";
	}
	//测试同一个类进行转发：第一种方式
	@RequestMapping("add")
	public String add() {
		return "forward:findAllUser.do";
	}
	//测试同一个类进行转发：第二种方式
	@RequestMapping("add")
	public String add() {
		return "forward:/user/findAllUser.do";
	}
	//测试跨类进行转发
	@RequestMapping("add")
	public String add() {
		return "forward:/order/findOrder.do";
	}*/
}
