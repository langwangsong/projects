package cn.itcast.spring.demo3;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 自定义的前置增强
 * @author Mr_lang
 *
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("前置通知：====权限校验====");
	}

}
