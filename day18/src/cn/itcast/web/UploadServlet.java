package cn.itcast.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1、创建工厂类
		 * 2、创建文件上传类
		 * 3、解析request请求，返回List集合
		 * 4、遍历该List集合，获取到集合中每一个元素
		 * 5、根据不同的方法来完成文件的上传
		 */
		if(!ServletFileUpload.isMultipartContent(request)){
			//说明表单设置不正确
			throw new RuntimeException("亲，你的表单的entype值设置的不正确");
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//设置缓冲区大小   3M
		factory.setSizeThreshold(1024*1024*3);
		//设置临时文件的目录
		String temPath = this.getServletContext().getRealPath("/temp");
		File tempFile = new File(temPath);
		factory.setRepository(tempFile);
		ServletFileUpload upload = new ServletFileUpload(factory);
		//解决中文文件名乱码的问题
		upload.setHeaderEncoding("UTF-8");
		//设置总文件大小
		//upload.setSizeMax(1024*1024*5);
		//设置单个文件大小
		//upload.setFileSizeMax(1024*1024);
		
		//创建Map集合
		//Map<String,String> map = new HashMap<String,String>();
		try {
			List<FileItem> list = upload.parseRequest(request);
			//fileItem代表的是文件项
			for (FileItem fileItem : list) {
				//先判断当前的fileItem是一个普通的表单项，还是文件的上传项
				if(fileItem.isFormField()){
					//返回true，说明普通的表单项
					//先获取表单中name的值（filedesc）
					String name = fileItem.getFieldName();
					String value = fileItem.getString("UTF-8");
					System.out.println(name+" "+value);
					//map的值map<"filedesc1","哈哈"> <"filedesc2","呵呵">
					//map.put(name, value);
				}else{
					String path = this.getServletContext().getRealPath("/upload");
					//文件的上传项
					//获取文件上传的名称
					String fileName = fileItem.getName();
					//如果是IE6：fileName获取的内容是：c:\class\resource\hello.txt
					//获取的是最后的位置
					int index = fileName.lastIndexOf("\\");
					if(index != -1){
						fileName = fileName.substring(index+1);
					}
					//解决唯一的文件名称的问题
					String uuid = UUID.randomUUID().toString();
					//模拟：截取文件名称的后缀名 hello.txt  把.txt截取出来，和唯一的字符串拼接到一起
					//直接拼接
					fileName = uuid + "_" +fileName;
					//int code = fileName.hashCode();
					//进行目录分离       /4/11
					String dirPath = UploadUtils.getDir(fileName);
					// 先生成文件夹      c:\apache-tomcat-...\webapps\day18\ upload\4\11.. 
					File dirFile = new File(path+dirPath); 
					//创建文件夹
					if(!dirFile.exists()){
						dirFile.mkdirs();
					}
					//获取文件的输入流
					InputStream in = fileItem.getInputStream();
					//可以把该文件写入到指定的文件夹下
					
					//目的：需要把上传的文件保存到upload的文件夹下
					
					//先获取到upload文件夹的绝对磁盘路径
					//String path = this.getServletContext().getRealPath("/upload");
					//构造输出流
					OutputStream os = new FileOutputStream(path+dirPath+"/"+fileName);
					byte [] b = new  byte[1024];
					int len=0;
					while((len = in.read(b)) != -1){
						os.write(b,0,len);
					}
					in.close();
					os.close();
					//删除临时文件
					fileItem.delete();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
