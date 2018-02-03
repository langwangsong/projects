package cn.itcast.service.impl;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.impl.CustomerDaoImpl;
import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao = new CustomerDaoImpl();
	@Override
	public void registCustomer(Customer customer) {
		if(customer == null)
			throw new IllegalArgumentException("要注册的信息不能为null");
		customerDao.save(customer);
	}

	@Override
	public Customer login(String username, String password) {
		return customerDao.find(username,password);
	}

	@Override
	public Customer findCustomerById(String customerId) {
		return customerDao.findById(customerId);
	}

}
