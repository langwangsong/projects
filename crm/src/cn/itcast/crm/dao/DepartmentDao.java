package cn.itcast.crm.dao;

import java.util.List;

import cn.itcast.crm.domain.Department;

/**
 * DepartmentDao的接口
 * @author Mr_lang
 *
 */
public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

}
