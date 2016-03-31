package com.ktds.muco.table.placeReply.vo;

import com.ktds.muco.table.member.vo.MemberVO;

/**
 * 
 * @author 김광민
 *
 */
public class PlaceReplyVO extends MemberVO {
	/**
	 *
	 * @modify 김동규
	 *	int groupId / int parentReplyId / int depth / int orderNo
	 *	created
	 */
	private int placeReplyId;
	private String placeReplyDescription;
	private int groupId;
	private int parentReplyId;
	private int depth;
	private int orderNo;
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

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getParentReplyId() {
		return parentReplyId;
	}

	public void setParentReplyId(int parentReplyId) {
		this.parentReplyId = parentReplyId;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
}
