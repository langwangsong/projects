package cn.itcast.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Order;
import cn.itcast.service.OrderService;
import cn.itcast.service.impl.OrderServiceImpl;
import cn.itcast.util.PaymentUtil;
//接收第三方返回的数据，对结果进行处理
public class PaymentResponse extends HttpServlet {
		private OrderService orderService = new OrderServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p1_MerId = request.getParameter("p1_MerId");
		String r0_Cmd = request.getParameter("r0_Cmd");
		String r1_Code = request.getParameter("r1_Code"); //支付结果.1.表示成功
		String r2_TrxId = request.getParameter("r2_TrxId");//交易流水号
		String r3_Amt = request.getParameter("r3_Amt");
		String r4_Cur = request.getParameter(" r4_Cur");
		String r5_Pid = request.getParameter("r5_Pid");
		String r6_Order = request.getParameter("r6_Order");//订单号
		String r7_Uid = request.getParameter("r7_Uid");
		String r8_MP = request.getParameter("r8_MP");
		String r9_BType = request.getParameter("r9_BType");//1.浏览器访问的|2.点对点通信
		String hmac = request.getParameter("hmac");
		//验证数据的完整性
		boolean b = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType, "69cl522AV6q613Ii4W6u8k6XuW8vMiN6bFgyv769220IuYe9u37N4y7rI4Pl");
		PrintWriter out = response.getWriter();
		if(b){//数据没有问题
			if("1".equals(r1_Code)){
				if("2".equals(r9_BType)){
					out.write("success");
					Order order = orderService.findOrderByNum(r6_Order); //根据订单号查询订单
					order.setStatus((byte)1);//更改状态为1
					order.setTradeNum(r2_TrxId); //添加交易流水号
					orderService.updateOrder(order); //更新订单
					out.write("支付成功！2秒后转向主页");
					response.setHeader("Refresh", "2;URL="+request.getContextPath());
				}
			}else{
				out.write("支付失败，请重新支付");
			}
		}else{
			out.write("支付返回的数据有问题，请拨打400-888-888");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
