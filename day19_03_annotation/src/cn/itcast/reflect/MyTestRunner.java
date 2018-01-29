package cn.itcast.reflect;

import java.lang.reflect.Method;

//反射注解
public class MyTestRunner {

	public static void main(String[] args) throws ReflectiveOperationException, IllegalAccessException{
		// 得到SomeDaotest的字节码
		Class clazz = SomeDaoTest.class; 
		Object testObject = clazz.newInstance();
		//得到所有方法
		Method methods [] = clazz.getMethods();
		//遍历方法：看哪个方法上有@MyTest注解
		for (Method m : methods) {
			//谁有这个注解就调用该方法
			boolean exist = m.isAnnotationPresent(MyTest.class);
			//System.out.println(m.getName()+">>>"+exist);
			if(exist){
				m.invoke(testObject, null);
			}
		}
		//谁有这个注解就调用该方法
	}

}
