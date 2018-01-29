package cn.itcast.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
/**
 * 登录的功能
 * @author Mr_lang
 *
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 接受表单数据，封装到User对象中
		 * 去dao层查询数据，返回user对象
		 * 如果user==null，登录失败
		 * 如果user！=null， 登陆成功，需要把user存入到session中，重新定向到成功页面
		 */
		User user= new User();
		user.setId("1");
		user.setUsername("aaa");
		user.setPassword("aaa");
		request.getSession().setAttribute("existUser", user);
		//重定向
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
