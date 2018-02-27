package com.itheima.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//动作类编写方式一：POJO
public class Demo1Action extends ActionSupport {
	public String execute(){
		//如何获取Servlet的API
		HttpServletRequest request  = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		ServletContext sc = request.getServletContext();
		return SUCCESS;
	}
}
