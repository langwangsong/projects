package cn.itcast.domain;

import java.io.Serializable;

public class Resource implements Serializable {
	private Integer id;
	private String name;
	private String uri;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
}
