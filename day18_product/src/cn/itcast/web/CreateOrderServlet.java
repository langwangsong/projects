package cn.itcast.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.domain.Order;
import cn.itcast.domain.OrdersItem;
import cn.itcast.domain.Product;
import cn.itcast.domain.User;
import cn.itcast.service.ProductService;
import cn.itcast.utils.MyUUIDUtils;
/**
 * 生成订单功能
 * @author Mr_lang
 *
 */
public class CreateOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 目的：吧页面中的数据封装到Order对象中
		 */
		//接收表单提交的数据
		request.setCharacterEncoding("UTF-8");
		Order order = new Order();
		Map<String, String[]> map = request.getParameterMap();
		try {
			BeanUtils.populate(order, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//收货地址，收货人，电话封装好了
		//把订单其他数据也封装起来
		//主键，自己生成
		order.setId(MyUUIDUtils.getUUID());
		//order.setTotalPrice(totalprice);
		//从session对象中获取
		HttpSession session = request.getSession();
		User user =(User) session.getAttribute("existUser");
		order.setUser(user);
		//订单项,一个订单包含多个订单项
		//先从session中获取购物车
		Map<String,Product> cart = (Map<String, Product>) session.getAttribute("cart");
		//获取购物车的商品
		Set<String> ids = cart.keySet();
		//获取购物车的key值
		for(String id:ids){
			//创建一个订单项
			OrdersItem item = new OrdersItem();
			//通过key来获取到该商品的对象
			Product p = cart.get(id);
			//目的，吧商品的信息保存到订单项中
			item.setItemId(MyUUIDUtils.getUUID());
			item.setOrder(order);
			item.setProduct(p);
			//小计
			item.setSubtotal(p.getPrice()*p.getBuyCount());
			//吧订单项保存到订单的集合中
			order.getOrdersItems().add(item);
		}
		//把订单保存到数据库中
		ProductService ps = new ProductService();
		ps.saveOrder(order);
		System.out.println("添加订单成功");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
