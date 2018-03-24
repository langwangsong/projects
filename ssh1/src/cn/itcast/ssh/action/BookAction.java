package cn.itcast.ssh.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.ssh.domain.Book;
import cn.itcast.ssh.service.BookService;

/**
 * 图书管理的action
 * @author Mr_lang
 *
 */
public class BookAction extends ActionSupport implements ModelDriven<Book> {
	//模型驱动使用的对象
	private Book book = new Book();
	@Override
	public Book getModel() {
		return book;
	}
	//定义一个Service
	private BookService bookService;
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	/**
	 * 保存图书的执行方法save
	 */
	public String save(){
		/*WebApplicationContext wap = 
		WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
		BookService bookService = (BookService) wap.getBean("bookService");*/
		System.out.println("Action中的save方法执行了");
		//bookService.save(book);
		return NONE;
	}
	/**
	 * 查询一本图书
	 */
	public String findById(){
		Book book = bookService.findById(2);
		System.out.println(book);
		return NONE;
	}
}
