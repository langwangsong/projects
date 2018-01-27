package cn.itcast.demo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao dao = new UserDao();
		User existUser = dao.login(username, password);
		if(existUser==null){
			request.setAttribute("msg", "用户名或者密码错误");
			request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
		}else{
			//先判断用户是否已经勾选了自动登录的功能，如果勾选了，需要把用户名和米吧偷偷地写到cookie中，写到浏览器端
			String autoLogin = request.getParameter("autoLogin");
			if("auto_ok".equals(autoLogin)){
				//吧用户名和密码保存到cookie中
				Cookie c = new Cookie("autoLogin",username+"#itcast#"+password);
				//设置有效时间
				c.setMaxAge(60*60);
				//设置有效路径
				c.setPath("/");
				//回写Cookie
				response.addCookie(c);
			}
			//登录成功，先存入session
			request.getSession().setAttribute("existUser", existUser);
			response.sendRedirect(request.getContextPath()+"/pages/home.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
