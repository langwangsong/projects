package cn.itcast.crm.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门实体
 * @author Mr_lang
 *
 */
public class Department {
	private Integer did;
	private String dname;
	private String description;
	//员工集合
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
}
