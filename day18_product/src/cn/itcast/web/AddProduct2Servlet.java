package cn.itcast.web;

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

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
/**
 * 添加商品（带文件上传）
 * @author Mr_lang
 *
 */
public class AddProduct2Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决数据的问题,还需要把文件真正的传到文件夹下
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		//设置文件名称的中文乱码
		upload.setHeaderEncoding("UTF-8");
		Map<String,String> map = new HashMap<String,String>();
		Product p = new Product();
		try {
			//解析request
			List<FileItem> list = upload.parseRequest(request);
			//循环遍历
			for (FileItem fileItem : list) {
				//获取到了每一个FileItem对象
				if(fileItem.isFormField()){
					//说明普通表单项
					String name = fileItem.getFieldName();
					String value = fileItem.getString("UTF-8");
					//把名称和值存入到map集合中
					map.put(name,value);
				}else{
					//是上传文件
					String filename = fileItem.getName();
					//设置商品的文件名称
					p.setFilename(filename);
					//解决文件名称重名
					String uuid = UUID.randomUUID().toString().replace("-", "");
					//把文件名称的后缀名截取出来
					int index = filename.lastIndexOf(".");
					String lastname = filename.substring(index);
					//拼接到一起(唯一的名称)
					String uuidname = uuid + lastname ;
					//获取文件输入流
					InputStream in = fileItem.getInputStream();
					String path = this.getServletContext().getRealPath("/upload");
					OutputStream os = new FileOutputStream(path+"/"+uuidname);
					//设置上传文件的地址
					p.setImgurl("/upload/"+uuidname);
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
			//封装数据
			BeanUtils.populate(p, map);
			//调用业务层，完成添加商品的功能
			ProductService ps = new ProductService();
			ps.addProduct(p);
			//跳转到显示所有商品的页面(跳转到一个servlet)
			response.sendRedirect(request.getContextPath()+"/listProduct");
		} catch (Exception e) {
			e.printStackTrace();
			//可以给用户提示，其实是给自己程序员看的，可以写入到日志中
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
