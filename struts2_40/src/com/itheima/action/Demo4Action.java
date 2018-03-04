package com.itheima.action;

import java.util.Date;
import java.util.Map;

import com.itheima.domain.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo4Action extends ActionSupport {

	public String execute() throws Exception {
		//得到ValueStack的实例
		ActionContext ac = ActionContext.getContext();
		ValueStack vs = ac.getValueStack();
		
		vs.setValue("#s1", "我在这里");//contextMap.put("s1","我在这里")
		
		return SUCCESS;
	}
	
}	
