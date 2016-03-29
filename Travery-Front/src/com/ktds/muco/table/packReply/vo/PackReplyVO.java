package com.ktds.muco.table.packReply.vo;

import com.ktds.muco.table.pack.vo.PackVO;

/**
 * 
 * 나만의 여행 패키지 댓글
 * 
 * @author 김광민
 *
 */
public class PackReplyVO extends PackVO {

	private int packReplyId;
	private String description;
	private int groupId;
	private int parentReplyId;
	private int depth;
	private int orderNo;
	private String createdDate;

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

	public int getPackReplyId() {
		return packReplyId;
	}

	public void setPackReplyId(int packReplyId) {
		this.packReplyId = packReplyId;
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
