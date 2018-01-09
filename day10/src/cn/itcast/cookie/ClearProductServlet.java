package cn.itcast.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.utils.MyCookieUtil;

public class ClearProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie [] cookies = request.getCookies();
		Cookie cookie = MyCookieUtil.getCookieByName(cookies, "product");
		if(cookie != null){
			cookie.setMaxAge(0);
			cookie.setPath("/day10");
			response.addCookie(cookie);
		}
		response.sendRedirect(request.getContextPath()+"/pages/productList.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
