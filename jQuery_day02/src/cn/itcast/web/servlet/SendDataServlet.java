package cn.itcast.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendDataServlet
 */
@WebServlet("/SendDataServlet")
public class SendDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1请求方式：get/post
		String method = request.getMethod();
		System.out.println("1 :"+method);
		//2请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("2 :"+username);
		System.out.println("3 :"+password);
		//...
		
		//3响应给浏览器--json数据(jsonlin 第三方-->JSONObject/JSONArray)
		String jsonData = "{\"message\":\"成功了\"}";
		//String jsonData = "{'message':'成功了'}"; //畸形json格式
		//中文乱码
		response.setContentType("application/json;charset=UTF-8");//json数据  MIME类型
		//response.setContentType("text/html;charset=UTF-8"); //html代码
		response.getWriter().print(jsonData);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
