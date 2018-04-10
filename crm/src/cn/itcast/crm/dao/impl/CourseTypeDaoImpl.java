package cn.itcast.crm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.crm.dao.CourseTypeDao;
import cn.itcast.crm.domain.CourseType;
import cn.itcast.crm.utils.PageHibernateCallBack;
/**
 * 课程类别的DAO实现类
 * @author Mr_lang
 *
 */
public class CourseTypeDaoImpl extends BaseDaoImpl<CourseType> implements CourseTypeDao {
	/**
	 * DAO中高级查询的方法
	 */
	@Override
	public List<CourseType> search(DetachedCriteria criteria) {
		return (List<CourseType>) this.getHibernateTemplate().findByCriteria(criteria);
	}
	/**
	 * DAO中高级查询统计个数的方法
	 */
	@Override
	public int findCount(CourseType courseType, Integer tnumMax, Double tpriceMax) {
		String hql = "select count(*) from CourseType where 1=1";
		List<Object> pList = new ArrayList<Object>();
		if(courseType.getTname()!=null && !"".equals(courseType.getTname())){
			hql += " and tname like ?";
			pList.add("%"+courseType.getTname()+"%");
		}
		if(courseType.getTnum()!=null){
			hql += " and tnum >= ?";
			pList.add(courseType.getTnum());
		}
		if(tnumMax!=null){
			hql += " and tnum <= ?";
			pList.add(tnumMax);
		}
		if(courseType.getTprice()!=null){
			hql += " and tprice >= ?";
			pList.add(courseType.getTprice());
		}
		if(tpriceMax!=null){
			hql += " and tprice <= ?";
			pList.add(tpriceMax);
		}
		List<Number> list = (List<Number>) this.getHibernateTemplate().find(hql, pList.toArray());
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	/**
	 * DAO中高级查询分页的方法
	 */
	@Override
	public List<CourseType> findByPage(CourseType courseType, Integer tnumMax, Double tpriceMax, int begin,
			int pageSize) {
		String hql = "from CourseType where 1=1";
		List<Object> pList = new ArrayList<Object>();
		if(courseType.getTname()!=null && !"".equals(courseType.getTname())){
			hql += " and tname like ?";
			pList.add("%"+courseType.getTname()+"%");
		}
		if(courseType.getTnum()!=null){
			hql += " and tnum >= ?";
			pList.add(courseType.getTnum());
		}
		if(tnumMax!=null){
			hql += " and tnum <= ?";
			pList.add(tnumMax);
		}
		if(courseType.getTprice()!=null){
			hql += " and tprice >= ?";
			pList.add(courseType.getTprice());
		}
		if(tpriceMax!=null){
			hql += " and tprice <= ?";
			pList.add(tpriceMax);
		}
		List<CourseType> list = this.getHibernateTemplate().execute(new PageHibernateCallBack<CourseType>(hql, pList.toArray(), begin, pageSize));
		return list;
	}
	
}
