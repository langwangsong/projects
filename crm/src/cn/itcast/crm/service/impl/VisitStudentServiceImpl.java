package cn.itcast.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.ClassesDao;
import cn.itcast.crm.dao.StudentDao;
import cn.itcast.crm.dao.VisitStudentDao;
import cn.itcast.crm.domain.Classes;
import cn.itcast.crm.domain.PageBean;
import cn.itcast.crm.domain.Student;
import cn.itcast.crm.domain.VisitStudent;
import cn.itcast.crm.service.VisitStudentService;
/**
 * 咨询学生业务层的实现类
 * @author Mr_lang
 *
 */
@Transactional
public class VisitStudentServiceImpl implements VisitStudentService {
	//注入Dao
	@Resource(name="visitStudentDao")
	private VisitStudentDao visitStudentDao;
	@Resource(name="studentDao")
	private StudentDao studentDao;
	@Resource(name="classesDao")
	private ClassesDao classesDao;
	/**
	 * 业务层分页查询的方法
	 */
	@Override
	public PageBean<VisitStudent> findByPage(int currentPage) {
		PageBean<VisitStudent> pageBean = new PageBean<VisitStudent>();
		//设置当前页数
		pageBean.setCurrentPage(currentPage);
		//设置每页显示的记录数
		int pageSize = PageBean.PAGESIZE;
		pageBean.setPageSize(pageSize);
		//设置总记录数
		int totalCount = visitStudentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//设置总页数
		double tc = totalCount;
		Double num =  Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//设置每页显示的数据的集合
		int begin = (currentPage-1)*pageSize;
		List<VisitStudent> list = visitStudentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	/**
	 * 业务层中保存咨询学生的方法
	 */
	@Override
	public void save(VisitStudent visitStudent) {
		visitStudentDao.save(visitStudent);
	}
	/**
	 * 业务层根据咨询学生的ID查询学生的方法
	 */
	@Override
	public VisitStudent findById(Integer sid) {
		return visitStudentDao.findById(sid);
	}
	/**
	 * 业务层修改咨询学生的方法
	 */
	@Override
	public void update(VisitStudent visitStudent) {
		visitStudentDao.update(visitStudent);
	}
	/**
	 * 业务层删除咨询学生的方法
	 */
	@Override
	public void delete(VisitStudent visitStudent) {
		visitStudentDao.delete(visitStudent);
	}
	/**
	 * 业务层入学编班的方法
	 */
	@Override
	public void inClass(Integer sid, Integer cid) {
		//删除咨询学生表中记录
		VisitStudent visitStudent = visitStudentDao.findById(sid);
		visitStudentDao.delete(visitStudent);
		//插入到在校学生表中
		Student student = new Student();
		BeanUtils.copyProperties(visitStudent, student);
		studentDao.save(student);
		//修改班级人数
		Classes classes = classesDao.findById(cid);
		classes.setNum(classes.getNum()+1);
		classesDao.save(classes);
	}
}
