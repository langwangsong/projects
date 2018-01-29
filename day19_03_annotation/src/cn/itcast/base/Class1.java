package cn.itcast.base;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Class1 {
	public void m1(){
		
	}
}
class Class2 extends Class1{

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		super.m1();
	}
	@SuppressWarnings({"unused","rawtypes"})//抑制警告。unused:抑制的警告类型
								//rawtypes :抑制应该使用泛型
								// {}数组
	//@SuppressWarnings("all")  全部
	public void m2(){
		int i=10000;
		List list = new ArrayList();
		System.out.println(list.size());
	}
	@Deprecated
	public void m3(){
		
	}
}