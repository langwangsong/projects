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
 * 添加商品的后台控制器
 * @author Mr_lang
 *
 */
public class AddProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码问题
		request.setCharacterEncoding("UTF-8");
		//解决数据
		Map<String,String[]> map = request.getParameterMap();
		Product p = new Product();
		try {
			//封装数据
			BeanUtils.populate(p, map);
			//调用业务层，完成添加商品的功能
			ProductService ps = new ProductService();
			ps.addProduct(p);
			//跳转到显示所有商品的页面(跳转到一个servlet)
			response.sendRedirect(request.getContextPath()+"/listProduct");
		} catch (Exception e) {
			e.printStackTrace();
			//可以给用户提示，其实是给自己程序员看的，可以写入到日志中
			
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
