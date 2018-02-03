package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Customer;
import cn.itcast.domain.Order;
import cn.itcast.domain.OrderItem;

public interface OrderService {
	/**
	 * 保存生成的订单，还要保存订单中的订单项
	 * @param order
	 */
	void saveOrder(Order order);
	/**
	 * 根据订单号查询订单
	 * 	订单项：不用查
	 * 	关联的用户：要查
	 * @param ordernum
	 * @return
	 */
	Order findOrderByNum(String ordernum);
	/**
	 * 更新订单
	 * @param order
	 */
	void updateOrder(Order order);
	/**
	 * 查询订单。按照时间倒序排列
	 * @param customer
	 * @return
	 */
	List<Order> findCustomerOrders(Customer customer);
	/**
	 * 根据订单号查询详情
	 * @param ordernum
	 * @return
	 */
	List<OrderItem> findOrderItemsByOrdernum(String ordernum);
	
}
