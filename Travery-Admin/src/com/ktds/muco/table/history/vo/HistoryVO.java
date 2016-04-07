package com.ktds.muco.table.history.vo;

import com.ktds.muco.table.member.vo.MemberVO;

/**
 * 
 * @author 김광민
 *
 */
public class HistoryVO extends MemberVO {

	private int historyId;
	private String ip;
	private String createdDate;
	private String url;
	private String actionCode;
	private String historyDescription;
	private String etc;

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getHistoryDescription() {
		return historyDescription;
	}

	public void setHistoryDescription(String historyDescription) {
		this.historyDescription = historyDescription;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

}
