package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class MyController {
	@RequestMapping(value="/hello.do",method= {RequestMethod.GET,RequestMethod.POST})
	public String helloWorld() {
		return "index";
	}
	//接收基本类型的参数,并且在页面回显
	@RequestMapping("receive")
	public String receive(Integer id,Model model) {
		//将数据放到model对象，页面进行获取
		model.addAttribute("id",id);
		return "success";
	}
}
