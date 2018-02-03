package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.OrderDao;
import cn.itcast.dao.impl.OrderDaoImpl;
import cn.itcast.domain.Customer;
import cn.itcast.domain.Order;
import cn.itcast.domain.OrderItem;
import cn.itcast.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao = new OrderDaoImpl();
	@Override
	public void saveOrder(Order order) {
		if(order == null)
			throw new IllegalArgumentException("要保存的订单不能为null");
		if(order.getCustomer() == null)
			throw new IllegalArgumentException("订单必须指定客户");
		if(order.getOrdernum() == null)
			throw new IllegalArgumentException("订单号呢？");
		orderDao.save(order);
	}
	@Override
	public Order findOrderByNum(String ordernum) {
		return orderDao.find(ordernum);
	}
	@Override
	public void updateOrder(Order order) {
		orderDao.update(order);
	}
	@Override
	public List<Order> findCustomerOrders(Customer customer) {
		return orderDao.findByCustomer(customer);
	}
	@Override
	public List<OrderItem> findOrderItemsByOrdernum(String ordernum) {
		return orderDao.findItemsByOrdernum(ordernum);
	}

}
