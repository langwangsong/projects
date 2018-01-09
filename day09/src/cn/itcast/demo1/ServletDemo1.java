package cn.itcast.demo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*//输出一句话，我有钱，我有媳妇儿，我媳妇儿不让借
		System.out.println("我有钱，我媳妇儿不让借");
		//给个暗号，设置302的状态码
		response.setStatus(302);
		//告诉我副班长的地址，设置location的头信息，头的值就是副班长的地址（包括项目名称）
		response.setHeader("location", "/day09/servlet/ServletDemo2");*/
		
		//response提供了方法，直接重定向
		response.sendRedirect("/day09/servlet/ServletDemo2");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
