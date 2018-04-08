package cn.itcast.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
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
	/**
	 * DAO中分页查询员工的方法
	 */
	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		return (List<Employee>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
	}
	/**
	 * DAO中统计员工个数的方法
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from Employee";
		List<Number> list = (List<Number>) this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

}
