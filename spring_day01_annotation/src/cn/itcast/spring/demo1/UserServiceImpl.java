package cn.itcast.spring.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserServiceImpl implements UserService {
	@Value(value="老王")
	private String name;
	public void sayHello() {
		System.out.println("Hello ,Spring Annotation..."+name);
	}

}
