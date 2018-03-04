package com.itheima.action;

import java.util.ArrayList;
import java.util.List;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {
	private String name="黑马";
	private List<User> users = new ArrayList<User>(0);
	public String execute() throws Exception {
		users.add(new User("aaa",9,"北京"));
		users.add(new User("bbb",18,"上海"));
		users.add(new User("ccc",27,"深圳"));
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
