package cn.itcast.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * 向ServletContext对象中存入值
 * @author Mr_lang
 *
 */
public class CountServlet extends HttpServlet {
	/**
	 * 每次访问都会执行
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		//从ServletContext对象获取count 值，+1 ，存入进去
		Integer count =(Integer) context.getAttribute("count");
		//自增
		count++;
		//再存入进去
		context.setAttribute("count", count);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * 第一次来访问CountServlet,init会被调用
	 * init方法的内部，在ServletContext对象中初始化好变量
	 */
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		//向存入值
		context.setAttribute("count", 0);
	}

}