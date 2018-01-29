package cn.itcast.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 文件下载的入门程序
 * @author Mr_lang
 *
 */
public class DownloadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
		//设置两个头信息   值是文件名称的MIME的类型， 通过servletContext来获取
		response.setContentType(this.getServletContext().getMimeType(fileName));
		//设置 Content-Disposition
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		//获取到该文件的输入流
		String path = this.getServletContext().getRealPath("/download");
		InputStream in = new FileInputStream(path+"/"+fileName);
		//获取到输入流，不是自己创建的
		OutputStream os = response.getOutputStream();
		byte [] b = new  byte[1024];
		int len=0;
		while((len = in.read(b)) != -1){
			os.write(b,0,len);
		}
		in.close();
		os.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
