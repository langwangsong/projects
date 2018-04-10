package cn.itcast.crm.web.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.crm.domain.Classes;
import cn.itcast.crm.domain.CourseType;
import cn.itcast.crm.domain.PageBean;
import cn.itcast.crm.service.ClassesService;
import cn.itcast.crm.service.CourseTypeService;

/**
 * 班级管理的Action类
 * @author Mr_lang
 *
 */
public class ClassesAction extends ActionSupport implements ModelDriven<Classes> {
	//模型驱动使用类
	private Classes classes = new Classes();
	@Override
	public Classes getModel() {
		// TODO Auto-generated method stub
		return classes;
	}
	//注入班级管理的Service
	@Resource(name="classesService")
	private ClassesService classesService;
	//注入课程类别的Service
	@Resource(name="courseTypeService")
	private CourseTypeService courseTypeService;
	//接收当前页数
	private int currentPage=1;
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	/**
	 * 分页查询班级的方法：findByPage
	 */
	public String findByPage(){
		PageBean<Classes> pageBean = classesService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findByPage";
	}
	/**
	 * 跳转到添加页面的执行方法：saveUI
	 */
	public String saveUI(){
		//查询所有的课程类别
		List<CourseType> list = courseTypeService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	/**
	 * 保存班级的方法：save
	 */
	public String save(){
		classesService.save(classes);
		return "saveSuccess";
	}
	/**
	 * 执行编辑班级的方法：edit
	 */
	public String edit(){
		classes = classesService.findById(classes.getCid());
		List<CourseType> list = courseTypeService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	/**
	 * 修改班级的方法：update
	 */
	public String update(){
		classesService.update(classes);
		return "updateSuccess";
	}
	/**
	 * 删除班级的方法：delete
	 */
	public String delete(){
		classes = classesService.findById(classes.getCid());
		classesService.delete(classes);
		return "deleteSuccess";
	}
}
