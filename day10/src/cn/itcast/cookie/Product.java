package cn.itcast.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.utils.MyCookieUtil;
/**
 * 商品的浏览记录
 * @author Mr_lang
 *
 */
public class Product extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 0、接收用户浏览的商品的id
		 * 1、先判断是否是第一次访问
		 * 2、如果是第一次，创建cookie，把商品的id保存到cookie中，回写cookie
		 * 3、如果不是第一次，获取到cookie的值，（目的：追加商品的id）
		 * 	3.1先判断，如果cookie的值中包含了商品的id，说明以前浏览过，不用处理
		 * 	3.2如果不包含商品的id，那说明没有浏览过，追回的id操作，product=1,2
		 * 4、程序需要重定向到商品列表页中
		 * 5、在列表中从cookie中获取所有的值，显示到页面
		 */
		//先接收商品的id
		String id = request.getParameter("id");
		//获取所有的cookie
		Cookie [] cookies = request.getCookies();
		//根据名称查找指定的cookie
		Cookie cookie = MyCookieUtil.getCookieByName(cookies, "product");
		if(cookie == null){
			//说明是第一次
			cookie = new Cookie("product",id);
			cookie.setMaxAge(60*60);
			cookie.setPath("/day10");
			//回写cookie
			response.addCookie(cookie);
		}else{
			//说明不是第一次访问
			//获取值，进行判断，ids有可能 product = 1,2,4
			String ids = cookie.getValue();
			//切割，再判断
			String[] idArr = ids.split(",");
			if(!checkId(idArr,id)){
				//说明不包含，追加处理
				//cookie设置新的值 ids=1,2,4 id=3 最新的结果：3,1,2,4
				cookie.setValue(id+","+ids);
				cookie.setMaxAge(60*60);
				cookie.setPath("/day10");
				//回写
				response.addCookie(cookie);
			}
		}
		//重定向到列表页面
		response.sendRedirect(request.getContextPath()+"/pages/productList.jsp");
	}
	/**
	 * 判断当前的数组中是否包含指定的id
	 * @param idArr
	 * @param ids
	 * @return
	 */
	private boolean checkId(String[] idArr, String id) {
		for(String s:idArr){
			if(id.equals(s)){
				return true;
			}
		}
		return false;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
