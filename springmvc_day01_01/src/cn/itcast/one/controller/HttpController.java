package cn.itcast.one.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

public class HttpController implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//域里面设置值
		request.setAttribute("hello", "我是handler request");
		//跳转页页面
		request.getRequestDispatcher("/WEB-INF/jsps/index.jsp").forward(request, response);
	}
	
}
