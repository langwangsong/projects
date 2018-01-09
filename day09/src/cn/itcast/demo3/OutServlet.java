package cn.itcast.demo3;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 输出中文乱码的问题
 * @author Mr_lang
 *
 */
public class OutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.out3(response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * 测试使用字节流输出中是否乱码呢？如果乱码呢？怎么解决呢？
	 * 乱码：编码不一致导致的。输出字节数组默认的是GBK编码，到页面上，如果使用UTF-8进行解码，会产生乱码的问题
	 * 解决问题：保证字节流数组的编码和页面的采用的编码是一致的，就不会产生乱码
	 * 
	 * @param response
	 * @throws IOException
	 */
	public void out1(HttpServletResponse response) throws IOException{
		//使用字节流输出中文
		OutputStream os = response.getOutputStream();
		//设置默认浏览器采用的编码的方式（头信息起作用：Content-type）
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		//输出中文
		os.write("张三".getBytes("UTF-8"));
	}
	/**
	 * 字符的中文乱码问题
	 * response其实存在缓冲区，默认的编码是Tomcat服务器的魔人编码是一致的，是ISO-8859-1
	 * 解决问题：
	 * 	设置缓冲区的编码：void setCharacterEncoding("UTF-8")
	 * 	设置浏览器采用的编码来进行解码:response.setHeader("Content-type","text/html;charset=UTF-8");
	 * @throws IOException 
	 */
	public void out2(HttpServletResponse response) throws IOException{
		/*//设置response缓冲区代码
		response.setCharacterEncoding("UTF-8");
		//设置浏览器 采用的编码
		response.setHeader("Content-Type","text/html;charset=UTF-8");
		*/
		//注意：只有字符流中的中文乱码简写的方式
		response.setContentType("text/html;charset=UTF-8");
		//获取字符的输出流
		PrintWriter writer = response.getWriter();
		//输出内容
		writer.write("哈罗我的");
	}
	/**
	 * 字节流和字符流是互斥的
	 * @param response
	 * @throws IOException 
	 */
	public void out3(HttpServletResponse response) throws IOException{
		//字符流
		//response.getWriter().write("hello");
		//字节流
		//response.getOutputStream().write("world".getBytes());
		PrintWriter writer = response.getWriter();
		writer.write(97);
		writer.print(97);
	}
}
