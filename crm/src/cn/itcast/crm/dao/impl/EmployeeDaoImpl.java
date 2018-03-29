package cn.itcast.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.itcast.crm.dao.EmployeeDao;
import cn.itcast.crm.domain.Employee;
/**
 * 员工管理DAO层实现类
 * @author Mr_lang
 *
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
	/**
	 * DAO中保存员工的方法
	 */
	@Override
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}
	/**
	 * DAO中员工登录方法
	 */
	@Override
	public Employee login(Employee employee) {
		String hql = "from Employee where username=? and password=?";
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().find(hql, employee.getUsername(),employee.getPassword());
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
