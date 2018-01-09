package cn.itcast.cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.utils.MyCookieUtil;
/**
 * 显示用户上一次的访问时间
 * @author Mr_lang
 *
 */
public class LastTimeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1、先判断是否第一次访问：
		 * 	1.1使用Request对象获取所有的Cookie，查找指定名称的Cookie
		 * 2、如果查询不到，说明是第一次访问
		 * 	2.1输出一句欢迎，把当前的时间保存到Cookie对象中，回写Cookie
		 * 3、如果查询到了，说明不是第一次访问
		 * 	3.1获取到Cookie中的值（上一次的时间），吧该值输出到客户端上，把当前的时间存到cookie，回写
		 * 4、不管是第一次还是低N次，都需要记录时间
		 */
		response.setContentType("text/html;charset=UTF-8");
		//先判断是否是第一次访问
		
		//先获取到所有的cookie
		Cookie [] cookies = request.getCookies();
		//有可能存在我想要的那个cookie，把想要的cookie找出来
		Cookie cookie = MyCookieUtil.getCookieByName(cookies, "lastTime");
		//记录当前的时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sDate = sdf.format(date);
		if(cookie == null){
			//说明是第一次访问，输出欢迎，记录当前时间
			cookie = new Cookie("lastTime",sDate);
			response.addCookie(cookie);
			response.getWriter().print("<h3>亲！欢迎下次再来哦</h3>");
		}else{
			//
			String lastTimeValue = cookie.getValue();
			response.getWriter().print("<h3>亲！你上次的访问时间是："+lastTimeValue+"，欢迎下次再来</h3>");
			cookie.setValue(sDate);
			response.addCookie(cookie);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
