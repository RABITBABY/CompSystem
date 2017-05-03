package com.cs.util;

import java.util.List;

public class PageInfo<T> {

	private int total;//总页数
	private List<T> list;//集合
	private int index;//当前页
	private int pageSize;//每页多少条
	
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageInfo [total=" + total + ", list=" + list + ", index="
				+ index + ", pageSize=" + pageSize + "]";
	}
	
	
}
