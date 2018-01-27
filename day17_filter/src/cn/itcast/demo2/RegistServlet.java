package cn.itcast.demo2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 解决中文乱码的问题， 利用filter
 * @author Mr_lang
 *
 */
public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getParameter("username"), 增强，解决中文乱码
		MyrequestWrapper myreq = new MyrequestWrapper(request);
		//String username = request.getParameter("username");
		String username = myreq.getParameter("username");
		System.out.println(username);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
