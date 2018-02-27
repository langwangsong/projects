package com.itheima.action;
//动作类编写方式一：POJO
public class Demo1Action {
	public Demo1Action(){
		System.out.println("Demo1Action被实例化了");
	}
	public String save(){
		System.out.println("执行了Demo1Action的save方法");
		return null;
	}
	public String update(){
		return null;
	}
}
