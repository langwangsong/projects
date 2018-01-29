package cn.itcast.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 文件下载案例
 * @author Mr_lang
 *
 */
public class MoredownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath = request.getParameter("filePath");
		//解决中文乱码问题
		filePath = new String(filePath.getBytes("ISO-8859-1"),"UTF-8");
		//通过filePath截取文件名称   c:\\root\\a\\hello.txt
		int index = filePath.lastIndexOf("\\");
		String fileName = filePath.substring(index+1);
		//设置两个头，一个流
		response.setContentType(this.getServletContext().getMimeType(fileName));
		//设置 Content-Disposition
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		//先判断浏览器，如果是IE，需要把fileName进行URL编码，如果是火狐浏览器，采用Base64编码
		//判断正式使用的浏览器，通过请求头来判断 user-agent
		String agent = request.getHeader("user-agent");
		if(agent.contains("FireFox")){
			DownloadUtils.base64EncodeFileName(fileName);
		}else{
			//IE 或者 Google
			fileName =  URLEncoder.encode(fileName,"UTF-8");
		}
		InputStream in = new FileInputStream(filePath);
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
