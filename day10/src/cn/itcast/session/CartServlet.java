package cn.itcast.session;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * ���ﳵ�ĺ�̨����
 * @author Mr_lang
 *
 */
public class CartServlet extends HttpServlet {
	/**
	 * 1���Ƚ����û��������Ʒ������������Ʒ��ID
	 * 	1.1�Լ�����Ʒ��idת������Ʒ�����ƣ������ﳵ���������Ʒ�����ƺ�������
	 * 2�����ж��Ƿ��ǵ�һ�η��ʣ�ֱ�Ӵ�session�л�ȡ�����ﳵ
	 * 	2.1�����ȡ������˵��֮ǰû����session�д�����ﳵ��˵����һ�η���
	 * 		2.1.1�������ﳵ������Ʒ���ƺ�����1��������ﳵ�У��ɹ��ﳵ���뵽session��
	 * 	2.2�����ȡ���˹��ﳵ��˵��֮ǰ��session�д�������ﳵ
	 * 		2.2.1�Ѿ���ȡ���˹��ﳵ�ˣ��жϹ��ﳵ���Ƿ������ǰ����Ʒ
	 * 			�������������+1
	 * 			�����������ֱ�Ӱ���Ʒ������1��������ﳵ��
	 * 3����ת��չʾ��ҳ�棨�������ﻹ��ȥ����ҳ�棩
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�Ȼ�ȡ��Ʒ��id
		String sId =  request.getParameter("id");
		String [] names = {"�ֵ�Ͳ","����","��6"};
		int id = Integer.parseInt(sId);
		//��ȡ������Ʒ������
		String productName = names[id-1];
		//�ж��Ƿ��ǵ�һ�η���
		//��session�л�ȡ�����ﳵ
		HttpSession session = request.getSession();
		Map<String , Integer> cart = (Map<String ,Integer>)session.getAttribute("cart");
		if(cart == null){
			//˵����һ�η���
			cart = new HashMap<String ,Integer>();
			cart.put(productName,1);
			//�浽session��
			session.setAttribute("cart", cart);
		}else{
			//˵�����ǵ�һ�η��ʣ�˵��session���Ѿ����ڹ��ﳵ��
			//�жϹ��ﳵ�Ƿ��������Ʒ
			if(cart.containsKey(productName)){
				//˵����������Ʒ����
				Integer count = cart.get(productName);
				count++;
				//�ٴ���
				cart.put(productName, count);
			}else{
				//˵������������Ʒ
				//ֱ�Ӵ�����Ʒ������1
				cart.put(productName, 1);
				session.setAttribute("cart", cart);
			}
		}
		//��ת��ҳ��
		response.sendRedirect(request.getContextPath()+"/session/gopay.jsp");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
