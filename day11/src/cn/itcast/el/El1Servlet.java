package cn.itcast.el;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 向浏览器端回写cookie
 * @author Mr_lang
 *
 */
public class El1Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie c = new Cookie("lasttime","2018-1-9");
		response.addCookie(c);
		response.sendRedirect(request.getContextPath()+"/el/el6.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
