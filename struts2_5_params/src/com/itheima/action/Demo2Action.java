package com.itheima.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo2Action extends ActionSupport {
	private String username;
	private String password;
	private int age;//基本类型会自动转换：框架完成
	public String execute(){
		System.out.println(username);
		System.out.println(password);
		System.out.println(age);
		return null;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
