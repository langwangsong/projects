package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Order;
import cn.itcast.service.OrderService;
import cn.itcast.service.impl.OrderServiceImpl;
//在线支付页面
//因为需要订单的其他信息，需要订单号查询订单数据
public class PayUIServlet extends HttpServlet {
	private OrderService orderService = new OrderServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ordernum = request.getParameter("ordernum");
		Order order = orderService.findOrderByNum(ordernum);
		request.setAttribute("order", order);
		request.getRequestDispatcher("/client/pay.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
