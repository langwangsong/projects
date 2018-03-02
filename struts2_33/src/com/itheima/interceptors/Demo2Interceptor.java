package com.itheima.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Demo2Interceptor extends AbstractInterceptor {
	//拦截器
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Demo2Interceptor拦截前");
		String rtValue = invocation.invoke();//放行，让下一个上
		System.out.println("Demo2Interceptor拦截后");
		return rtValue;
	}

}
