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
 * 读取属性文件
 * @author Mr_lang
 *
 */
public class ReadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//执行了
		this.run4();
		//String path = this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
		//String path = this.getServletContext().getRealPath("/src/db.properties");
		//System.out.println(path);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * 读取的是src目录下属性的文件
	 * @throws IOException
	 * @throws FileNotFundException
	 */
	public void run1() throws IOException{
		//创建Properties对象
		Properties pro = new Properties();
		//获取db.properties文件的输入流
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
		//加载
		pro.load(in);
		//通过key获取Value值
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		System.out.println(username + " : " +password);
	}
	/**
	 * 读取的是具体的包目录下属性的文件
	 * @throws IOException
	 * @throws FileNotFundException
	 */
	public void run2() throws IOException{
		//创建Properties对象
		Properties pro = new Properties();
		//获取db.properties文件的输入流
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/cn/itcast/context/db.properties");
		//加载
		pro.load(in);
		//通过key获取Value值
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		System.out.println(username + " : " +password);
	}
	/**
	 * 读取的是WebRoot目录下属性的文件
	 * @throws IOException
	 * @throws FileNotFundException
	 */
	public void run3() throws IOException{
		//创建Properties对象
		Properties pro = new Properties();
		//获取db.properties文件的输入流
		InputStream in = this.getServletContext().getResourceAsStream("/db.properties");
		//加载
		pro.load(in);
		//通过key获取Value值
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		System.out.println(username + " : " +password);
	}
	/**
	 * 读取的是文件的绝对磁盘路径
	 * @throws IOException
	 * @throws FileNotFundException
	 */
	public void run4() throws IOException{
		//创建Properties对象
		Properties pro = new Properties();
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
		
		//加载
		pro.load(new FileInputStream(path));
		//通过key获取Value值
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		System.out.println(username + " : " +password);
	}
	
}