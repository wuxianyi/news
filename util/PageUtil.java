package com.bdqn.util;

import java.util.List;

public class PageUtil {

	private Integer currPage;
	private Integer pageSize;
	private Integer count;
	private List<?> list;
	
	public PageUtil(Integer currPage, Integer pageSize, Integer count, List<?> list) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.count = count;
		this.list = list;
	}
	public PageUtil() {
		super();
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	
	
}
