package com.ktds.muco.table.placeReply.vo;

import com.ktds.muco.table.member.vo.MemberVO;

/**
 * 
 * @author 김광민
 *
 */
public class PlaceReplyVO extends MemberVO {

	private int placeReplyId;
	private String placeReplyDescription;
	private String createdDate;

	public int getPlaceReplyId() {
		return placeReplyId;
	}

	public void setPlaceReplyId(int placeReplyId) {
		this.placeReplyId = placeReplyId;
	}

	public String getPlaceReplyDescription() {
		return placeReplyDescription;
	}

	public void setPlaceReplyDescription(String placeReplyDescription) {
		this.placeReplyDescription = placeReplyDescription;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

}
