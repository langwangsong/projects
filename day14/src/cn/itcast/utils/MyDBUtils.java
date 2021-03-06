package cn.itcast.utils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.itcast.domain.Account;

/**
 * 山寨的DBUtils的工具与类
 * @author Mr_lang
 *
 */
public class MyDBUtils {
	/**
	 * 可以完成增删改的方法
	 */
	public void update(String sql,Object...params){
		//连接对象
		Connection conn =null;
		//能执行SQL语句的对象
		PreparedStatement stmt = null;
		try {
			//从连接池中获取连接
			conn = MyJdbcUtils3.getConn();
			//原来：自己来编写SQL语句，但是现在呢，不用自己写，把SQL语句传进来
			//直接预编译
			stmt = conn.prepareStatement(sql);
			//设置参数，参数现在载可变参数中存着，可以params获取到，动态设置值
			//先获取到参数元数据
			ParameterMetaData metaData = stmt.getParameterMetaData();
			//可以用过参数元数据获取到SQL语句中？ 的个数
			int count = metaData.getParameterCount();
			//使用循环，动态的设置值
			for(int i=1;i<=count;i++){
				//设置值
				stmt.setObject(i, params[i-1]);
			}
			//执行
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyJdbcUtils3.releaseAll(stmt, conn);
		}
	}
	public <T> T query(String sql,ResultSetHandler<T> rsh,Object...params){
		Connection conn =null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = MyJdbcUtils3.getConn();
			//直接预编译
			stmt = conn.prepareStatement(sql);
			//设置参数，参数现在载可变参数中存着，可以params获取到，动态设置值
			//先获取到参数元数据
			ParameterMetaData metaData = stmt.getParameterMetaData();
			//可以用过参数元数据获取到SQL语句中？ 的个数
			int count = metaData.getParameterCount();
			//使用循环，动态的设置值
			for(int i=1;i<=count;i++){
				//设置值
				stmt.setObject(i, params[i-1]);
			}
			//执行查询的语句
			rs = stmt.executeQuery();
			//原来：自己来封装结果集，但是现在，用户来封装结果集，提供接口的实现类来封装
			//我需要获取用户封装的结果集，返回给用户
			T result = rsh.handle(rs);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyJdbcUtils3.releaseAll(rs,stmt, conn);
		}
		return null;
	}	
}
