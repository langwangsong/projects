package cn.itcast.sh.service;

import java.util.List;

import cn.itcast.sh.dao.CustomerDao;
import cn.itcast.sh.domain.Customer;

public class CustomerService {
	//业务层查询所有客户
	public List<Customer> findAll() {
		return CustomerDao.findAll();
	}
	//业务层保存客户的方法
	public void save(Customer customer) {
		CustomerDao.save(customer);
	}
	//业务层的根据ID查询客户的方法
	public Customer findById(Integer cid) {
		return CustomerDao.findById(cid);
	}
	//业务层修改用户
	public void update(Customer customer) {
		CustomerDao.update(customer);
	}
	//业务层删除客户
	public void delete(Customer customer) {
		CustomerDao.delete(customer);
	}
	
}
