package cn.itcast.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
/**
 * 查询所有的商品的信息
 * @author Mr_lang
 *
 */
public class ListProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService ps = new ProductService();
		try {
			//查询所有的数据
			List<Product> pList = ps.findAll();
			//把pList存入到request域对象中
			request.setAttribute("pList", pList);
			//转发
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
