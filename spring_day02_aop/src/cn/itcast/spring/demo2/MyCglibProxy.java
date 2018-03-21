package cn.itcast.spring.demo2;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 使用Clib对OrderDAO的add方法进行增强
 * @author Mr_lang
 *
 */
public class MyCglibProxy implements MethodInterceptor {
	
	private OrderDao orderDao;
	
	public MyCglibProxy(OrderDao orderDao){
		this.orderDao =orderDao;
	}
	
	public OrderDao createProxy(){
		//创建Cglib的核心类
		Enhancer enhancer = new Enhancer();
		//设置父类：
		enhancer.setSuperclass(orderDao.getClass());
		//设置回调
		enhancer.setCallback(this);
		//创建代理
		OrderDao proxy = (OrderDao) enhancer.create();
		return proxy;
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		if("add".equals(method.getName())){
			System.out.println("权限校验======");
			return methodProxy.invokeSuper(proxy, args);
		}
		return methodProxy.invokeSuper(proxy, args);
	}
}
