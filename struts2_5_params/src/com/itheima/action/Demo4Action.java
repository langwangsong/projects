package com.itheima.action;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
//动作类和模型分开:模型驱动
public class Demo4Action extends ActionSupport implements ModelDriven<User> {
	private User user = new User(); //一定要创建模型的实例
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
	@Override
	public User getModel() {
		// 返回模型对象的引用
		return user;
	}
}
