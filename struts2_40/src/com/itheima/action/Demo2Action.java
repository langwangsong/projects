package com.itheima.action;

import java.util.Map;

import com.itheima.domain.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo2Action extends ActionSupport {

	public String execute() throws Exception {
		//得到valueStack的实例
		ActionContext ac = ActionContext.getContext();
		ValueStack vs = ac.getValueStack();
		//对contextMap中的root的操作
		
		Student s1 = new Student();//age=0；name=游客
		vs.push(s1);//压入根的栈顶
		
		Student s2 = new Student("张三",10);
		//如果root的栈顶是一个Map，直接put("s2",s2);如果root不是一个map，创建一个map后存入数据
		vs.set("s2", s2);
		
		Student s3 = new Student("李四",20);
		vs.set("s3", s3);
		
		Student s4 = new Student("王五", 30);
		vs.push(s4);
		
		return SUCCESS;
	}
	
}	
