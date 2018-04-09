package cn.itcast.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.CourseTypeDao;
import cn.itcast.crm.domain.CourseType;
import cn.itcast.crm.domain.PageBean;
import cn.itcast.crm.service.CourseTypeService;
/**
 * 课程类别业务层的实现类
 * @author Mr_lang
 *
 */
@Transactional
public class CourseTypeServiceImpl implements CourseTypeService {
	//注入课程类别的Dao
	@Resource(name="courseTypeDao")
	private CourseTypeDao courseTypeDao;
	/**
	 * 业务层分页查询课程类别的方法
	 */
	@Override
	public PageBean<CourseType> findByPage(int currentPage) {
		PageBean<CourseType> pageBean = new PageBean<CourseType>();
		//设置当前页数
		pageBean.setCurrentPage(currentPage);
		//设置每页显示的记录数
		int pageSize = pageBean.PAGESIZE;
		pageBean.setPageSize(pageSize);
		//设置总记录数
		int totalCount = courseTypeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//设置总的页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//设置每页显示的数据的集合
		int begin = (currentPage-1)*pageSize;
		List<CourseType> list = courseTypeDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	/**
	 * 业务层保存课程类别的方法
	 */
	@Override
	public void save(CourseType courseType) {
		courseTypeDao.save(courseType);
	}
	/**
	 * 根据课程类别的id查询课程类别的方法
	 */
	@Override
	public CourseType findById(Integer tid) {
		return courseTypeDao.findById(tid);
	}
	/**
	 * 业务层修改课程类别的方法
	 */
	@Override
	public void update(CourseType courseType) {
		courseTypeDao.update(courseType);
	}
	/**
	 * 业务层删除课程类别的方法
	 */
	@Override
	public void delete(CourseType courseType) {
		courseTypeDao.delete(courseType);
	}
}
