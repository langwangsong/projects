package cn.itcast.spring.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 自定义的切面：注解的方式
 * @author Mr_lang
 *
 */
@Aspect
public class MyAspectAnno {
	
	@Before("execution(* cn.itcast.spring.demo1.CustomerDao+.add(..))")
	public void myBefore(JoinPoint joinPoint){
		System.out.println("前置通知=========="+joinPoint);
	}
	
	@AfterReturning(value="execution(* cn.itcast.spring.demo1.CustomerDao+.update(..))",returning="result")
	public void myAfterReturning(Object result){
		System.out.println("后置通知==========="+result);
	}
	
	@Around(value="execution(* cn.itcast.spring.demo1.CustomerDao+.delete(..))")
	public void myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("环绕前========开始时间："+System.currentTimeMillis());
		Object obj = proceedingJoinPoint.proceed();
		System.out.println("环绕后========结束时间："+System.currentTimeMillis());
	}
	
	@AfterThrowing(value="MyAspectAnno.pointcut1()",throwing="ex")
	public void myAfterThrowing(Throwable ex){
		System.out.println("抛出异常通知========"+ex.getMessage());
	}
	@After("MyAspectAnno.pointcut1()")
	public void myAfter(){
		System.out.println("最终通知========");
	}
	
	@Pointcut("execution(* cn.itcast.spring.demo1.CustomerDao+.find(..))")
	private void pointcut1(){};
}
