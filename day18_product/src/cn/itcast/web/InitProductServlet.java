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
 * 查看商品的详细信息
 * @author Mr_lang
 *
 */
public class InitProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收商品的主键
		String id = request.getParameter("id");
		//调用业务层
		ProductService ps = new ProductService();
		try {
			Product p = ps.findById(id);
			request.setAttribute("p", p);
			request.getRequestDispatcher("/product_info.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
