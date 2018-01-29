package cn.itcast.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.service.ProductService;
/**
 * 删除选中功能
 * @author Mr_lang
 *
 */
public class DeleteSelectServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//先接收所有的id 值
		String [] ids = request.getParameterValues("id");
		//一条一条去删除，编写循环。可以使用批处理，完成批量删除
		ProductService ps = new ProductService();
		try {
			//批处理的删除
			ps.deleteSelect(ids);
			//跳转到页面
			response.sendRedirect(request.getContextPath()+"/listProduct");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
