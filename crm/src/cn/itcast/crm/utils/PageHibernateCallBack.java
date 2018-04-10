package cn.itcast.crm.utils;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

import cn.itcast.crm.domain.CourseType;

public class PageHibernateCallBack<T> implements HibernateCallback<List<T>> {
	private String hql;
	private Object[] params;
	private int firstResult;
	private int maxResults;
	public PageHibernateCallBack(String hql,Object[] params,int firstResult,int maxResults){
		this.hql = hql;
		this.params = params;
		this.firstResult = firstResult;
		this.maxResults = maxResults;
	}
	@Override
	public List<T> doInHibernate(Session session) throws HibernateException {
		Query query = session.createQuery(hql);
		for(int i=0;i<params.length;i++){
			query.setParameter(i, params[i]);
		}
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		return query.list();
	}
	
}
