package cn.itcast.crm.dao;

import java.util.List;

/**
 * 通用的DAO接口
 * @author Mr_lang
 *
 */
public interface BaseDao<T> {
	public void save(T t);
	public void update(T t);
	public void delete(T t);
	public T findById(Integer id);
	public List<T> findAll();
	public int findCount();
	public List<T> findByPage(int begin,int pageSize);
}
