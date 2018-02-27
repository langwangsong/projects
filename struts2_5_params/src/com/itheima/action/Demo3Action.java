package com.itheima.action;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionSupport;
//动作类和模型分开
public class Demo3Action extends ActionSupport {
	private User user;
	public String execute(){
		System.out.println(user);
		return null;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
