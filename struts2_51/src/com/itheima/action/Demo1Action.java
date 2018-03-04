package com.itheima.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {
	private String username; 
	public String execute() throws Exception {
	//	Thread.sleep(2000);
		System.out.println("保存了数据:"+username);
		return SUCCESS;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
