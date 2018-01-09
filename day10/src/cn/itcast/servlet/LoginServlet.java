package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求的参数(先解决中文乱码问题)
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//去数据库查询
		UserService us = new UserService();
		User user = us.findByUser(username, password);
		//user有可能为空,如果是 null....
		if(user == null ){
			//说明失败了
			//目的：给用户提示，域对象
			request.setAttribute("msg", "亲！用户名或密码错误！！");
			//使用转发
			request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			//跳转到登录页面
			//response.sendRedirect(request.getContextPath()+"/pages/login.jsp");
		}else{
			response.sendRedirect(request.getContextPath()+"/pages/success.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
