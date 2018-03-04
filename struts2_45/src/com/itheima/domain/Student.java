package com.itheima.domain;

import java.util.Date;

public class Student {
	private String name;
	private String gender;
	private String city;
	private Date birthday;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Student(String name, String gender, String city, Date birthday) {
		super();
		this.name = name;
		this.gender = gender;
		this.city = city;
		this.birthday = birthday;
	}
	public Student(){}
}
