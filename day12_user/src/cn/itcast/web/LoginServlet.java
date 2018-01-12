package cn.itcast.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
/**
 * 
 * 登录的控制器
 * @author Mr_lang
 *
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 接收数据
		 * 封装数据
		 * 处理数据
		 * 显示结果
		 */
		request.setCharacterEncoding("UTF-8");
		//从session中获取验证码，还可以在页面上获取验证码
		String formcode = request.getParameter("formCode");
		//从session中获取一份
		String sessCode =(String) request.getSession().getAttribute("sessCode");
		if(formcode==null || !formcode.equals(sessCode)){
			request.setAttribute("msg", "验证码出错");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		Map<String,String[]> map = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, map);
			UserService us = new UserService();
			User existUser = us.loginUser(user);
			//判断
			if(existUser == null){
				request.setAttribute("msg", "密码或者账号错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				//说明已经登录成功，先判断是否已经勾选了记住用户名复选框
				//String remember = map.get("remember")[0];
				String remember = request.getParameter("remember");
				if("remember_ok".equals(remember)){
					//记住用户名
					Cookie cookie = new Cookie("remember",existUser.getUsername());
					cookie.setMaxAge(60*60);
					cookie.setPath("/");
					//回写
					response.addCookie(cookie);
				}
				request.getSession().setAttribute("existUser", existUser);
				response.sendRedirect(request.getContextPath()+"/home.jsp");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
