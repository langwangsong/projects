package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.itcast.domain.QueryVo;
import cn.itcast.domain.User;

@Controller
@RequestMapping("/user1")
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
	//model就相当于application这个域，顶层对象Map
	@RequestMapping("save")
	public String saveUser(User user,Model model) {
		System.out.println(user);
		model.addAttribute("user",user);
		return "success";
	}
	//传递数组参数
	@RequestMapping("delete")
	public String delete(Integer[] ids) {
		System.out.println(ids);
		return "success";
	}
	//使用包装类接受参数
	@RequestMapping("receivePos")
	public String receivePos(QueryVo vo) {
		System.out.println(vo);
		return "success";
	}
	//接收List集合参数
	@RequestMapping("receiveList")
	public String receiveList(QueryVo vo) {
		System.out.println(vo);
		return "success";
	}
	//接收map类型参数
	@RequestMapping("receiveMap")
	public String receiveMap(QueryVo vo) {
		System.out.println(vo);
		return "success";
	}
}
