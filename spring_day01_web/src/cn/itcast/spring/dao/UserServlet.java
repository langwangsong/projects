package cn.itcast.spring.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.spring.service.UserService;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");*/
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		UserService userService = (UserService) applicationContext.getBean("userService");
		System.out.println("UserServlet中的save方法执行了...");
		userService.save();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
