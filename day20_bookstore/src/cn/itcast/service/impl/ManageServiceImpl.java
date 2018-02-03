package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.commons.PageBean;
import cn.itcast.dao.BookDao;
import cn.itcast.dao.CategoryDao;
import cn.itcast.dao.impl.BookDaoImpl;
import cn.itcast.dao.impl.CategoryDaoImpl;
import cn.itcast.domain.Book;
import cn.itcast.manage.domain.Category;
import cn.itcast.service.ManageService;

public class ManageServiceImpl implements ManageService {
	private CategoryDao categoryDao = new CategoryDaoImpl();
	private BookDao bookDao = new BookDaoImpl();
	@Override
	public void addCategory(Category category) {
		//判断
		if(category == null)
			throw new IllegalArgumentException("保存的数据不能为空");
		categoryDao.save(category);
	}

	@Override
	public Category findCategoryById(String categoryId) {
		return categoryDao.findById(categoryId);
	}

	@Override
	public List<Category> findAllCategories() {
		return categoryDao.findAll();
	}

	@Override
	public boolean isCategoryExist(String categoryName) {
		if(categoryName == null || "".equals(categoryName.trim()))
			throw new IllegalArgumentException("要检查的分类名称不能为空");
		return categoryDao.findByName(categoryName)==null?false:true;
	}

	@Override
	public void saveBook(Book book) {
		if(book==null){
			throw new IllegalArgumentException("要保存的书籍不能为空");
		}
		if(book.getCategory()==null){
			throw new IllegalArgumentException("书籍必须制定分类");
		}
		bookDao.save(book);
	}

	@Override
	public PageBean findBooksPageBean(String pagenum) {
		int currentPageNum = 1;//默认页
		if(pagenum!=null && !"".equals(pagenum))
			currentPageNum = Integer.parseInt(pagenum);
		int totalRecordsNum = bookDao.findRecordsNum();//查询记录的总条数
		PageBean page = new PageBean(currentPageNum,totalRecordsNum);
		//查询分页记录
		List books = bookDao.findBooks(page.getStartIndex(),page.getPageSize());
		page.setBeanList(books);
		return page;
	}

	@Override
	public PageBean findBooksPageBean(String pagenum, String categoryid) {
		int currentPageNum = 1;//默认页
		if(pagenum!=null && !"".equals(pagenum))
			currentPageNum = Integer.parseInt(pagenum);
		int totalRecordsNum = bookDao.findRecordsNum(categoryid);//查询记录的总条数
		PageBean page = new PageBean(currentPageNum,totalRecordsNum);
		//查询分页记录
		List books = bookDao.findBooks(page.getStartIndex(),page.getPageSize(),categoryid);
		page.setBeanList(books);
		return page;
	}

	@Override
	public Book findBookById(String bookid) {
		return bookDao.findBookById(bookid);
	}

}
