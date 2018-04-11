package cn.itcast.crm.service;

import cn.itcast.crm.domain.PageBean;
import cn.itcast.crm.domain.Student;

/**
 * 在校学生业务层接口
 * @author Mr_lang
 *
 */
public interface StudentService{
	
	PageBean<Student> findByPage(int currentPage);
}
