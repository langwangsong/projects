package cn.itcast.web.bean;

import java.io.Serializable;

import cn.itcast.domain.Book;
//购物车中的购物项
public class CartItem implements Serializable {
	private Book book;
	private int quantity;
	private float price;
	public CartItem(Book book){
		this.book = book;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return book.getPrice()*quantity;//单价乘以数量 = 小计
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
