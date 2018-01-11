package cn.itcast.context;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextDemo1
 */
@WebServlet("/ContextDemo1")
public class ContextDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//怎样能获取到ServletContext对象呢？
		//第一种方式
		//servletContext  = this.getServletConfig().getServletContext();
		 ServletContext servletContext = this.getServletContext();
		//获取全局变量的初始化参数
		String username = servletContext.getInitParameter("username");
		System.out.println(username);
		
		Enumeration<String> e = servletContext.getInitParameterNames();
		while(e.hasMoreElements()){
			String name = e.nextElement();
			String value = servletContext.getInitParameter(name);
			System.out.println(name +" : "+ value);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}