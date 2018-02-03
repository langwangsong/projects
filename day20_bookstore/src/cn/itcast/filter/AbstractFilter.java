package cn.itcast.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//适配器：让你的编写的过滤器简单明了
public abstract class AbstractFilter implements Filter {
	
	private FilterConfig filterConfig;
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		init();
	}
	//让你覆盖用的
	public void init() {}
	public void doFilter(ServletRequest req, ServletResponse res, 
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request ;
		HttpServletResponse response;
		try{
			request = (HttpServletRequest) req; 
			response = (HttpServletResponse) res;
		}catch(Exception e){
			throw new RuntimeException("non-http request or response");
		}
		doFilter(request,response,chain);

	}
	public abstract void doFilter(HttpServletRequest request,
			HttpServletResponse response,FilterChain chain)throws IOException, ServletException;
	public void destroy() {
		// do nothing
	}
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
}
