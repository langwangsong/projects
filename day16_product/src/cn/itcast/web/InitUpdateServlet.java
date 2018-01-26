package cn.itcast.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
/**
 * 通过商品的主键，查询该商品的信息，跳转到编辑页面
 * @author Mr_lang
 *
 */
public class InitUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收id的值
		String id = request.getParameter("id");
		ProductService ps = new ProductService();
		//通过主键，查询商品的信息
		try {
			Product p = ps.findById(id);
			//存入到request域对象中
			request.setAttribute("p", p);
			//转发
			request.getRequestDispatcher("/admin/products/edit.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
