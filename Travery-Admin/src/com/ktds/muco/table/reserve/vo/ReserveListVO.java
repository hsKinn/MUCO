package com.ktds.muco.table.reserve.vo;

import java.util.List;

import com.ktds.muco.util.web.Paging;

public class ReserveListVO {
	private List<ReserveVO> reserveList;
	public List<ReserveVO> getReserveList() {
		return reserveList;
	}
	public void setReserveList(List<ReserveVO> reserveList) {
		this.reserveList = reserveList;
	}
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	private Paging paging;
}
