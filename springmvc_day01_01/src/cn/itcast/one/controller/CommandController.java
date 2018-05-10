package cn.itcast.one.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import cn.itcast.domain.User;

public class CommandController extends AbstractCommandController {
	//接收参数
	//绑定参数到JavaBean
	public CommandController() {
		this.setCommandClass(User.class);
	}
	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command, BindException ex)
			throws Exception {
		User user = (User) command;
		System.out.println(user.getAddress());
		//把User放入到model里面，在页面回显
		ModelAndView mv = new ModelAndView();
		mv.addObject("user",user);
		//设置返回逻辑视图
		mv.setViewName("index");
		return mv;
	}
	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		String string = request.getParameter("birthday");
		if(string.contains("/")){
			binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true));
		}else{
			binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		}
		
	}
}
