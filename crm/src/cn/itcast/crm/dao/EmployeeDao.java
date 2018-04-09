package cn.itcast.crm.dao;

import java.util.List;

import cn.itcast.crm.domain.Employee;

/**
 * 员工管理的Dao接口
 * @author Mr_lang
 *
 */
public interface EmployeeDao extends BaseDao<Employee> {
	Employee login(Employee employee);
}
