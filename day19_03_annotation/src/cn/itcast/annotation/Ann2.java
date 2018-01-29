package cn.itcast.annotation;

public @interface Ann2 {
	String name() default "";//给属性定义默认值
	String value() default "";
	String [] address();
}
