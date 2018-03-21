package cn.itcast.spring.demo4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInfo {
	@Bean(name="product")
	public Product showProduct(){
		Product product = new Product();
		product.setName("空调");
		product.setPrice(1234d);
		return product;
	}
	@Bean(name="car")
	public Car showCar(){
		Car car = new Car();
		car.setName("翼虎");
		car.setPrice(160000d);
		return car;
	}
}
