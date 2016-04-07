package com.ktds.muco.table.qna.vo;

import java.util.List;

import com.ktds.muco.util.web.Paging;

public class QNAListVO {
	private List<QNAVO> qnaList;
	private Paging paging;
	public List<QNAVO> getQnaList() {
		return qnaList;
	}
	public void setQnaList(List<QNAVO> qnaList) {
		this.qnaList = qnaList;
	}
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	
	
}
