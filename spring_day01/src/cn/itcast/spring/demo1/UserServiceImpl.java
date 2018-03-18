package cn.itcast.spring.demo1;

public class UserServiceImpl implements UserService {
	private String name;
	@Override
	public void sayHello() {
		System.out.println("Hello spring:"+name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
