package com.itheima.action;

import java.util.Date;
import java.util.Map;

import com.itheima.domain.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo3Action extends ActionSupport {

	public String execute() throws Exception {
		//得到ValueStack的实例
		ActionContext ac = ActionContext.getContext();
		ValueStack vs = ac.getValueStack();
		
		Student s1 = new Student("张三", 10);
		vs.push(s1);//压入root的栈顶
		//第一个参数：OGNL表达式，特别注意，不是普通的字符
		vs.setValue("name", "李四");// 对象的.setName("李四")对象从根中依次从上往下搜索
		
		vs.setValue("#name", "王五");// contextMap.put("name","王五");
		
		
		return SUCCESS;
	}
	
}	
