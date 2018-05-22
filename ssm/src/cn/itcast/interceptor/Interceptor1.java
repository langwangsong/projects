package cn.itcast.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1 implements HandlerInterceptor {
	//执行Handler之前执行，可以用户登录验证
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("这是第一个拦截器Interceptor1的preHandler");
		return true;
	}
	//执行Handler之后返回视图（modelAndView）之前
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("这是第一个拦截器Interceptor1的postHandler");
	}
	//返回视图之后，解析出物理视图之前
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("这是第一个拦截器Interceptor1的afterComplement");
		
	}
	
}
