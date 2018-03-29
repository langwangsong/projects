package cn.itcast.crm.service.impl;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.EmployeeDao;
import cn.itcast.crm.domain.Employee;
import cn.itcast.crm.service.EmployeeService;
import cn.itcast.crm.utils.MD5Utils;
/**
 * 员工管理的业务层实现类
 * @author Mr_lang
 *
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	//注入员工管理的DAO
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	/**
	 * 业务层保存员工的类
	 */
	@Override
	public void save(Employee employee) {
		employee.setPassword(MD5Utils.md5(employee.getPassword()));
		employeeDao.save(employee);
	}
	/**
	 * 业务层完成登录的方法
	 */
	@Override
	public Employee login(Employee employee) {
		employee.setPassword(MD5Utils.md5(employee.getPassword()));
		return employeeDao.login(employee);
	}
	
}
