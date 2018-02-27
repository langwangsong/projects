package com.itheima.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.User;
import com.itheima.exception.UserExistException;
import com.itheima.service.BusinessService;
import com.itheima.service.impl.BusinessServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();//模型对象
	private BusinessService bs = new BusinessServiceImpl();
	
	//用户注册,数据封装到了User模型对象中
	public String regist(){
		try {
			bs.regist(user);
			return SUCCESS;
		} catch (UserExistException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	//用户登录
	public String login(){
		User user = bs.login(this.user.getUsername(),this.user.getPassword());
		if(user == null){
			return ERROR;//错误的密码或用户名
		}else{
			//把user放到HTTPSession中
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("user", user);
			return SUCCESS;
		}
	}
	//用户注销
	public String logout(){
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return SUCCESS;
	}
	@Override
	public User getModel() {
		return user;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
