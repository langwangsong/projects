package cn.itcast.ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.ssh.dao.BookDao;
import cn.itcast.ssh.domain.Book;

/**
 * 图书管理的业务层
 * @author Mr_lang
 *
 */
@Transactional
public class BookService {
	private BookDao bookDao;
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	/**
	 * 业务层保存图书的方法
	 * @param book
	 */
	public void save(Book book) {
		System.out.println("service中的save 方法执行了");
		bookDao.save(book);
	}
	
	public void updata(Book book){
		bookDao.update(book);
	}
	
	public Book findById(Integer id){
		return bookDao.findById(id);
	}
	public void delete(Book book){
		bookDao.delete(book);
	}
	public List<Book> findAll(){
		return bookDao.findAll();
	}
	public List<Book> findAllByCriteria(){
		return bookDao.findAllByCriteria();
	}
	public List<Book> findAllByCriteriaPage(){
		return bookDao.findAllByCriteriaPage();
	}
	public List<Book> findAllByNamedQuery(){
		return bookDao.findAllByNamedQuery();
	}
}
