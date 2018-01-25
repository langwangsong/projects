package cn.itcast.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.domain.Product;
/**
 * 修改购物车商品的购买数量
 * @author Mr_lang
 *
 */
public class ChangeCartCountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收值
		String id = request.getParameter("id");
		String sCount = request.getParameter("count");
		//修改数量
		int count = Integer.parseInt(sCount);
		//从session中获取到购物车，从购物车中再获得到商品
		HttpSession session = request.getSession();
		//获取购物车
		Map<String,Product> cart =(Map<String,Product>) session.getAttribute("cart");
		//从购物车中获取到商品
		Product p = cart.get(id);
		//如果数量等于0，直接从sessoin中删除商品
		//获取到库存
		int pnum = p.getPnum();
		if(count==0){
			//移除该商品
			cart.remove(id);
		}else if(count >= pnum){
			//只能购买最大数量
			p.setBuyCount(pnum);
		}
		else{
			//设置新的数量
			p.setBuyCount(count);
		}
		//不用存入到session中
		response.sendRedirect(request.getContextPath()+"/cart.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
