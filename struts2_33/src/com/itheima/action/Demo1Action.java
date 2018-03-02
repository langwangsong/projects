package com.itheima.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {
	public String execute() throws Exception{
		System.out.println("Demo1Action动作执行了");
		return SUCCESS;
	}
}
