package com.itheima.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	//执行该方法钱需要用户必须登录
	public String save(){
		System.out.println("执行了保存操作");
		return null;
	}
	//执行该方法钱需要用户必须登录
	public String update(){
		System.out.println("执行了更新操作");
		return null;
	}
	//用户登录
	public String login(){
		ServletActionContext.getRequest().getSession().setAttribute("user", "user information");
		System.out.println("用户登陆成功");
		return SUCCESS;
	}
}
