package cn.itcast.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
/**
 * 注册的控制器
 * @author Mr_lang
 *
 */
public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1.解决中文乱码
		 * 2.接收请求参数
		 * 3.封装数据
		 * 4.处理数据
		 * 5.显示结果
		 */
		request.setCharacterEncoding("UTF-8");
		//接受数据，用BeanUtils封装
		Map<String ,String[]> map = request.getParameterMap();
		User user=new User();
		try {
			BeanUtils.populate(user,map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserService us = new UserService();
		try {
			us.saveUser(user);
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("regist.msg", "注册失败！！");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
