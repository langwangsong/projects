package cn.itcast.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 用户使用通用的查询方法，那么必须实现该接口，提供该接口的实现类
 * @author Mr_lang
 *
 * @param <T>
 */
public interface ResultSetHandler<T> {
	/**
	 * 让用户自己来封装结果集
	 * @param rs
	 * @return
	 * @throws SQLException 
	 * @throws Exception 
	 */
	public T handle(ResultSet rs) throws SQLException;
}
