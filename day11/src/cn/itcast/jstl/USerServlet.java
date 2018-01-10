package cn.itcast.jstl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.el.User;
/**
 * ײ��List���ϣ������װ��һЩ����
 * @author Mr_lang
 *
 */
public class USerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> uList = new ArrayList<User>();
		//��������
		uList.add(new User("����","123"));
		uList.add(new User("С��","456"));
		uList.add(new User("С��","789"));
		//���뵽request�������
		request.setAttribute("uList", uList);
		//ʹ��ת��
		request.getRequestDispatcher("/jstl/userList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
