package com.itheima.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itheima.domain.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo2Action extends ActionSupport {
	private List<String> list1;
	private String[] strs;
	private Map<String,String> map;
	private List<Student> list2;
	//存放数据
	public String execute() throws Exception {
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.setValue("#grade", "B");//向contextMap中存放数据
		//添加数据
		strs = new String[]{"aa","bb","cc"};
		list1 = new ArrayList<String>();
		list1.add("aaa");
		list1.add("bbb");
		list1.add("ccc");
		map = new HashMap<String,String>();
		map.put("a", "aaaa");
		map.put("b", "bbbb");
		map.put("c", "cccc");
		list2 = new ArrayList<Student>();
		Calendar c1 = Calendar.getInstance();
		c1.set(1992, 9, 10);
		list2.add(new Student("张三","1","北京",c1.getTime()));
		Calendar c2 = Calendar.getInstance();
		c2.set(1993, 11, 10);
		list2.add(new Student("李四","0","上海",c2.getTime()));
		Calendar c3 = Calendar.getInstance();
		c3.set(1994, 12, 10);
		list2.add(new Student("王五","1","北京",c3.getTime()));
		return SUCCESS;
	}
	public List<String> getList1() {
		return list1;
	}
	public void setList1(List<String> list1) {
		this.list1 = list1;
	}
	public String[] getStrs() {
		return strs;
	}
	public void setStrs(String[] strs) {
		this.strs = strs;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public List<Student> getList2() {
		return list2;
	}
	public void setList2(List<Student> list2) {
		this.list2 = list2;
	}
	
}
