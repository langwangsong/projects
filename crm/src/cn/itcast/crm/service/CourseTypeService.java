package cn.itcast.crm.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.crm.domain.CourseType;
import cn.itcast.crm.domain.PageBean;

/**
 * 课程类别的业务层接口
 * @author Mr_lang
 *
 */
public interface CourseTypeService {

	PageBean<CourseType> findByPage(int currentPage);

	void save(CourseType courseType);

	CourseType findById(Integer tid);

	void update(CourseType courseType);

	void delete(CourseType courseType);

	List<CourseType> search(DetachedCriteria criteria);

	PageBean<CourseType> searchByHQL(CourseType courseType, Integer tnumMax, Double tpriceMax, int currentPage);

}
