package cn.itcast.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
/**
 * 修改商品信息
 * @author Mr_lang
 *
 */
public class UpdateProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码
		request.setCharacterEncoding("UTF-8");
		
		Map<String,String[]> map = request.getParameterMap();
		//封装数据
		Product p = new Product();
		try {
			//封装数据
			BeanUtils.populate(p, map);
			//修改商品信息
			ProductService ps = new ProductService();
			//修改的功能
			ps.updateProduct(p);
			//跳转到查询所有商品信息的页面
			response.sendRedirect(request.getContextPath()+"/listProduct");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
