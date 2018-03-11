package cn.itcast.hibernate.demo5;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门的实体
 * @author Mr_lang
 *
 */
public class Department {
	private Integer did;
	private String dname;
	//定义员工的集合：
	private Set<Employee> employees = new HashSet<Employee>();
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
