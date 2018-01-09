package cn.itcast.request2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 注册的后台程序
 * @author Mr_lang
 *
 */
public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码问题（post请求）
		request.setCharacterEncoding("UTF-8");
		/**
		 * 获取用户输入的数据
		 */
		//先获取到姓名和密码
		String username = request.getParameter("username");
		//已经获取到了username的值了，先被UTF-8编码，又被ISO-8859-1编码
		//解决:先用ISO-8859-1编码，再使用UTF-8解码
		//username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
		String password = request.getParameter("password");
		System.out.println(username+":"+password);
		//获取爱好
		String[] hobbies = request.getParameterValues("hobby");
		System.out.println(Arrays.toString(hobbies));
		System.out.println("==========================");
		//使用getParameterMap获取到姓名，密码和爱好
		Map<String, String[]> map = request.getParameterMap();
		//循环遍历，获取值
		Set<String> keys = map.keySet();
		for(String key:keys){
			String[] value = map.get(key);
			System.out.println(Arrays.toString(value));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
