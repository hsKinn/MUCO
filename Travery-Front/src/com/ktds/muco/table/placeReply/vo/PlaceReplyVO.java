package com.ktds.muco.table.placeReply.vo;

import com.ktds.muco.table.member.vo.MemberVO;

public class PlaceReplyVO extends MemberVO {

	private int placeReplyId;
	private String description;
	private String createdDate;

	public int getPlaceReplyId() {
		return placeReplyId;
	}

	public void setPlaceReplyId(int placeReplyId) {
		this.placeReplyId = placeReplyId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

}
