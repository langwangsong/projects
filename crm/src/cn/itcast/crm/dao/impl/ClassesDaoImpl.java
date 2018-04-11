package cn.itcast.crm.dao.impl;

import java.util.List;

import cn.itcast.crm.dao.ClassesDao;
import cn.itcast.crm.domain.Classes;

public class ClassesDaoImpl extends BaseDaoImpl<Classes> implements ClassesDao {
	/**
	 * 查询所有没有结课的班级
	 */
	@Override
	public List<Classes> findAllNotEnd() {
		String hql = "from Classes where state <> ?";
		
		return (List<Classes>) this.getHibernateTemplate().find(hql, 3);
	}
	
}
