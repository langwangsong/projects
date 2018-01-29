package cn.itcast.test;

import cn.itcast.annotation.Ann2;

public class UseAnn2 {
	//没有指定属性值，默认给value属性赋值
	@Ann2(value="abc",address="a")
	public void m2(){}
	@Ann2(name="abc",value="off",address={"a","b"})
	public void m1(){
		
	}
}
