package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.domain.Department;
import cn.itcast.crm.domain.PageBean;

/**
 * 部门管理的业务层接口
 * @author Mr_lang
 *
 */
public interface DepartmentService {

	PageBean<Department> findByPage(int currentPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();
	
}
