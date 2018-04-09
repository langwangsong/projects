package cn.itcast.crm.web.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.crm.domain.CourseType;
import cn.itcast.crm.domain.PageBean;
import cn.itcast.crm.service.CourseTypeService;

/**
 * 课程类别的Action
 * @author Mr_lang
 *
 */
public class CourseTypeAction extends ActionSupport implements ModelDriven<CourseType> {
	//模型驱动使用的类
	private CourseType courseType = new CourseType();
	@Override
	public CourseType getModel() {
		return courseType;
	}
	//注入课程类别的Service
	@Resource(name="courseTypeService")
	private CourseTypeService courseTypeService;
	//接收当前页数
	private int currentPage = 1;
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 分页查询课程类别的执行方法：findByPage
	 */
	public String findByPage(){
		//接收当前的页
		//调用业务层查询数据
		PageBean<CourseType> pageBean = courseTypeService.findByPage(currentPage);
		//存入到值栈
		ActionContext.getContext().getValueStack().push(pageBean);
		//页面跳转
		return "findByPage";
	}
	/**
	 * 跳转到添加页面的执行方法：saveUI
	 */
	public String saveUI() {
		return "saveUI";
	}
	/**
	 * 保存课程类别的执行方法：save
	 */
	public String save() {
		//调用业务层
		courseTypeService.save(courseType);
		return "saveSuccess";
	}
	/**
	 * 编辑课程类别的执行方法：edit
	 */
	public String edit(){
		courseType = courseTypeService.findById(courseType.getTid());
		return "editSuccess";
	}
	/**
	 * 次改课程类别的执行方法：update
	 */
	public String update(){
		courseTypeService.update(courseType);
		return "updateSuccess";
	}
	/**
	 * 课程类别的删除的执行方法：delete
	 */
	public String delete(){
		courseType = courseTypeService.findById(courseType.getTid());
		courseTypeService.delete(courseType);
		return "deleteSuccess";
	}
}
