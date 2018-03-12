package cn.itcast.hibernate.demo1;

import java.util.HashSet;
import java.util.Set;

/**
 * 学生实体
 * @author Mr_lang
 *
 */
public class Student {
	private Integer sid;
	private String sname;
	//学生选择多门课程
	private Set<Course> courses = new HashSet<Course>();
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
}
