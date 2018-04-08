package cn.itcast.crm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.crm.domain.Department;
import cn.itcast.crm.domain.PageBean;
import cn.itcast.crm.service.DepartmentService;

/**
 * 部门管理的Action类
 * @author Mr_lang
 *
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
	private Department department = new Department();
	@Override
	public Department getModel() {
		return department;
	}
	/**
	 * 分页查询部门的执行方法：findByPage
	 * 接收当前的页数：
	 */
	private int currentPage = 1;
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	//出入部门管理的Service
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public String findByPage(){
		PageBean<Department> pageBean = departmentService.findByPage(currentPage);
		//将pageBean存入到值栈中.
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findByPage";
	}
	/**
	 * 跳转到添加页面的执行方法:saveUI
	 */
	public String saveUI(){
		return "saveUI";
	}
	/**
	 * 保存部门的执行方法：save
	 */
	public String save(){
		departmentService.save(department);
		return "saveSuccess";
	}
}
