package com.itheima.action;

import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {
	public String add(){
		System.out.println("add方法");
		return SUCCESS;
	}
	public String update(){
		System.out.println("update方法");
		return SUCCESS;
	}
	public String delete(){
		System.out.println("delete方法");
		return SUCCESS;
	}
}
