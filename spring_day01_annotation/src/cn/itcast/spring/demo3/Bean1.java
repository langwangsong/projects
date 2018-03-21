package cn.itcast.spring.demo3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Bean1 {
	@PostConstruct
	public void setup(){
		System.out.println("初始化执行的方法...");
	}
	@PreDestroy
	public void teardown(){
		System.out.println("销毁时执行的方法...");
	}
}
