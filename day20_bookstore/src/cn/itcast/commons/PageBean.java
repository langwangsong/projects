package cn.itcast.commons;

import java.util.List;

//封装了所有与分页有关的数据
public class PageBean {
	private List beanList;//分页记录
	private int currentPageNum;//当前页码
	private int pageSize=3;//每页显示的记录条数
	private int totalRecordsNum;//总记录条数
	private int startIndex;//每页开始记录的索引
	private int totalPageSize;//总页码数
	private int prePageNum;//上一页页码
	private int nextPageNum;//下一页页码
	
	private String url;//查询分页的访问地址
	
	public PageBean(int currentPageNum,int totalRecordsNum){
		this.currentPageNum = currentPageNum;
		this.totalRecordsNum = totalRecordsNum;
		//计算每页开始的索引
		startIndex = (currentPageNum -1)*pageSize;
		//计算总页数
		totalPageSize = totalRecordsNum % pageSize == 0 ? totalRecordsNum / pageSize : (totalRecordsNum / pageSize +1);
		prePageNum = currentPageNum-1 < 1 ? 1 : (currentPageNum-1);
		nextPageNum = currentPageNum+1 > totalPageSize ? totalPageSize : (currentPageNum+1);
	}
	
	public List getBeanList() {
		return beanList;
	}
	public void setBeanList(List beanList) {
		this.beanList = beanList;
	}
	public int getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecordsNum() {
		return totalRecordsNum;
	}
	public void setTotalRecordsNum(int totalRecordsNum) {
		this.totalRecordsNum = totalRecordsNum;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalPageSize() {
		return totalPageSize;
	}
	public void setTotalPageSize(int totalPageSize) {
		this.totalPageSize = totalPageSize;
	}
	public int getPrePageNum() {
		return prePageNum;
	}
	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}
	public int getNextPageNum() {
		return nextPageNum;
	}
	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
