package cn.itcast.domain;

public class Product {
/**
 *      id varchar(50) primary key,
        name varchar(30),
        price double,
        pnum int,
        category varchar(20),
        description varchar(200)
 */
	private String id;
	private String name;
	private Double price;
	private int pnum;
	private String category;
	private String description;
	//添加购买商品数量的属性
	private int buyCount;
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
