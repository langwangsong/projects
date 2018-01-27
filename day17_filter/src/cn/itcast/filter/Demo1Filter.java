package cn.itcast.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 入门程序
 * @author Mr_lang
 *
 */
public class Demo1Filter implements Filter {
	public void destroy() {
		
	}
	/**
	 * 每次拦截，该方法都会执行
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Demo1Filter进行了拦截");
		//什么都没做
		//不想访问Demo1Servlet，直接自己向客户端做出相应
		/*response.getWriter().print("go back !!");
		return;*/
		//放行:执行下一个过滤器，如果没有下一个，直接访问资源
		chain.doFilter(request, response);
		//回来的时候，执行的是放行后的代码
		System.out.println("Demo1Filter又执行了...（从** 家回来了）");
	}
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
}
