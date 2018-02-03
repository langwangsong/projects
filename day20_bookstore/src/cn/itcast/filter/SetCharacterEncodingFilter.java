package cn.itcast.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//中文编码过滤器
public class SetCharacterEncodingFilter extends AbstractFilter {
	
	private String encoding;
	public void init(){
		encoding = getFilterConfig().getInitParameter("encoding");//得到配置的参数值
		if(encoding == null){//用户没有配置该参数
			encoding = "UTF-8";//默认值
		}
	}
	public void doFilter(HttpServletRequest request, 
			HttpServletResponse response,FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);//解决POST请求中文编码
		response.setContentType("text/html;charset="+encoding);//响应输出的中文编码
		chain.doFilter(request, response);//放行
	}
}
