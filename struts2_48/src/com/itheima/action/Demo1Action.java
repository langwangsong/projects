package com.itheima.action;

import org.apache.commons.lang3.StringUtils;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Demo1Action extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	public String regist() throws Exception{
		System.out.println(user);
		return SUCCESS;
	}
	public User getModel() {
		return user;
	}
	public void validateRegist() {
		if(StringUtils.isEmpty(user.getUsername())){
			addFieldError("username", "请输入用户名");
		}
	}
	
}
