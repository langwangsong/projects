package cn.itcast.request3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("我媳妇儿不让借，但是我会偷偷的找副班长");
		
		//向request域对象存入值
		request.setAttribute("msg", "妹妹");		
		
		//调用转发的的方法  路径：服务器端的绝对路径
		//request.getRequestDispatcher("/servlet/RequestDemo2").forward(request, response);
		
		//重定向
		response.sendRedirect(request.getContextPath()+"/servlet/RequestDemo2");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
