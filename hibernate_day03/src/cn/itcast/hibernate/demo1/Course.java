package cn.itcast.hibernate.demo1;

import java.util.HashSet;
import java.util.Set;

/**
 * 课程实体
 * @author Mr_lang
 *
 */
public class Course {
	private Integer cid;
	private String cname;
	//被多个学生选择
	private Set<Student> students = new HashSet<Student>();
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
