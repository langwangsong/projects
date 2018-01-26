package cn.itcast.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单的JavaBean
 * 封装数据的时候需要有需要注意的地方
 * @author Mr_lang
 *
 */
public class Order {
	private String id;
	private String receiverName;
	private String receiverAddress;
	private String receiverPhone;
	private double totalprice;
	//注意，一个用户可以产生多个订单
	//private String user_id;
	//面向对象思想
	private User user;
	//一个订单可能包括多个订单项
	private List<OrdersItem> ordersItems = new ArrayList<OrdersItem>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrdersItem> getOrdersItems() {
		return ordersItems;
	}
	public void setOrdersItems(List<OrdersItem> ordersItems) {
		this.ordersItems = ordersItems;
	}
}
