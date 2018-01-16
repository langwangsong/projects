package cn.itcast.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.itcast.service.AccountService2;

public class Accountpay2Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取表单数据
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String fromuser = request.getParameter("fromuser");
		String touser = request.getParameter("touser");
		String sMoney = request.getParameter("money");
		double money = Double.parseDouble(sMoney);
		//调用业务层，处理转账功能
		AccountService2 as = new AccountService2();
		//转账的方法
		try {
			as.gopay(fromuser, touser, money);
			//提示成功
			response.getWriter().print("转账成功");
		} catch (Exception e) {
			e.printStackTrace();
			//转发信息,给出提示信息
			response.getWriter().print(e.getMessage());
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
