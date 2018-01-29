package cn.itcast.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
/**
 * 添加购物车的后台
 * @author Mr_lang
 *
 */
public class AddCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收商品的id
		String id = request.getParameter("id");
		/**
		 * 完成购物车的逻辑
		 * 从session中获取购物车，如果是第一次购物车，创建一个购物车，设置商品的数量为1，保存到购物车，保存到session中
		 * 如果不是第一次购买，有车，从购物车中获取到该商品，数量+1。存入到session中
		 * 						如果购物车中没有该商品，直接存入该商品，数量设置为1
		 */
		ProductService ps = new ProductService();
		try {
			//通过id获取到该商品
			Product p = ps.findById(id);
			//从session中获取购物车
			HttpSession session = request.getSession();
			//获取购物车
			Map<String,Product> cart =(Map<String,Product>) session.getAttribute("cart");
			//判断是否第一次访问
			if(cart == null){
				//第一次访问
				//创建购物车
				cart = new HashMap<String,Product>();
				//存入商品，在存入商品之前，设置商品为1
				p.setBuyCount(1);
				//存入商品
				cart.put(id, p);
				session.setAttribute("cart", cart);
			}else{
				if(cart.containsKey(id)){
					//不是第一次访问
					//先获取到该商品原有的数量
					Product hisP = cart.get(id);
					int hisCount = hisP.getBuyCount();
					//给数量+1
					hisCount++;
					hisP.setBuyCount(hisCount);
					//存入到购物车
					cart.put(id, hisP);
					session.setAttribute("cart", cart);
				}else{
					//不包含该商品
					p.setBuyCount(1);
					cart.put(id, p);
					session.setAttribute("cart", cart);
				}
			}
			//跳转到购物车页面
			response.sendRedirect(request.getContextPath()+"/cart.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
