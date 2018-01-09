package cn.itcast.session;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 购物车的后台程序
 * @author Mr_lang
 *
 */
public class CartServlet extends HttpServlet {
	/**
	 * 1、先接收用户购买的商品，传过来的商品的ID
	 * 	1.1自己把商品的id转换成商品的名称，（购物车保存的是商品的名称和数量）
	 * 2、先判断是否是第一次访问，直接从session中获取到购物车
	 * 	2.1如果获取不到，说明之前没有向session中存过购物车，说明第一次访问
	 * 		2.1.1创建购物车，吧商品名称和数量1保存进购物车中，吧购物车存入到session中
	 * 	2.2如果获取到了购物车，说明之前向session中存入过购物车
	 * 		2.2.1已经获取到了购物车了，判断购物车中是否包含当前的商品
	 * 			如果包含，数量+1
	 * 			如果不包含，直接把商品和数量1粗入道购物车中
	 * 3、跳转到展示的页面（继续购物还是去计算页面）
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//先获取商品的id
		String sId =  request.getParameter("id");
		String [] names = {"手电筒","娃娃","肾6"};
		int id = Integer.parseInt(sId);
		//获取到了商品的名称
		String productName = names[id-1];
		//判断是否是第一次访问
		//从session中获取到购物车
		HttpSession session = request.getSession();
		Map<String , Integer> cart = (Map<String ,Integer>)session.getAttribute("cart");
		if(cart == null){
			//说明第一次访问
			cart = new HashMap<String ,Integer>();
			cart.put(productName,1);
			//存到session中
			session.setAttribute("cart", cart);
		}else{
			//说明不是第一次访问，说明session中已经存在购物车了
			//判断购物车是否包含该商品
			if(cart.containsKey(productName)){
				//说明包含该商品名称
				Integer count = cart.get(productName);
				count++;
				//再存入
				cart.put(productName, count);
			}else{
				//说明不包含该商品
				//直接存入商品和数量1
				cart.put(productName, 1);
				session.setAttribute("cart", cart);
			}
		}
		//跳转到页面
		response.sendRedirect(request.getContextPath()+"/session/gopay.jsp");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
