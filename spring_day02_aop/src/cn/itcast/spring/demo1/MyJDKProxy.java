package cn.itcast.spring.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用JDK的动态代理完成对UserDAO的add方法进行增强
 * @author Mr_lang
 *
 */
public class MyJDKProxy implements InvocationHandler {
	private UserDao userDao;
	public MyJDKProxy(UserDao userDao){
		this.userDao = userDao;
	}
	
	public UserDao createProxy(){
		UserDao proxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), 
				userDao.getClass().getInterfaces(), this);
		return proxy;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if("add".equals(method.getName())){
			System.out.println("权限校验=======");
			return method.invoke(userDao, args);
		}
		return method.invoke(userDao, args);
	}
}
