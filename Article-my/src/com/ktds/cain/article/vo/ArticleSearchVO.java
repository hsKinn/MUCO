package com.ktds.cain.article.vo;

public class ArticleSearchVO {

	private int pageNo;
	private int startIndex;
	private int endIndex;

	//	private String searchKey; - 차후에 추가될 수 있다.
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
}
