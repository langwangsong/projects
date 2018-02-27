package com.itheima.action;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

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
	// @SkipValidation  //不需要验证注解
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
	//验证方法:验证的是动作类中的所有动作方法;
	/*public void validate() {
		if(StringUtils.isEmpty(user.getUsername())){
			addFieldError("username", "请输入用户名");//添加错误消息提示
		}else{
			//2~8位的字母组成
			if(!user.getUsername().matches("[a-zA-Z]{3,8}")){
				addFieldError("username", "用户名必须由3~8位字母组成");//添加错误消息提示
			}
		}
	}*/
	//验证方法名称validate首字母大写动作方法名称：validateRegist()
	/*public void validateRegist() {
		if(StringUtils.isEmpty(user.getUsername())){
			addFieldError("username", "请输入用户名");//添加错误消息提示
		}else{
			//2~8位的字母组成
			if(!user.getUsername().matches("[a-zA-Z]{3,8}")){
				addFieldError("username", "用户名必须由3~8位字母组成");//添加错误消息提示
			}
		}
	}*/
	
}
