package cn.itcast.spring.demo4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
		System.out.println("第八步：执行初始化后方法...");
		if("orderService".equals(beanName)){
			Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(),
					new InvocationHandler(){
						@Override
						public Object invoke(Object arg0, Method method, Object[] args) throws Throwable {
							if("save".equals(method.getName()))
								System.out.println("权限校验=====");
							return method.invoke(bean, args);
						}
			});
			return proxy;
		}
		return bean;
	}
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("第五步：执行初始化前方法...");
		return bean;
	}
	
}
