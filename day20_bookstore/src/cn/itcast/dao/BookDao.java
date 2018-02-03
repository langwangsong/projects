package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Book;

public interface BookDao {

	void save(Book book);
	/**
	 * 查询所有书籍的数量
	 * @return
	 */
	int findRecordsNum();
	/**
	 * 查询分页记录
	 * @param startIndex 开始索引
	 * @param pageSize 一次查询几条
	 * @return
	 */
	List<Book> findBooks(int startIndex, int pageSize);
	/**
	 * 查询指定类别的书籍数量
	 * @param categoryid
	 * @return
	 */
	int findRecordsNum(String categoryid);
	/**
	 * 查询指定类别的分页记录
	 * @param startIndex 开始索引
	 * @param pageSize 一次查询几条
	 * @param categoryid 类别
	 * @return
	 */
	List findBooks(int startIndex, int pageSize, String categoryid);
	/**
	 * 查询书籍，顺便查询对应的类别
	 * @param bookid
	 * @return
	 */
	Book findBookById(String bookid);
}
