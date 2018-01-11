package cn.itcast.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import cn.itcast.domain.User;
import cn.itcast.utils.MyDateConverter;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 	String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
		 */
		
		//中文乱码
		request.setCharacterEncoding("UTF-8");
		//需要使用内省的技术来封装数据（底层就是反射的技术）
		//使用BeanUtils来封装数据
		
		//应该先获取表单的数据
		Map<String,String[]> map = request.getParameterMap();
		//创建User对象
		User user = new User();
		//完成注册
		ConvertUtils.register(new MyDateConverter(), Date.class);
		
		//开发封装数据
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println(user);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
