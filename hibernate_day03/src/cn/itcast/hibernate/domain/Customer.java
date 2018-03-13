package cn.itcast.hibernate.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 客户实体
 * @author Mr_lang
 *
 */
public class Customer {
	private Integer cid;
	private String cname;
	private Integer cage;
	private Set<Order> orders = new HashSet<Order>();
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
	public Integer getCage() {
		return cage;
	}
	public void setCage(Integer cage) {
		this.cage = cage;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cage=" + cage + "]";
	}
	public Customer() {
		super();
	}
	public Customer(String cname, Integer cage) {
		super();
		this.cname = cname;
		this.cage = cage;
	}
	
}	
