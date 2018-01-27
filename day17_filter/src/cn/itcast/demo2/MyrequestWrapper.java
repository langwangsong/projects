package cn.itcast.demo2;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 继承HttpServletRequestWrapper
 * @author Mr_lang
 *
 */
public class MyrequestWrapper extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	public MyrequestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	//增强那个方法
	/**
	 * 目的：解决get,post中文乱码
	 */
	public String getParameter(String name) {
		//先获取到请求方式
		String method = request.getMethod();
		//判断
		if("post".equalsIgnoreCase(method)){
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else if("get".equalsIgnoreCase(method)){
			//xianyong ISO-8859-1编码，再使用UTF-8解码
			String value = request.getParameter(name);
			try {
				value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
				//返回该结果
				return value;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
		}
		//不要删，post请求设置缓冲区编码
		return super.getParameter(name);
		
	}
	
}
