package cn.itcast.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 响应JSON数据格式的数据
 * @author Mr_lang
 *
 */
public class Json1Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//字符串，符合JSON格式
		String msg = "{'name':'aaa','age':18}";
		response.getWriter().print(msg);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
