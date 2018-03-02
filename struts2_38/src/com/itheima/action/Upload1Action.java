package com.itheima.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
//按照框架要求编写即可
public class Upload1Action extends ActionSupport {
	private String name;
	private File[] upload;//动作类上传的属性必须是File类型,List或数组
	private String[] uploadFileName;//代表上传的文件的文件名。上传字段+FileName，FileName固定写法
	private String[] uploadContentType;//上传文件的MIME类型。上传字段+ContentType，ContentType固定写法
	public String execute() throws Exception{
		System.out.println(name);
		//封装到upload字段中
		
		//服务器建立一个保存文件的目录：WEB-INF/files目录，存放文件的地方
		ServletContext sc = ServletActionContext.getServletContext();
		String realStorePath = sc.getRealPath("/WEB-INF/files");
		File rootDirectory = new File(realStorePath);
		if(!rootDirectory.exists()){
			rootDirectory.mkdirs();//如果目录不存在，创建目录
		}
		//实现上传：IO流
		//FileUtils.copyFile(upload, new File(rootDirectory,uploadFileName));//复制文件
		if(upload!=null && upload.length!=0){
			for (int i = 0; i < upload.length; i++) {
				FileUtils.moveFile(upload[i], new File(rootDirectory, uploadFileName[i]));//剪切文件
			}
		}
		/**************************************************/
		/*InputStream in = new FileInputStream(upload);
		OutputStream out = new FileOutputStream(new File(rootDirectory,uploadFileName));
		int len = -1;
		byte buf[] = new byte[1024];
		while((len=in.read(buf))!=-1){
			out.write(buf, 0, len);
		}
		in.close();
		out.close();*/
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public File[] getUpload() {
		return upload;
	}
	public void setUpload(File[] upload) {
		this.upload = upload;
	}
	public String[] getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String[] getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	
}
