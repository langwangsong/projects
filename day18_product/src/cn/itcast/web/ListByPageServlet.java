package cn.itcast.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
/**
 * 分页的后台
 * @author Mr_lang
 *
 */
public class ListByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 3872174248052335530L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 先获取从客户端发送当前页
		 * 如果没有传递参数，默认是第一条
		 */
		int pageCode = this.getPageCode(request);
		//处理每页显示的记录条数（规定好的）
		int pageSize = 4;
		//访问业务层
		ProductService ps = new ProductService();
		//分页查询
		try {
			PageBean<Product> page = ps.findByPage(pageCode,pageSize);
			//转发到页面
			request.setAttribute("page", page);
			request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	* 获取当前页
	*/
	private int getPageCode(HttpServletRequest request){
		//先获取指定名称的参数
		String pc = request.getParameter("pc");
		if(pc==null || pc.trim().isEmpty()){
			return 1;
		}else{
			//pc="5",说明第5 页
			return Integer.parseInt(pc);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
