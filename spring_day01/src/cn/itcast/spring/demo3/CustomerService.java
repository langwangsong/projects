package cn.itcast.spring.demo3;

public class CustomerService {
	public void setup(){
		System.out.println("初始化执行的方法。。。");
	}
	public void teardown(){
		System.out.println("销毁的方法执行了。。。");
	}
}
