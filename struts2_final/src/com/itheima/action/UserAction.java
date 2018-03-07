package com.itheima.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.itheima.domain.User;
import com.itheima.service.BusinessService;
import com.itheima.service.impl.BusinessServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private BusinessService s = new BusinessServiceImpl();
	private User user = new User();
	private List<User> users;
	private File upload;
	private String uploadFileName;//上传的文件名
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	//添加新用户
	public String addUser(){
		//user中设置path和filename
		String filename = UUID.randomUUID().toString()+"_"+uploadFileName;
		user.setFilename(filename);
		//创建一个保存文件的路径
		String rootDir = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files");
		String childDir = makeDir(rootDir,filename);//用hashCode算法打散存储目录4/15
		user.setPath(childDir);
		//文件上传
		try {
			FileUtils.moveFile(upload, new File(rootDir+File.separator+childDir,filename));
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
		s.addUser(user);
		return SUCCESS;
	}
	//计算存储子目录
	public String makeDir(String rootDir,String filename){
		int hashCode = filename.hashCode();
		int dir1 = hashCode&0xf;
		int dir2 = (hashCode&0xf)>>4;
		String dir = dir1+File.separator+dir2;
		File f = new File(rootDir,dir);
		if(!f.exists())
			f.mkdirs();
		return dir;
	}
	//用户登录
	public String login(){
		User loginUser = s.login(user.getLogonName(), user.getLogonPwd());
		if(loginUser==null){
			//登录失败
			addActionError("错误的用户名或密码");
			return LOGIN;
		}else{
			//在HTTPSession中设置登录标记
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("user", loginUser);
			return SUCCESS;
		}
	}
	//查询所有用户
	public String list(){
		users = s.findAllUsers();
		return SUCCESS;
	}
	//按照条件进行查询
	public String findByCondition(){
		users = s.findUsersByCondition(user.getUserName(), user.getSex(), user.getEducation(), user.getFilename());
		return SUCCESS;
	}
	public User getModel() {
		return user;
	}

}
