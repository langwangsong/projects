package cn.itcast.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * ��ServletContext�����д���ֵ
 * @author Mr_lang
 *
 */
public class CountServlet extends HttpServlet {
	/**
	 * ÿ�η��ʶ���ִ��
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		//��ServletContext�����ȡcount ֵ��+1 �������ȥ
		Integer count =(Integer) context.getAttribute("count");
		//����
		count++;
		//�ٴ����ȥ
		context.setAttribute("count", count);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * ��һ��������CountServlet,init�ᱻ����
	 * init�������ڲ�����ServletContext�����г�ʼ���ñ���
	 */
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		//�����ֵ
		context.setAttribute("count", 0);
	}

}
