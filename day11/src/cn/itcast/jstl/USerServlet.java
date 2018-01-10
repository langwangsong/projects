package cn.itcast.jstl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.el.User;
/**
 * 撞见List集合，结合中装入一些数据
 * @author Mr_lang
 *
 */
public class USerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> uList = new ArrayList<User>();
		//存入数据
		uList.add(new User("妹妹","123"));
		uList.add(new User("小风","456"));
		uList.add(new User("小花","789"));
		//存入到request域对象中
		request.setAttribute("uList", uList);
		//使用转发
		request.getRequestDispatcher("/jstl/userList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
