package cn.itcast.crm.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.EmployeeDao;
import cn.itcast.crm.domain.Employee;
import cn.itcast.crm.domain.PageBean;
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
	/**
	 * 业务层分页查询员工的方法
	 */
	@Override
	public PageBean<Employee> findByPage(int currentPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//设置当前页数
		pageBean.setCurrentPage(currentPage);
		//设置每页现实的记录数
		int pageSize = pageBean.PAGESIZE;
		pageBean.setPageSize(pageSize);
		//设置总记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//设置总页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//设置每页显示的数据集合
		int begin = (currentPage-1)*pageSize ;
		List<Employee> list = employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	/**
	 * 业务层中根据id查询员工的方法
	 */
	@Override
	public Employee findById(Integer eid) {
		return employeeDao.findById(eid);
	}
	/**
	 * 业务层中修改员工的方法
	 */
	@Override
	public void update(Employee employee) {
		if(employee.getPassword().length()<32){
			employee.setPassword(MD5Utils.md5(employee.getPassword()));
		}
		employeeDao.update(employee);
	}
	/**
	 * 业务层中删除员工的方法
	 */
	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}
	
}
