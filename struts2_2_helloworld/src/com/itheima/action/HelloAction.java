package com.itheima.action;
//动作类也是一个普通的java类

import com.itheima.domain.ModelMessage;

public class HelloAction {
	private ModelMessage message = new ModelMessage();

	public ModelMessage getMessage() {
		return message;
	}

	public void setMessage(ModelMessage message) {
		this.message = message;
	}
	//动作方法：书写有要求
	/*
	 * 1、用public声明
	 * 2、必须返回String类型
	 * 3、方法没有参数
	 */
	public String sayHello(){
		System.out.println(message.getMessage());
		return "success";
	}
}
