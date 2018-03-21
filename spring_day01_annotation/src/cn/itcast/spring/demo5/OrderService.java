package cn.itcast.spring.demo5;

import javax.annotation.Resource;

public class OrderService {
	@Resource
	private OrderDao orderDao;
	private CustomerDao customerDao;
	public void save(){
		System.out.println("OrderService的保存方法...");
		orderDao.save();
		customerDao.save();
	}
	/*public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}*/
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
}
