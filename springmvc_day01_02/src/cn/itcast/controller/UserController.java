package cn.itcast.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
