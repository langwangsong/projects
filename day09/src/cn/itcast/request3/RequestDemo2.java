package cn.itcast.request3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//副班长
		System.out.println("我是副班长，我有钱，不用还了");
		String msg = (String) request.getAttribute("msg");
		System.out.println(msg);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print("哈哈...");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
