package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;
/*
 create database struts2_6_regist;
 use struts2_6_regist;
 create table USERS(
 	id int primary key auto_increment,
 	username varchar(100) not null unique,
 	password varchar(100) not null,
 	email varchar(100) not null,
 	birthday date not null
 );
 */
public class User implements Serializable {
	private int id; //唯一标识
	private String username;
	private String password;
	private String email;
	private Date birthday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", birthday=" + birthday + "]";
	}
}
