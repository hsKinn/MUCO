package com.ktds.muco.table.packReply.vo;

import com.ktds.muco.table.pack.vo.PackVO;

public class PackReplyVO extends PackVO {

	private int packReplyId;
	private String description;
	private String createdDate;

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
