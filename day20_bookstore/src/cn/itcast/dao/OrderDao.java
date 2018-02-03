package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Customer;
import cn.itcast.domain.Order;
import cn.itcast.domain.OrderItem;

public interface OrderDao {

	void save(Order order);
	/**
	 * 根据订单号查订单：订单项的不要查|客户要查
	 * @param ordernum
	 * @return 没有返回null
	 */
	Order find(String ordernum);
	void update(Order order);
	List<Order> findByCustomer(Customer customer);
	/**
	 * 查询关联的书籍
	 * @param ordernum
	 * @return
	 */
	List<OrderItem> findItemsByOrdernum(String ordernum);
}
