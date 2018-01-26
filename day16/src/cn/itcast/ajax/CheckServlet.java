package cn.itcast.ajax;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.utils.MyJdbcUtils;
/**
 * 验证用户名是否已经存在
 * @author Mr_lang
 *
 */
public class CheckServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		/**
		 * 去数据库中查询
		 */
		QueryRunner runner = new QueryRunner(MyJdbcUtils.getDataSource());
		String sql = "select count(*) from user where username = ?";
		try {
			long count = (long) runner.query(sql, new ScalarHandler(),username);
			//判断，如果count>0 说明已经存在
			if(count>0){
				response.getWriter().print("<font color='red'>用户已经存在</font>");
			}else{
				response.getWriter().print("<font color='green'>可以注册</font>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
