package cn.itcast.demo1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutologinFilter
 */
@WebFilter("/*")
public class AutologinFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutologinFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/**
		 * 先从session中获取existUser，如果不为空放行
		 * 如果为空，继续获取cookie
		 * 如果cookie为空，说明没选过或者过期了，放行
		 * 如果cookie不为空，说明勾选过该功能，获取到cookie中的用户名和密码，其数据库中查询
		 * 如果查询不到用户，说明用户名和密码错误，放行
		 * 如果查询到了该用户，把用户存入到session中，放行
		 */
		//强转
		HttpServletRequest req =(HttpServletRequest) request;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("existUser");
		if(user!=null){
			chain.doFilter(req, response);
		}else{
			Cookie [] cookies = req.getCookies();
			Cookie cookie = this.findCookieByName(cookies, "autoLogin");
			if(cookie==null){
				chain.doFilter(req, response);
			}else{
				String username = cookie.getValue().split("#itcast#")[0];
				String password = cookie.getValue().split("#itcast#")[1];
				UserDao dao = new UserDao();
				User existUser = dao.login(username, password);
				if(existUser==null){
					chain.doFilter(req, response);
				}else{
					session.setAttribute("existUser", existUser);
					chain.doFilter(req, response);
				}
			}
		}
	}
	private Cookie findCookieByName(Cookie [] cookies,String cookieName ){
		if(cookies==null){
			return null;
		}else{
			//遍历查找
			for (Cookie cookie : cookies) {
				if(cookieName.equals(cookie.getName())){
					return cookie;
				}
			}
		}
		return null;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
