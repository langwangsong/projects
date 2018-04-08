package cn.itcast.crm.dao.impl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.itcast.crm.dao.DepartmentDao;
import cn.itcast.crm.domain.Department;
/**
 * DepartmentDao的实现类
 * @author Mr_lang
 *
 */
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
	
}
