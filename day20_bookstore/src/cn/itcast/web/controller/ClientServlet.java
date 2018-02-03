package cn.itcast.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.dsna.util.images.ValidateCode;
import cn.itcast.commons.PageBean;
import cn.itcast.domain.Book;
import cn.itcast.domain.Customer;
import cn.itcast.domain.Order;
import cn.itcast.domain.OrderItem;
import cn.itcast.manage.domain.Category;
import cn.itcast.service.CustomerService;
import cn.itcast.service.ManageService;
import cn.itcast.service.OrderService;
import cn.itcast.service.impl.CustomerServiceImpl;
import cn.itcast.service.impl.ManageServiceImpl;
import cn.itcast.service.impl.OrderServiceImpl;
import cn.itcast.util.MyBeanUtil;
import cn.itcast.util.OrdernumGenerator;
import cn.itcast.web.bean.Cart;
import cn.itcast.web.bean.CartItem;
//前段页面的控制器
public class ClientServlet extends HttpServlet {
	private ManageService manageService = new ManageServiceImpl();
	private CustomerService customerService = new CustomerServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("showIndex".equals(op)){
			showIndex(request,response);
		}else if("listBooksByCategory".equals(op)){
			listBooksByCategory(request,response);
		}else if("showBookDetails".equals(op)){
			showBookDetails(request,response);
		}else if("buyBook".equals(op)){
			buyBook(request,response);
		}else if("delOneItem".equals(op)){
			delOneItem(request,response);
		}else if("delAllItem".equals(op)){
			delAllItem(request,response);
		}else if("changeQuantity".equals(op)){
			changeQuantity(request,response);
		}else if("regist".equals(op)){
			regist(request,response);
		}else if("genCaptcha".equals(op)){
			genCaptcha(request,response);
		}else if("login".equals(op)){
			login(request,response);
		}else if("logout".equals(op)){
			logout(request,response);
		}else if("genOrder".equals(op)){
			genOrder(request,response);
		}else if("showSelfOrders".equals(op)){
			showSelfOrders(request,response);
		}else if("showOrderDetail".equals(op)){
			showOrderDetail(request,response);
		}
		
	}
	//查看订单的详细内容（查看订单项）
	private void showOrderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ordernum = request.getParameter("ordernum");
		List<OrderItem> items = orderService.findOrderItemsByOrdernum(ordernum);
		request.setAttribute("items", items);
		request.getRequestDispatcher("/client/showItems.jsp").forward(request, response);
	}
	//显示用户的订单
	private void showSelfOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//检查用户是否登录：转向登录页面 | 购物车生成到订单中，购物项生成到订单项中
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		if(customer==null){
			response.sendRedirect(request.getContextPath()+"/client/login.jsp");
			return ;
		}
		List<Order> orders = orderService.findCustomerOrders(customer);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/client/listOrders.jsp").forward(request, response);
	}
	//生成订单
	private void genOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//检查用户是否登录：转向登录页面 | 购物车生成到订单中，购物项生成到订单项中
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		if(customer==null){
			response.sendRedirect(request.getContextPath()+"/client/login.jsp");
			return ;
		}
		Cart cart =(Cart) session.getAttribute("cart");
		if(cart == null){
			request.setAttribute("message", "会话超时");
			request.getRequestDispatcher("/client/message.jsp").forward(request, response);
			return;
		}
		Order order = new Order();
		String ordernum = OrdernumGenerator.genOrdernum();
		order.setOrdernum(ordernum);
		order.setCustomer(customer);
		order.setStatus((byte)0);
		order.setTotalPrice(cart.getTotalPrice());
		order.setTotalQuantity(cart.getTotalQuantity());
		for(Map.Entry<String, CartItem> me:cart.getItems().entrySet()){
			CartItem cartItem = me.getValue();
			OrderItem orderItem = new OrderItem();
//			orderItem.setBook(cartItem.getBook());
//			orderItem.setPrice(cartItem.getPrice());
//			orderItem.setQuantity(cartItem.getQuantity());
			try {
				BeanUtils.copyProperties(orderItem, cartItem);
			} catch (Exception e) {
				e.printStackTrace();
			}
			order.getItems().add(orderItem);//建立订单与订单项的关系
		}
		//保存订单，同时保存订单中的订单项
		orderService.saveOrder(order);
		//转向支付
		response.sendRedirect(request.getContextPath()+"/client/PayUIServlet?ordernum="+ordernum);
	}
	//注销
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("customer");
		//重定向主页
		response.sendRedirect(request.getContextPath());
	}
	//用户登录
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//校验验证码
		String fcaptcha = request.getParameter("captcha");//表单传递的
		String captcha = (String) session.getAttribute("captcha");//会话范围中存的
		if(!fcaptcha.equals(captcha)){
			request.setAttribute("message", "错误的验证码");
			request.getRequestDispatcher("/client/message.jsp").forward(request, response);
			return;
		}
		//验证是否登录成功
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Customer customer = customerService.login(username, password);
		if(customer == null){
			request.setAttribute("message", "错误的用户名或密码");
			request.getRequestDispatcher("/client/message.jsp").forward(request, response);
			return;
		}
		session.setAttribute("customer", customer);
		//是否记住用户名
		String remember = request.getParameter("remember");
		Cookie cookie = new Cookie("loginInfo",URLEncoder.encode(username,"UTF-8"));
		if(remember == null){//不记住
			cookie.setMaxAge(0);
		}else{//记住
			cookie.setMaxAge(Integer.MAX_VALUE);
		}
		response.addCookie(cookie);
		//转向主页
		response.sendRedirect(request.getContextPath());
	}
	//生成一个随机验证码图片
	private void genCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ValidateCode code = new ValidateCode(120,25,4,9);//宽，高，验证码个数，干扰线数量
		String captcha = code.getCode();
		request.getSession().setAttribute("captcha", captcha);
		code.write(response.getOutputStream());
	}
	//新用户注册
	private void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Customer customer = MyBeanUtil.fillBean(request, Customer.class);
			customerService.registCustomer(customer);
			request.setAttribute("message", "恭喜，注册成功");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "服务器忙，请重试");
		}
		request.getRequestDispatcher("/client/message.jsp").forward(request, response);
	}
	//修改购买项的数量
	private void changeQuantity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String quantity = request.getParameter("quantity");
		String bookid = request.getParameter("bookid");
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		CartItem item = cart.getItems().get(bookid);
		item.setQuantity(Integer.parseInt(quantity));
		response.sendRedirect(request.getContextPath()+"/client/showCart.jsp");//请求重定向
	}
	//清空购物车
	private void delAllItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("cart");
		response.sendRedirect(request.getContextPath()+"/client/showCart.jsp");//请求重定向
	}
	//删除一个购物项
	private void delOneItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookid = request.getParameter("bookid");
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		cart.getItems().remove(bookid);
		response.sendRedirect(request.getContextPath()+"/client/showCart.jsp");//请求重定向
	}
	//购买书籍到购物车
	private void buyBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String quantity = request.getParameter("quantity");
		String bookid = request.getParameter("bookid");
		Book book = manageService.findBookById(bookid);
		//购物车
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null){
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		//100%有购物车
		cart.addBook2Cart(book, Integer.parseInt(quantity));
		//提示
		request.setAttribute("message", "购买成功 <a href='javascript:history.back()'>继续购物</a>");
		request.getRequestDispatcher("/client/message.jsp").forward(request, response);
	}
	//查看书籍的详细信息
	private void showBookDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookid = request.getParameter("bookid");
		Book book = manageService.findBookById(bookid);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/client/showBookDetails.jsp").forward(request, response);
	}
	//按照分类查询分页书籍
	private void listBooksByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryid = request.getParameter("categoryid");
		List<Category> cs = manageService.findAllCategories();
		request.setAttribute("cs",cs);
		//分页数据
		String num = request.getParameter("num");//用户要看的页码
		PageBean page = manageService.findBooksPageBean(num,categoryid);
		page.setUrl("/client/ClientServlet?op=listBooksByCategory&categoryid="+categoryid);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/client/showBooks.jsp").forward(request, response);
	}
	//默认主页：查询所有分类；查询所有书籍（分页）
	private void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> cs = manageService.findAllCategories();
		request.setAttribute("cs",cs);
		//分页数据
		String num = request.getParameter("num");//用户要看的页码
		PageBean page = manageService.findBooksPageBean(num);
		page.setUrl("/client/ClientServlet?op=showIndex");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/client/showBooks.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
