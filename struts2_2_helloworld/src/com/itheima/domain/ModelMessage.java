package com.itheima.domain;

import java.io.Serializable;
//模型对象	
public class ModelMessage implements Serializable {
	private String message = "Hello World";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
