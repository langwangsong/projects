package cn.itcast.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.DepartmentDao;
import cn.itcast.crm.domain.Department;
/**
 * DepartmentDao的实现类
 * @author Mr_lang
 *
 */
@Transactional(readOnly=false,propagation = Propagation.REQUIRES_NEW)
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
	/**
	 * DAO中统计个数的方法
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from Department";
		List<Number> list = (List<Number>) this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	/**
	 * DAO中分页查询部门的方法
	 */
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		return (List<Department>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
	}
	/**
	 * DAO中的保存部门的方法
	 */
	@Override
	public void save(Department department) {
		
		this.getHibernateTemplate().save(department);
	}
	/**
	 * DAO中根据ID查询部门的方法
	 */
	@Override
	public Department findById(Integer did) {
		return this.getHibernateTemplate().get(Department.class, did);
	}
	/**
	 * DAO中的修改部门的方法
	 */
	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
	}
	/**
	 * DAO中删除部门的方法
	 */
	@Override
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
	}
	/**
	 * DAO中查询所有部门的方法
	 */
	@Override
	public List<Department> findAll() {
		String hql = "from Department";
		return (List<Department>) this.getHibernateTemplate().find(hql);
	}
	
}
