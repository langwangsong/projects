package cn.itcast.ssh.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.itcast.ssh.domain.Book;

/**
 * 图书管理的DAO类
 * @author Mr_lang
 *
 */
public class BookDao extends HibernateDaoSupport{
	
	/**
	 * DAO的save方法
	 * @param book
	 */
	public void save(Book book) {
		System.out.println("DAO中的save方法执行了。。。");
		this.getHibernateTemplate().save(book);
	}
	/**
	 * DAO中的update方法
	 */
	public void update(Book book){
		this.getHibernateTemplate().update(book);
	}
	/**
	 * DAO中查询一个对象
	 */
	public Book findById(Integer id){
		//return this.getHibernateTemplate().get(Book.class, id);
		return this.getHibernateTemplate().load(Book.class, id);
	}
	/**
	 * DAO中删除对象
	 */
	public void delete(Book book){
		this.getHibernateTemplate().delete(book);
	}
	/**
	 * DAO中返回多条
	 */
	public List<Book> findAll(){
		return  (List<Book>) this.getHibernateTemplate().find("from Book");
	}
	/**
	 * DAO 中查询多天记录：QBC
	 */
	public List<Book> findAllByCriteria(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Book.class);
		return (List<Book>) this.getHibernateTemplate().findByCriteria(criteria);
	}
	/**
	 * DAO 中查询分页记录：QBC
	 */
	public List<Book> findAllByCriteriaPage(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Book.class);
		return (List<Book>) this.getHibernateTemplate().findByCriteria(criteria,0,1);
	}
	/**
	 * DAO 中查询多条记录：命名查询
	 */
	public List<Book> findAllByNamedQuery(){
		return (List<Book>) this.getHibernateTemplate().findByNamedQuery("findAll",48.0);
	}
}
