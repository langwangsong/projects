package com.itheima.interceptors;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
//如果用户登录了，会在HTTPSession中存放一个user的登录标记
//如果有该标记，就放行，让动作方法执行；否则，转向name=login的逻辑视图
public class LogonCheckInterceptor extends MethodFilterInterceptor {
	public String doIntercept(ActionInvocation invocation) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object obj = session.getAttribute("user");
		if(obj == null)
			return "login";
		//如果有该标记
		return invocation.invoke();
	}

}
