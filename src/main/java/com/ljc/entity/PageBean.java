package com.ljc.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author LJC 
 * 数据分页Bean
 */
public class PageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int currentPage;// 当前页
	private int pageSize;// 每页大小
	private int count;// 数据总数
	private int totalPage;// 总页数
	private List<?> list;// 数据list

	public PageBean(int currentPage, int pageSize, int count, int totalPage,
			List<?> list) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.count = count;
		this.totalPage = totalPage;
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

}
