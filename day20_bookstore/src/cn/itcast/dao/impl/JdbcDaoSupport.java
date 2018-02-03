package cn.itcast.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import cn.itcast.util.C3P0Util;
//来自Spring框架 
//dao实现的辅助类

public abstract class JdbcDaoSupport {
	private QueryRunner qr;
	public JdbcDaoSupport(){
		if(qr == null){
			qr = new QueryRunner(C3P0Util.getDataSource());
		}
	}
	public void update(String sql,Object... params){
		try {
			qr.update(sql,params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public <T> T query(String sql,ResultSetHandler<T> rsh,Object... params){
		try {
			return qr.query(sql, rsh,params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public int[] batch(String sql,Object[][] params){
		try {
			return qr.batch(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public QueryRunner getQr() {
		return qr;
	}
	public void setQr(QueryRunner qr) {
		this.qr = qr;
	}
}
