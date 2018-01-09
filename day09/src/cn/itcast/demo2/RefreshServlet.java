package cn.itcast.demo2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 要完成页面的定时跳转
 * @author Mr_lang
 *
 */
public class RefreshServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//输出一句话
		System.out.println("RefreshServlet被访问了...");
		//设置一个响应头  refresh 注意：值的写法
		response.setHeader("refresh", "5;url=/day09/demo1/login.html");
		
		response.setContentType("text/html;charset=UTF-8");
		//向页面响应中文
		
		response.getWriter().print("<h3>页面将在5秒后跳转</h3>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
