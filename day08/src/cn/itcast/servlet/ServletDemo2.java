package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * ��������
 * @author Mr_lang
 *
 */
public class ServletDemo2 implements Servlet{
	/**
	 * Servletʵ������ǰ������destroy�������ٹ���
	 * Servletʵ��ʲôʱ�����٣�
	 * destroy�����ü��Σ�
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
	 * Servletʵ������������������init��ʼ��
	 * Servletʵ��ʲôʱ�򱻴�������
	 * init�����ü����أ�
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init....");
	}
	/**
	 * �ṩ����
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service....");
	}

}
