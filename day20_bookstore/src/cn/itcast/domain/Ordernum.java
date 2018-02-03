package cn.itcast.domain;

import java.io.Serializable;

public class Ordernum implements Serializable {
	private String prefix;
	private Integer serialNum;
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public Integer getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}
	
}
