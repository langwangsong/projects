package cn.itcast.spring.demo5;

public class Car {
	private String name;
	private Double price;
	public Car(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + "]";
	}
	
}
