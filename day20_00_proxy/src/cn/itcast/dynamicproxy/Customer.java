package cn.itcast.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Customer {

	public static void main(String[] args) {
		Human h= new Actor();
		/*
		 * ClassLoader loader :类加载器。固定写法：和被代理对象使用一样的类加载器即可
		 * Class<?>...interfaces：代理类需要实现的接口。固定写法：和被代理的对象实现的接口相同
		 */
		Class clazz = Proxy.getProxyClass(h.getClass().getClassLoader(), 
										h.getClass().getInterfaces());
		//System.out.println(clazz); //$Proxy0
		//System.out.println(Proxy.isProxyClass(clazz));
		//代理人：返回代理对象的引用
		Human proxy = (Human) Proxy.newProxyInstance(h.getClass().getClassLoader(),
											h.getClass().getInterfaces(), new MyInvocationHandler(h));
		//代理人
//		Human proxy = null;
		proxy.sing(100000);
		proxy.dance(200000);
	}
}
//怎么代理，代理什么？
class MyInvocationHandler implements InvocationHandler{
	private Human h;//被代理人的引用
	public MyInvocationHandler(Human h){//注入
		this.h = h;
	}
	//调用代理类的任何方法都会经过该方法
	/*
	 * Object proxy:代理对象的引用
	 * Method method：当前执行的方法
	 * Object[] args：当前方法用到的参数
	 * 返回值：当前方法的返回值
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//System.out.println(method.getName());
		float money =(Float) args[0];
		if(money<10000){
			throw new RuntimeException("钱不够");
		}
		return method.invoke(h, money/2);
	}
}

