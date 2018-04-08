package cn.itcast.crm.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import cn.itcast.crm.domain.Department;
import cn.itcast.crm.domain.Employee;
import cn.itcast.crm.domain.PageBean;
import cn.itcast.crm.service.DepartmentService;
import cn.itcast.crm.service.EmployeeService;

/**
 * 员工管理的action
 * @author Mr_lang
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
	 // 模型驱动
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		return employee;
	}
	//注入员工的Service
	private EmployeeService employeeService;
	//注入部门的service
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	/**
	 * 跳转到注册页面的执行方法:registUI
	 */
	public String registUI(){
		return "registUI";
	}
	/**
	 * 员工注册的执行方法：regist
	 */
	@InputConfig(resultName="registInput")
	public String regist(){
		/**
		 * 调用业务层：
		 * 页面跳转：
		 */
		employeeService.save(employee);
		return "registSuccess";
	}
	/**
	 * 员工登录的执行方法：login
	 */
	@InputConfig(resultName="loginInput")
	public String login(){
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null){
			//登录失败
			this.addActionError("用户名或密码错误");
			return LOGIN;
		}else{
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return "loginSuccess";
		}
	}
	//接收当前页数
	private int currentPage = 1;
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * 分页查询员工的执行方法：findByPage
	 */
	public String findByPage(){
		PageBean<Employee> pageBean =  employeeService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findByPage";
	}
	/**
	 * 跳转到添加页面的执行方法：saveUI
	 */
	public String saveUI(){
		//查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	/**
	 * 保存员工的执行的方法：save
	 */
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
}
