package cn.itcast.crm.service;

import cn.itcast.crm.domain.PageBean;
import cn.itcast.crm.domain.VisitStudent;

/**
 * 咨询学生业务层接口
 * @author Mr_lang
 *
 */
public interface VisitStudentService {

	PageBean<VisitStudent> findByPage(int currentPage);

	void save(VisitStudent visitStudent);

	VisitStudent findById(Integer sid);

	void update(VisitStudent visitStudent);

	void delete(VisitStudent visitStudent);

	void inClass(Integer sid, Integer cid);

}
