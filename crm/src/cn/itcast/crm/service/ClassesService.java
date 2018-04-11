package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.domain.Classes;
import cn.itcast.crm.domain.CourseType;
import cn.itcast.crm.domain.PageBean;

/**
 * 班级管理业务层的接口
 * @author Mr_lang
 *
 */
public interface ClassesService {

	PageBean<Classes> findByPage(int currentPage);

	void save(Classes classes);

	Classes findById(Integer cid);

	void update(Classes classes);

	void delete(Classes classes);

	List<Classes> findAllNotEnd();
}
