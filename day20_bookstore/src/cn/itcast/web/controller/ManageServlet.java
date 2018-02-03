package cn.itcast.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import cn.itcast.commons.PageBean;
import cn.itcast.domain.Book;
import cn.itcast.manage.domain.Category;
import cn.itcast.service.ManageService;
import cn.itcast.service.impl.ManageServiceImpl;
import cn.itcast.util.MyBeanUtil;

public class ManageServlet extends HttpServlet {
//后台管理器
	public ManageService manageService = new ManageServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");//获取用户的操作
		if("addCategory".equals(op)){
			addCategory(request,response);
		}else if("checkCategoryName".equals(op)){
			checkCategoryName(request,response);
		}else if("listCategories".equals(op)){
			listCategories(request,response);
		}else if("addBookUI".equals(op)){
			addBookUI(request,response);
		}else if("addBook".equals(op)){
			addBook(request,response);
		}else if("listBooks".equals(op)){
			listBooks(request,response);
		}
	}
	//列出所有书籍，要分页
	private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");//用户要看的页码
		PageBean page = manageService.findBooksPageBean(num);
		page.setUrl("/manage/ManageServlet?op=listBooks");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/manage/listBook.jsp").forward(request, response);
	}
	//保存书籍：（重点难点）
	//filename  path categoryid 需要单独处理，其余字段和JavaBean保持一致
	private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);//表单是否是multipart/form-data数据类型
		if(!isMultipart)
			throw new RuntimeException("文件上传的表单的enctype属性值必须是multipart/form-data");
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());//创建解析器
		List<FileItem> items = new ArrayList<FileItem>(0);//大小为0的集合
		try {
			items = upload. parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
			//提示
			request.setAttribute("message", "解析上传内容失败");
			request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
			return ; // 代码返回
		}
		//遍历FileItem:
		Book book = new Book();
		for (FileItem item : items) {
			if(item.isFormField()){
				//普通字段
				processFormField(item,book);
			}else{
				//上传字段
				processUploadField(item,book);
			}
		}
		//保存书籍信息
		manageService.saveBook(book);
		request.setAttribute("message", "恭喜，添加书籍成功！");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}
	//上传字段： file book:path filename
	private void processUploadField(FileItem item,Book book) {
		//获取文件名
		String filename = item.getName();
		if(filename!=null){
			filename = FilenameUtils.getName(filename);//c:\abc\cdb\a.jpg ---->a.jpg
			filename = UUID.randomUUID()+"."+FilenameUtils.getExtension(filename);//保证文件名唯一dadasdasdsa.jpg
		}
		book.setFilename(filename);
		//存放的子目录
		String rootDirectory = getServletContext().getRealPath("/files");
		//子目录：按照日期产生子目录
		String childDirectory = makeChildDirectory(rootDirectory);
		book.setPath(childDirectory);
		//上传文件
		try {
			item.write(new File(rootDirectory+File.separator+childDirectory,filename));
//			InputStream in = item.getInputStream();
//			OutputStream out = new FileOutputStream(new File(rootDirectory+File.separator+childDirectory,filename));
//			int len = -1;
//			byte buf[] = new byte[1024];
//			while((len=in.read(buf))!=-1){
//				out.write(buf, 0, len);
//			}
//			in.close();
//			out.close();
//			item.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//创建子目录
	private String makeChildDirectory(String rootDirectory) {
		Date now = new Date();//当前日期
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String childDirectory = df.format(now);
		File dir = new File(rootDirectory,childDirectory);//得到代表目录的对象
		if(!dir.exists())//判断目录是否存在，不存在创建目录
			dir.mkdirs();
		return childDirectory;//返回子目录
	}
	//普通字段：name author price description categoryid(Book中没有对应的属性)
	private void processFormField(FileItem item,Book book) {
		try {
			String fieldName = item.getFieldName();//表单字段名（类中的属性名）
			String fieldValue = item.getString("UTF-8");//金瓶梅：书名
			//book.setName("金瓶梅")
			BeanUtils.setProperty(book, fieldName, fieldValue);
			//单独处理categoryid
			if("categoryid".equals(fieldName)){
				Category category = manageService.findCategoryById(fieldValue);//根据id查询分类对象
				book.setCategory(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}//书名
	}
	//转向添加书籍页面
	private void addBookUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询所有分类
		List<Category> cs = manageService.findAllCategories();
		request.setAttribute("cs", cs);
		request.getRequestDispatcher("/manage/addBook.jsp").forward(request, response);
	}
	private void listCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//调用service查询所有分类
		List<Category> cs = manageService.findAllCategories();
		//放到请求范围中
		request.setAttribute("cs",cs);
		//转发到页面显示
		request.getRequestDispatcher("/manage/listCategories.jsp").forward(request, response);
	}
	//检查分类名称是否可用
	private void checkCategoryName(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		String name = request.getParameter("name");
		boolean exist = manageService.isCategoryExist(name);
		response.getWriter().write(String.valueOf(exist));
	}

	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//封装数据到JavaBean
			Category category = MyBeanUtil.fillBean(request, Category.class);
			//调用service，保存分类
			manageService.addCategory(category);
			//转向页面：成功，失败
			request.setAttribute("message", "保存分类成功");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "对不起！服务器忙，请稍后重试");
		}
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
