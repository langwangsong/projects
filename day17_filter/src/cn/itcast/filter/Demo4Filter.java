package cn.itcast.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Demo4Filter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Demo4Filter销毁了");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Demo4Filter拦截了");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Demo4Filter创建了");
		
		//先获取到过滤器的配置名称
		String filterName = filterConfig.getFilterName();
		System.out.println(filterName);
		String username = filterConfig.getInitParameter("username");
		System.out.println(username);
		
	}

}
