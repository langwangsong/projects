package com.itheima.domain;

import java.io.Serializable;

public class User implements Serializable {
	private Integer userID;//尽量使用基本类型对应的包装类型：Integer。因为可以表示成null
	private String userName;
	private String logonName;
	private String logonPwd;
	private String sex;
	private String birthday;
	private String education;
	private String telephone;
	private String interest;//struts2中类型转换器。String[]---->string，用逗号空格进行分割
	private String path;
	private String filename;
	private String remark;
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLogonName() {
		return logonName;
	}
	public void setLogonName(String logonName) {
		this.logonName = logonName;
	}
	public String getLogonPwd() {
		return logonPwd;
	}
	public void setLogonPwd(String logonPwd) {
		this.logonPwd = logonPwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", logonName=" + logonName + ", logonPwd="
				+ logonPwd + ", sex=" + sex + ", birthday=" + birthday + ", education=" + education + ", telephone="
				+ telephone + ", interest=" + interest + ", path=" + path + ", filename=" + filename + ", remark="
				+ remark + "]";
	}
}
