package cn.itcast.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("toJson")
	public String toJson() {
		return "requestJson";
	}
	//请求JSON，返回json
	@RequestMapping("requestJson")
	public @ResponseBody User requestJson(@RequestBody User user) {
		System.out.println(user);
		return user;
	}
	@RequestMapping("requestPo")
	public @ResponseBody User requestPo(User user) {
		System.out.println(user);
		return user;
	}
	@RequestMapping("viewJsonXml")
	public User viewJsonXml() {
		User user = new User();
		user.setAddress("北京");
		user.setBirthday(new Date());
		user.setUsername("王晓华");
		user.setSex("男");
		user.setId(1);
		return user;
	}
}
