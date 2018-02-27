package com.itheima.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

//动作类编写方式一：POJO
public class Demo2Action extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ServletContext context;
	public String execute(){
		System.out.println(request);
		System.out.println(response);
		System.out.println(context);
		return null;
	}
	//会在动作方法执行前执行： 由框架把request对象注入进来
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
}
