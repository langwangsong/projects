package cn.itcast.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {
	void save(T t);
	void update(T t);
	void delete(Serializable id);
	T findOne(Serializable id);
}
