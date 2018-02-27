package com.itheima.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {
	private String name = "传智博客";
	public String execute(){
		System.out.println(name);
		return null;
	}
	public String getName() {//读属性：属性名，name
		return name;
	}
	public void setName(String name) {//写属性
		this.name = name;
	}
}
