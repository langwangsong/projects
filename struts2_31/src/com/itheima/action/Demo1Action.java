package com.itheima.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {
	public String execute(){
		String str = getText("hello");
		System.out.println(str);
		return SUCCESS;
	}
}
