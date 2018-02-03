package cn.itcast.service;

import cn.itcast.domain.Customer;

/**
 * 客户有关
 * @author Mr_lang
 *
 */
public interface CustomerService {
	/**
	 * 客户注册
	 */
	void registCustomer(Customer customer);
	/**
	 * 客户登录
	 * @param username
	 * @param password
	 * @return 登录失败返回null
	 */
	Customer login(String username,String password);
	/**
	 * 根据客户主键查询客户
	 * @param customerId
	 * @return 没有找到，返回null
	 */
	Customer findCustomerById(String customerId);
}
