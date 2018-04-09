package cn.itcast.crm.service;

import cn.itcast.crm.domain.Employee;
import cn.itcast.crm.domain.PageBean;

/**
 * 员工管理的业务层接口
 * @author Mr_lang
 *
 */
public interface EmployeeService {

	void save(Employee employee);

	Employee login(Employee employee);

	PageBean<Employee> findByPage(int currentPage);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
