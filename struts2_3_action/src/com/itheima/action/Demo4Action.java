package com.itheima.action;

import com.opensymphony.xwork2.ActionSupport;
//方式三，继承ActionSupport  推荐的
public class Demo4Action extends ActionSupport {
	public String save(){
		System.out.println("调用了保存用户的方法");
		return null;
	}
	public String update(){
		System.out.println("调用了修改用户的方法");
		return null;
	}
}
