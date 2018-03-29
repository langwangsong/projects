package cn.itcast.crm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import cn.itcast.crm.domain.Employee;
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
}
