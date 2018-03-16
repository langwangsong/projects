package cn.itcast.sh.service;

import java.util.List;

import cn.itcast.sh.dao.CustomerDao;
import cn.itcast.sh.domain.Customer;

public class CustomerService {
	//业务层查询所有客户
	public List<Customer> findAll() {
		return CustomerDao.findAll();
	}

}
