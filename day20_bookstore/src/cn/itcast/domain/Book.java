package cn.itcast.domain;

import java.io.Serializable;

import cn.itcast.manage.domain.Category;
//书籍
public class Book implements Serializable {
	private Integer id;
	private String name;
	private String author;
	private Float price;
	private String filename;//文件名
	private String path;//存放路径
	private String description;
	//多对一 
	private Category category;//书籍所属分类
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + ", filename="
				+ filename + ", path=" + path + ", description=" + description + "]";
	}
	
}
