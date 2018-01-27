package cn.itcast.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Demo3Filter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Demo3Filter进行了拦截////执行之前");
		//对request进行一些设置
		request.setCharacterEncoding("UTF-8");
		//放行：没有过滤器，执行U币奥资源（request和response就相当于向下传递）
		chain.doFilter(request, response);
		System.out.println("Demo3Filter进行了拦截////执行之后");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
