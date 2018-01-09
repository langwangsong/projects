package cn.itcast.demo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 处理登录功能
		 * 1、接受请求参数（用户输入的用户名和密码，但是方法没学过，下午要学的，用一下）
		 * 2、判断，如果都是admin，跳转到成功页面，否则跳转到登录页面
		 * 
		 */
		//接受参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//进行判断，如果都是admin，跳转成功，柔则，跳转到 登录页面
		if("admin".equals(password) && "admin".equals(username)){
			//登录成功
			response.sendRedirect("/day09/demo1/success.html");
		}else{
			//登录失败
			response.sendRedirect("/day09/demo1/login.html");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
