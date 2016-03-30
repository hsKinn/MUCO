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
	private String packReplyDescription;
	private String createdDate;

	public int getPackReplyId() {
		return packReplyId;
	}

	public void setPackReplyId(int packReplyId) {
		this.packReplyId = packReplyId;
	}

	public String getPackReplyDescription() {
		return packReplyDescription;
	}

	public void setPackReplyDescription(String packReplyDescription) {
		this.packReplyDescription = packReplyDescription;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

}
