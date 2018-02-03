package cn.itcast.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;

public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao {

	@Override
	public void save(Customer customer) {
		String sql = "insert into customers (username,password,phonenum,address,email) values (?,?,?,?,?)";
		update(sql,customer.getUsername(),customer.getPassword(),customer.getPhonenum(),
					customer.getAddress(),customer.getEmail());
	}

	@Override
	public Customer find(String username, String password) {
		String sql = "select * from customers where username=? and password=?";
		return query(sql,new BeanHandler<Customer>(Customer.class),username,password);
	}

	@Override
	public Customer findById(String customerId) {
		String sql = "select * from customers where id=?";
		return query(sql,new BeanHandler<Customer>(Customer.class),customerId);
	}
}
