package cn.itcast.domain;

import java.util.List;

/**
 * 分页的JavaBean
 * @author Mr_lang
 *
 */
public class PageBean <T> {
	private int pageCode;
	private int totalCount;
	private int pageSize;
	private List<T> beanList;
	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	public int getTotalPage(){
		int totalPage = totalCount / pageSize;
		if(totalCount % pageSize ==0){
			return totalPage;
		}else{
			return totalPage +1;
		}
	}
}
