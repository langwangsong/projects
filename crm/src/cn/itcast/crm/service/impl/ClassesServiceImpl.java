package cn.itcast.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.ClassesDao;
import cn.itcast.crm.dao.CourseTypeDao;
import cn.itcast.crm.domain.Classes;
import cn.itcast.crm.domain.CourseType;
import cn.itcast.crm.domain.PageBean;
import cn.itcast.crm.service.ClassesService;
/**
 * 班级管理业务层的实现类
 * @author Mr_lang
 *
 */
@Transactional
public class ClassesServiceImpl implements ClassesService {
	@Resource(name="classesDao")
	private ClassesDao classesDao;

	@Override
	public PageBean<Classes> findByPage(int currentPage) {
		PageBean<Classes> pageBean = new PageBean<Classes>();
		//设置当前页数
		pageBean.setCurrentPage(currentPage);
		//设置每页显示记录数
		int pageSize = PageBean.PAGESIZE;
		pageBean.setPageSize(pageSize);
		//设置总记录数
		int totalCount = classesDao.findCount();
		pageBean.setTotalCount(totalCount);
		//设置总页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//设置每页显示的数据的集合
		int begin = (currentPage-1)*pageSize;
		List<Classes> list= classesDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	/**
	 * 业务层中的保存课程的方法
	 */
	@Override
	public void save(Classes classes) {
		classesDao.save(classes);
	}
	/**
	 * 业务层中根据ID查询课程的方法
	 */
	@Override
	public Classes findById(Integer cid) {
		return classesDao.findById(cid);
	}
	/**
	 * 业务层中修改课程的方法
	 */
	@Override
	public void update(Classes classes) {
		classesDao.update(classes);
	}
	/**
	 * 业务层中删除课程的方法
	 */
	@Override
	public void delete(Classes classes) {
		classesDao.delete(classes);
	}
}
