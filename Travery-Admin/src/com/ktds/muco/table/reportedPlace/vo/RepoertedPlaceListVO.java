package com.ktds.muco.table.reportedPlace.vo;

import java.util.List;

import com.ktds.muco.util.web.Paging;

public class RepoertedPlaceListVO {
	private List<ReportedPlaceVO> reportedPlaceList;
	private Paging paging;
	
	public List<ReportedPlaceVO> getReportedPlaceList() {
		return reportedPlaceList;
	}
	public void setReportedPlaceList(List<ReportedPlaceVO> reportedPlaceList) {
		this.reportedPlaceList = reportedPlaceList;
	}
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	

}
