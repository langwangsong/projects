package cn.itcast.web.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.itcast.domain.Book;
//购物车
public class Cart implements Serializable {
	//String：bookid
	//CartItem:购物项，一项对应同一个商品
	private Map<String,CartItem> items = new HashMap<String,CartItem>();
	private int totalQuantity;//总数量
	private float totalPrice;//总价格，应付款
	
	public Map<String, CartItem> getItems() {
		return items;
	}
	//把书籍加入到item中,quantity数量
	public void addBook2Cart(Book book,int quantity){
		//书籍不在item中
		if(items.containsKey(book.getId()+"")){//在
			CartItem item = items.get(book.getId()+"");
			item.setQuantity(item.getQuantity()+quantity);
		}else{//不在
			CartItem item = new CartItem(book);
			item.setQuantity(quantity);
			items.put(book.getId()+"", item);
		}
	}
	public int getTotalQuantity() {
		totalQuantity = 0;
		for(Map.Entry<String, CartItem> me : items.entrySet()){
			totalQuantity += me.getValue().getQuantity();
		}
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public float getTotalPrice() {
		totalPrice = 0;
		for(Map.Entry<String, CartItem> me : items.entrySet()){
			totalPrice += me.getValue().getPrice();
		}
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
