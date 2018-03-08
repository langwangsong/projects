package com.itheima.action;

import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
//写法也是固定的
public class Download1Action extends ActionSupport {
	//提供一个InputStream类型的属性
	private InputStream inputStream;
	private int fileLength;//要下载的文件大小
	private String name;//要下载的文件名
	public String execute() throws Exception{
		//把inputStream赋值即可
		//得到文件的真是路径
		ServletContext sc = ServletActionContext.getServletContext();
		String realPath = sc.getRealPath("/WEB-INF/files/C++.gif");
		
		inputStream = new FileInputStream(realPath);
		
		//设定大小
		fileLength = inputStream.available();
		//设置文件名
		name = FilenameUtils.getName(realPath);//要进行URL编码,避免中文编码，火狐浏览器除外
		//在动作中进行编码
		//name = URLEncoder.encode(name,"UTF-8");
		return SUCCESS;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public int getFileLength() {
		return fileLength;
	}

	public void setFileLength(int fileLength) {
		this.fileLength = fileLength;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
