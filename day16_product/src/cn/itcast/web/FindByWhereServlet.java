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
 * 多条件查询功能
 * @author Mr_lang
 *
 */
public class FindByWhereServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6666457513097838277L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		String minprice = request.getParameter("minprice");
		String maxprice = request.getParameter("maxprice");
		//调用业务层，查询
		ProductService ps= new ProductService();
		//多条件的查询
		try {
			List<Product> pList = ps.findByWhere(id,category,name,minprice,maxprice);
			//存入到request 中
			request.setAttribute("pList", pList);
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
