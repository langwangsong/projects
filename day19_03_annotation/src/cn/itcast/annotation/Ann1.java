package cn.itcast.annotation;
//@interface 声明一个注解
public @interface Ann1 {
	//属性的类型只能是：基本类型，String，Class,注解类型，枚举类型（Enum）及以上类型的一位数组
	String name();//定义该注解的属性
	int age();
}
