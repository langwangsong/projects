package cn.itcast.context;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer count = (Integer) this.getServletContext().getAttribute("count");
		response.setContentType("text/html;charset=UTF-8");
		//显示到页面
		response.getWriter().print("<h3>亲！访问的次数为: "+count+" 次</h3>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}