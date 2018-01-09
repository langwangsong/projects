package cn.itcast.context;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��ȡ�����ļ�
 * @author Mr_lang
 *
 */
public class ReadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ִ����
		this.run4();
		//String path = this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
		//String path = this.getServletContext().getRealPath("/src/db.properties");
		//System.out.println(path);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * ��ȡ����srcĿ¼�����Ե��ļ�
	 * @throws IOException
	 * @throws FileNotFundException
	 */
	public void run1() throws IOException{
		//����Properties����
		Properties pro = new Properties();
		//��ȡdb.properties�ļ���������
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
		//����
		pro.load(in);
		//ͨ��key��ȡValueֵ
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		System.out.println(username + " : " +password);
	}
	/**
	 * ��ȡ���Ǿ���İ�Ŀ¼�����Ե��ļ�
	 * @throws IOException
	 * @throws FileNotFundException
	 */
	public void run2() throws IOException{
		//����Properties����
		Properties pro = new Properties();
		//��ȡdb.properties�ļ���������
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/cn/itcast/context/db.properties");
		//����
		pro.load(in);
		//ͨ��key��ȡValueֵ
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		System.out.println(username + " : " +password);
	}
	/**
	 * ��ȡ����WebRootĿ¼�����Ե��ļ�
	 * @throws IOException
	 * @throws FileNotFundException
	 */
	public void run3() throws IOException{
		//����Properties����
		Properties pro = new Properties();
		//��ȡdb.properties�ļ���������
		InputStream in = this.getServletContext().getResourceAsStream("/db.properties");
		//����
		pro.load(in);
		//ͨ��key��ȡValueֵ
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		System.out.println(username + " : " +password);
	}
	/**
	 * ��ȡ�����ļ��ľ��Դ���·��
	 * @throws IOException
	 * @throws FileNotFundException
	 */
	public void run4() throws IOException{
		//����Properties����
		Properties pro = new Properties();
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
		
		//����
		pro.load(new FileInputStream(path));
		//ͨ��key��ȡValueֵ
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		System.out.println(username + " : " +password);
	}
	
}
