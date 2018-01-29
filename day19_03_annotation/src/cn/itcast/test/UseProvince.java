package cn.itcast.test;

import cn.itcast.annotation.Province;
import cn.itcast.annotation.City;

public class UseProvince {
	@Province(name="山东省",city={@City(code="0531",name="济南市"),@City(code="0532",name="青岛市")})
	public void m1(){
		
	}
}
