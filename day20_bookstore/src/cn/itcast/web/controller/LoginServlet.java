package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.service.PrivilegeService;
import cn.itcast.service.impl.PrivilegeServiceImpl;

public class LoginServlet extends HttpServlet {
	private PrivilegeService privilegeService = new PrivilegeServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = privilegeService.login(username,password);
		if(user == null){
			response.getWriter().write("错误的用户名或密码，2秒后转向登录页面");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/passport/login.jsp");
			return;
		}
		//成功
		request.getSession().setAttribute("user", user);
		response.getWriter().write("登录成功，2秒后转向后台管理页面");
		response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/manage/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
