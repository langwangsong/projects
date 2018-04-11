package cn.itcast.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.StudentDao;
import cn.itcast.crm.domain.PageBean;
import cn.itcast.crm.domain.Student;
import cn.itcast.crm.service.StudentService;
/**
 * 在校学生业务层实现类
 * @author Mr_lang
 *
 */
@Transactional
public class StudentServiceImpl implements StudentService {
	@Resource(name="studentDao")
	private StudentDao studentDao;
	/**
	 * 业务层中在校学生的分页查询
	 */
	@Override
	public PageBean<Student> findByPage(int currentPage) {
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setCurrentPage(currentPage);
		//每页显示记录数
		int pageSize = PageBean.PAGESIZE;
		pageBean.setPageSize(pageSize);
		//设置总记录数
		int totalCount = studentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//设置总页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//设置集合：
		int begin = (currentPage -1)*pageSize;
		List<Student> list = studentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
}
