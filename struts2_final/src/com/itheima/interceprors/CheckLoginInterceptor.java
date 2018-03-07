package com.itheima.interceprors;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class CheckLoginInterceptor extends MethodFilterInterceptor {
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object user = session.getAttribute("user");
		if(user==null){
			return "login";
		}else{
			return invocation.invoke();//放行
		}
	}

}
