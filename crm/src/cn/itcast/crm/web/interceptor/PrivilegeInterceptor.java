package cn.itcast.crm.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.itcast.crm.domain.Employee;

/**
 * 权限的拦截器
 * @author Mr_lang
 *
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//判断用户是否已经登录
		Employee existEmployee = (Employee) ServletActionContext.getRequest().getSession().getAttribute("existEmployee");
		if(existEmployee == null){
			//没有登录
			ActionSupport actionSupport = (ActionSupport) invocation.getAction();
			actionSupport.addActionError("您没有登录，没有权限访问");
			return actionSupport.LOGIN;
		}else{
			return invocation.invoke();
		}
	}
	
}
