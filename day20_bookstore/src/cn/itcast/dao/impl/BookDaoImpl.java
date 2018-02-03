package cn.itcast.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.dao.BookDao;
import cn.itcast.domain.Book;
import cn.itcast.manage.domain.Category;

public class BookDaoImpl extends JdbcDaoSupport implements BookDao {

	@Override
	public void save(Book book) {
		String sql = "insert into books (name,author,price,filename,path,description,categoryid) values (?,?,?,?,?,?,?)";
		update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getFilename(),
					book.getPath(),book.getDescription(),book.getCategory()==null?null:book.getCategory().getId());
	}

	@Override
	public int findRecordsNum() {
		String sql = "select count(*) from books";
		Long num = (Long)query(sql,new ScalarHandler(1));
		return num.intValue();
	}
	//因为多本书籍可能对应一个分类，查
	@Override
	public List<Book> findBooks(int startIndex, int pageSize) {
		String sql1 = "select * from books limit ?,?";
		List<Book> books = query(sql1,new BeanListHandler<Book>(Book.class),startIndex,pageSize);
		//查询书籍对应的分类
		for (Book book : books) {
			String sql2="select * from categories where id=(select categoryid from books where id=?)";
			Category category = query(sql2,new BeanHandler<Category>(Category.class),book.getId());
			book.setCategory(category);
		}
		return books;
	}

	@Override
	public int findRecordsNum(String categoryid) {
		String sql = "select count(*) from books where categoryid=?";
		Long num = (Long)query(sql,new ScalarHandler(1),categoryid);
		return num.intValue();
	}

	@Override
	public List findBooks(int startIndex, int pageSize, String categoryid) {
		String sql1 = "select * from books where categoryid=? limit ?,?";
		List<Book> books = query(sql1,new BeanListHandler<Book>(Book.class),categoryid,startIndex,pageSize);
		//查询书籍对应的分类
		for (Book book : books) {
			String sql2="select * from categories where id=(select categoryid from books where id=?)";
			Category category = query(sql2,new BeanHandler<Category>(Category.class),book.getId());
			book.setCategory(category);
		}
		return books;
	}

	@Override
	public Book findBookById(String bookid) {
		String sql1 = "select * from books where id=?";
		Book book = query(sql1,new BeanHandler<Book>(Book.class),bookid);
		//查询书籍对应的分类
		if(book != null) {
			String sql2="select * from categories where id=(select categoryid from books where id=?)";
			Category category = query(sql2,new BeanHandler<Category>(Category.class),book.getId());
			book.setCategory(category);
		}
		return book;
	}

}
