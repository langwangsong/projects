package cn.itcast.crm.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.DepartmentDao;
import cn.itcast.crm.domain.Department;
import cn.itcast.crm.domain.PageBean;
import cn.itcast.crm.service.DepartmentService;
/**
 * 业务层的实现类
 * @author Mr_lang
 *
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	//注入部门Dao
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	/**
	 * 业务层分页查询的方法
	 */
	@Override
	public PageBean<Department> findByPage(int currentPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//设置当前的页数
		pageBean.setCurrentPage(currentPage);
		//设置每页显示记录数
		int pageSize = PageBean.PAGESIZE;
		pageBean.setPageSize(pageSize);
		//设置总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//设置总页数
		double tc = totalCount;
		Double totalPage = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		//设置没也要显示的数据的集合:
		int begin = (currentPage - 1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	/**
	 * 业务层保存部门
	 */
	@Override
	public void save(Department department) {
		departmentDao.save(department);
	}
	/**
	 * 业务层根据ID查询部门的方法
	 */
	@Override
	public Department findById(Integer did) {
		return departmentDao.findById(did);
	}
	/**
	 * 业务层修改部门的方法
	 */
	@Override
	public void update(Department department) {
		departmentDao.update(department);
	}
	/**
	 * 业务层删除部门的方法
	 */
	@Override
	public void delete(Department department) {
		departmentDao.delete(department);
	}
	/**
	 * 业务层中查询所有部门的方法
	 */
	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}
}
