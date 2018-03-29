package cn.itcast.crm.dao;

import cn.itcast.crm.domain.Employee;

/**
 * 员工管理的Dao接口
 * @author Mr_lang
 *
 */
public interface EmployeeDao {

	void save(Employee employee);

	Employee login(Employee employee);

}
