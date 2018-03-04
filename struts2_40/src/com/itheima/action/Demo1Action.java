package com.itheima.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {
	
	public String execute() throws Exception {
		//得到actionContext的实例
		ActionContext ac = ActionContext.getContext();//从当前线程上获取ActionContext的实例
		
		ac.put("s1", "ssss1value");//向contextMap中放数据
		
		Map<String, Object> sessionAttributes = ac.getSession();//HttpSession中的所有的属性
		sessionAttributes.put("s2", "ssss2value");
		return SUCCESS;
	}
	
}
