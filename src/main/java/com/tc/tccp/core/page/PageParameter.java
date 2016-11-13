package com.tc.tccp.core.page;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年10月12日 下午10:52:29 
 * 拦截器实现mybatis的拦截
 */
import java.util.List;

public class PageParameter {

	public static final int DEFAULT_PAGE_SIZE = 10;

	private int pageSize;// 页面大小
	private int currentPage;// 当前页的位置
	private int prePage;// 上一页
	private int nextPage;// 下一页
	private int totalPage;// 总页数
	private int totalCount;// 总条数
	/**
	 * 当前页的数据
	 */
	private List<?> list;

	/**
	 * 获得分页内容
	 *
	 * @return
	 */
	public List<?> getList() {
		return list;
	}

	public PageParameter(int pageSize, int currentPage, int prePage,
			int nextPage, int totalPage, int totalCount, List<?> list) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.prePage = prePage;
		this.nextPage = nextPage;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
		this.list = list;
	}

	/**
	 * 设置分页内容
	 *
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	public void setList(List list) {
		this.list = list;
	}

	public PageParameter() {
		this.currentPage = 1;
		this.pageSize = DEFAULT_PAGE_SIZE;
	}

	/**
	 *
	 * @param currentPage
	 * @param pageSize
	 */
	public PageParameter(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
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

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String toString() {
		return "pageSize=" + pageSize + "currentPage=" + currentPage
				+ "prePage=" + prePage + "nextPage=" + nextPage + "totalPage="
				+ totalPage + "totalCount=" + totalCount;
	}

}
