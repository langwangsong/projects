package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * 生命周期
 * @author Mr_lang
 *
 */
public class ServletDemo2 implements Servlet{
	/**
	 * Servlet实例销毁前，调用destroy进行销毁工作
	 * Servlet实例什么时候被销毁？
	 * destroy被调用几次？
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy ....");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Servlet实例被创建后，立即调用init初始化
	 * Servlet实例什么时候被创建的呢
	 * init被调用几次呢？
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init....");
	}
	/**
	 * 提供服务
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service....");
	}

}
