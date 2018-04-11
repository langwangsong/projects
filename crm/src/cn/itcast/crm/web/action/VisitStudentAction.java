package cn.itcast.crm.web.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.crm.domain.Classes;
import cn.itcast.crm.domain.PageBean;
import cn.itcast.crm.domain.VisitStudent;
import cn.itcast.crm.service.ClassesService;
import cn.itcast.crm.service.VisitStudentService;

/**
 * 咨询学生管理的Action类
 * @author Mr_lang
 *
 */
public class VisitStudentAction extends ActionSupport implements ModelDriven<VisitStudent> {
	private VisitStudent visitStudent = new VisitStudent();
	@Override
	public VisitStudent getModel() {
		return visitStudent;
	}
	//注入Service
	@Resource(name="visitStudentService")
	private VisitStudentService visitStudentService;
	@Resource(name="classesService")
	private ClassesService classesService;
	//接收当前页数
	private int currentPage=1;
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	//接收班级的ID
	private Integer cid;
	
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	/**
	 * 分页查询咨询学生的方法：findByPage
	 */
	public String findByPage(){
		PageBean<VisitStudent> pageBean = visitStudentService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findByPage";
	}
	/**
	 * 跳转到咨询学生添加的方法：saveUI
	 */
	public String saveUI(){
		//查询所有没有结课的班级
		List<Classes> list = classesService.findAllNotEnd();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	/**
	 * 保存咨询学生的方法：save
	 */
	public String save(){
		visitStudentService.save(visitStudent);
		return "saveSuccess";
	}
	/**
	 * 编辑咨询学生的方法：edit
	 */
	public String edit(){
		visitStudent = visitStudentService.findById(visitStudent.getSid());
		List<Classes> list = classesService.findAllNotEnd();
		ActionContext.getContext().getValueStack().set("list",list);
		return "editSuccess";
	}
	/**
	 * 修改学生的方法
	 */
	public String update(){
		visitStudentService.update(visitStudent);
		return "updateSuccess";
	}
	/**
	 * 删除学生的方法
	 */
	public String delete(){
		visitStudent = visitStudentService.findById(visitStudent.getSid());
		visitStudentService.delete(visitStudent);
		return "deleteSuccess";
	}
	/**
	 * 跳转到入学编班的页面：inClassUI
	 */
	public String inClassUI(){
		//查询学生的信息
		visitStudent = visitStudentService.findById(visitStudent.getSid());
		//查询未结课的班级信息
		List<Classes> list = classesService.findAllNotEnd();
		ActionContext.getContext().getValueStack().set("list", list);
		return "inClassUI";
	}
	/**
	 * 入学编班的方法：inclass
	 */
	public String inClass(){
		visitStudentService.inClass(visitStudent.getSid(),cid);
		return "inClass";
	}
}
