package com.itheima.domain;

import java.io.Serializable;

public class User implements Serializable {
	private String username;
	private String password;
	private String gender;
	private String city;
	private String hobby;//struts2类型转换器，String[]-->String,用逗号空格进行分割
	private String description;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", gender=" + gender + ", city=" + city
				+ ", hobby=" + hobby + ", description=" + description + "]";
	}
	
}
