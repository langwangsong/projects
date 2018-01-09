package cn.itcast.request1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefererServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("播放了...");
		//浏览器的响应
		response.setContentType("text/html;charset=UTF-8");
		//先获取refer请求头信息
		String referer = request.getHeader("referer");
		if(referer.startsWith("http://localhost/day09/request1/my")){
			//说明是自己的网站
			response.getWriter().print("电影已经播放了...");
		}else{
			//说明是坏人的网站
			response.getWriter().print("呸，臭不要脸的！！！");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
