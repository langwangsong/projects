package cn.itcast.reflect;

import java.lang.reflect.Method;

//反射注解属性
public class MyTestRunner1 {

	public static void main(String[] args) throws ReflectiveOperationException, IllegalAccessException{
		// 得到SomeDaotest的字节码
		Class clazz = SomeDaoTest.class; 
		Object testObject = clazz.newInstance();
		//得到所有方法
		Method methods [] = clazz.getMethods();
		//遍历方法：得到方法上面的注解 @MyTest
		for (Method m : methods) {
			MyTest myTest = m.getAnnotation(MyTest.class);
			if(myTest!=null){
				//获取注解的属性timeout
				long time = myTest.timeout();
				//判断该值是否大于0
				if(time>-1){//说明需要测试效率
					//测试效率
					long startTime = System.nanoTime();//开始时间
					m.invoke(testObject, null);
					long costTime = System.nanoTime()-startTime;//实际花费的时间
					if(costTime > time){
						System.out.println(m.getName()+"运行效率不足");
					}
				}else{
					m.invoke(testObject, null);//不测试效率
					
				}
			}
		}
		//谁有这个注解就调用该方法
	}

}
