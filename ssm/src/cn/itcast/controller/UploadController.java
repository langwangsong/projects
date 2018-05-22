package cn.itcast.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import cn.itcast.utils.SSMConstants;

@Controller
@RequestMapping("/upload")
public class UploadController {
	@RequestMapping("uploadPic")
	public void uploadPic(HttpServletRequest request,String fileName,PrintWriter out) {
		//把Request请求转换成多部件请求
		MultipartHttpServletRequest mh = (MultipartHttpServletRequest) request;
		//获取文件对象
		CommonsMultipartFile cm = (CommonsMultipartFile) mh.getFile(fileName);
		//把文件对象转换成字节流
		byte[] fbytes = cm.getBytes();
		//为了防止文件重复，需要对文件名进行重新设置
		String newFileName = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHssSSSS");
		newFileName = sdf.format(new Date());
		//定义一个随机数
		Random r = new Random();
		for(int i=0;i<3;i++) {
			newFileName = newFileName + r.nextInt(10);
		}
		//获取文件名
		String originalFileName = cm.getOriginalFilename();
		//截取扩展名
		String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
		//创建json服务器客户端
		Client client = Client.create();
		//关联文件路径到远程服务器
		WebResource resource = client.resource(SSMConstants.PIC_HOST+"/upload/"+newFileName+suffix);
		//上传
		resource.put(String.class,fbytes);
		//需要返回回调函数需要的json格式的数据
		//fullPath就是图片回显路径
		String fullPath = SSMConstants.PIC_HOST+"/upload/"+newFileName+suffix;
		//数据库需要保存的路径
		String relativePath = "/upload/"+newFileName+suffix;
		//手动构造返回的json字符串
		String result = "{\"fullPath\":\""+fullPath+"\",\"relativePath\":\""+relativePath+"\"}";
		//给ajax回调函数写回json串
		out.print(result);
	}
}
