package cn.itcast.annotation;

public @interface Province {
	String name();
	City [] city();//注解类型作为注解的属性类型
}
