package cn.itcast.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.crm.domain.CourseType;

/**
 * 课程类别的DAO接口
 * @author Mr_lang
 *
 */
public interface CourseTypeDao extends BaseDao<CourseType> {

	List<CourseType> search(DetachedCriteria criteria);

	int findCount(CourseType courseType, Integer tnumMax, Double tpriceMax);

	List<CourseType> findByPage(CourseType courseType, Integer tnumMax, Double tpriceMax, int begin, int pageSize);
	
}
