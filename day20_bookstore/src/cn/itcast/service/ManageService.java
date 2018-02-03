package cn.itcast.service;

import java.util.List;

import cn.itcast.commons.PageBean;
import cn.itcast.domain.Book;
import cn.itcast.manage.domain.Category;

/**
 * 接口中注释要写明确，不能有歧义
 * 后台管理业务接口
 * @author Mr_lang
 *
 */
public interface ManageService {
	/**
	 * 添加分类
	 * @param category
	 */
	void addCategory(Category category);
	/**
	 * 根据id查询分类
	 * @param categoryId
	 * @return  没有找到，返回null
	 */
	Category findCategoryById(String categoryId);
	/**
	 * 查询所有分类
	 * @return
	 */
	List<Category> findAllCategories();
	/**
	 * 根据分类名称查询是否存在
	 * @param categoryName
	 * @return 存在返回true，不存在返回false
	 */
	boolean isCategoryExist(String categoryName);
	/**
	 * 保存书籍
	 * @param book
	 */
	void saveBook(Book book);
	/**
	 * 根据要查询的页码，返回封装了所有分页信息的PageBean对象
	 * @param pagenum:如果为null或“” ，默认第一页
	 * @return
	 */
	PageBean findBooksPageBean(String pagenum);
	/**
	 * 根据要查询的页码和类别，返回封装了所有分页信息的PageBean对象
	 * @param pagenum:如果为null或“” ，默认第一页
	 * @return
	 */
	PageBean findBooksPageBean(String pagenum, String categoryid);
	/**
	 * 根据书籍id查询书籍，吧书籍对应的分类查询出来
	 * @param bookid
	 * @return
	 */
	Book findBookById(String bookid);
}
