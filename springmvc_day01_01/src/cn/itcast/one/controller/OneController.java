package cn.itcast.one.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class OneController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		//接收页面参数，验证参数，处理数据，响应处理结果
		mv.addObject("hello","凤姐在美国年薪是30000美元");
		//mv.setViewName("/WEB-INF/jsps/index.jsp");//物理视图
		mv.setViewName("index");
		
		return mv;
	}
	
}
