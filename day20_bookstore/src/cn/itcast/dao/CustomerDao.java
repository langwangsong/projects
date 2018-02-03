package cn.itcast.dao;

import cn.itcast.domain.Customer;

public interface CustomerDao {

	void save(Customer customer);

	Customer find(String username, String password);

	Customer findById(String customerId);

}
