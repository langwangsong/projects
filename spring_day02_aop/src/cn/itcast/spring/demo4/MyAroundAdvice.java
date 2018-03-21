package cn.itcast.spring.demo4;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 自定义环绕通知
 * @author Mr_lang
 *
 */
public class MyAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("环绕前通知======开始时间"+System.currentTimeMillis());
		Object object = methodInvocation.proceed();
		System.out.println("环绕后通知======开始时间"+System.currentTimeMillis());
		return object;
	}
	
}
