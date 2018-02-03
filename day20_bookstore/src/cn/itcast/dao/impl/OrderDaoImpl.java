package cn.itcast.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.OrderDao;
import cn.itcast.domain.Book;
import cn.itcast.domain.Customer;
import cn.itcast.domain.Order;
import cn.itcast.domain.OrderItem;

public class OrderDaoImpl extends JdbcDaoSupport implements OrderDao {

	@Override
	public void save(Order order) {
		//保存订单的基本信息到orders表中
		String sql = "insert into orders (ordernum,totalQuantity,totalPrice,status,customerId) values (?,?,?,?,?)";
		update(sql,order.getOrdernum(),order.getTotalQuantity(),order.getTotalPrice(),order.getStatus(),order.getCustomer()==null?null:order.getCustomer().getId());
		//判断订单是否有无关联订单项，如果有，保存订单项
		List<OrderItem> items = order.getItems();
		sql = "insert into orderitems (quantity,price,bookId,ordernum) values (?,?,?,?)";
		Object[][] params = new Object[items.size()][];
		for(int i=0;i<params.length;i++){
			OrderItem item = items.get(i);
			params[i] = new Object[]{item.getQuantity(),item.getPrice(),item.getBook()==null?null:item.getBook().getId(),order.getOrdernum()};
		}
		batch(sql, params);
	}

	@Override
	public Order find(String ordernum) {
		String sql = "select * from orders where ordernum=?";
		Order order = query(sql,new BeanHandler<Order>(Order.class),ordernum);
		if(order != null){
			//查询客户
			sql = "select * from customers where id=(select customerId from orders where ordernum =?)";
			Customer customer = query(sql,new BeanHandler<Customer>(Customer.class),ordernum);
			order.setCustomer(customer);
		}
		return order;
	}

	@Override
	public void update(Order order) {
		String sql = "update orders set totalQuantity=?,totalPrice=?,status=?,tradeNum=? where ordernum=?";
		update(sql,order.getTotalQuantity(),order.getTotalPrice(),order.getStatus(),order.getTradeNum(),order.getOrdernum());
	}

	@Override
	public List<Order> findByCustomer(Customer customer) {
		String sql = "select * from orders where customerId=? order by createDate";
		List<Order> orders = query(sql,new BeanListHandler<Order>(Order.class),customer.getId());
		if(orders != null){
			for (Order o : orders) {
				o.setCustomer(customer);
			}
		}
		return orders;
	}

	@Override
	public List<OrderItem> findItemsByOrdernum(String ordernum) {
		String sql = "select * from orderitems where ordernum=?";
		List<OrderItem> items = query(sql,new BeanListHandler<OrderItem>(OrderItem.class),ordernum);
		if(items != null){
			for (OrderItem item : items) {
				//查询书籍
				sql = "select * from books where id=(select bookId from orderitems where id=?)";
				Book book =query(sql,new BeanHandler<Book>(Book.class),item.getId());
				item.setBook(book);
			}
		}
		return items;
	}

}
