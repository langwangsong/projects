package cn.itcast.spring.demo2;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 自定义切面：XML方式
 * @author Mr_lang
 *
 */
public class MyAspectXml {
	public void myBefore(){
		System.out.println("这是一个前置通知========");
	}
	public void myAfterReturning(Object result){
		System.out.println("这是一个后置通知========"+result);
	}
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("这是一个环绕前通知========");
		Object obj = proceedingJoinPoint.proceed();
		System.out.println("这是一个环绕后通知========");
		return obj;
	}
	public void myAfterThrowing(Throwable ex){
		System.out.println("这是一个异常通知========"+ex.getMessage());
	}
	public void myAfter(){
		System.out.println("这是一个最终通知========");
	}
}
