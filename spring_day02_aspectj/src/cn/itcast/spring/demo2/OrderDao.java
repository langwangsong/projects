package cn.itcast.spring.demo2;

public class OrderDao {
	
	public void add(){
		System.out.println("添加订单...");
	}
	public void delete(){
		System.out.println("删除订单...");
	}
	public int update(){
		System.out.println("更改订单...");
		return 100;
	}
	public void find(){
		System.out.println("查找订单...");
		int d = 10 / 0;
	}
}
