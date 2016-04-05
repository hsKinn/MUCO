package com.ktds.muco.table.reportedPlace.vo;

import com.ktds.muco.table.member.vo.MemberVO;

/**
 * 
 * @author 김현섭
 *
 */
public class ReportedPlaceVO extends MemberVO {
	
	private int reportId;
	private String reportDt;
	private String category;
	private String reportDescription;
	
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public String getReportDt() {
		return reportDt;
	}
	public void setReportDt(String reportDt) {
		this.reportDt = reportDt;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getReportDescription() {
		return reportDescription;
	}
	public void setReportDescription(String reportDescription) {
		this.reportDescription = reportDescription;
	}
	
}
