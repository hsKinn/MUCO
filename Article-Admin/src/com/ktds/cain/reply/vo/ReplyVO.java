package com.ktds.cain.reply.vo;

import com.ktds.cain.article.vo.ArticleVO;

public class ReplyVO extends ArticleVO {
	private int replyId;
	private String description;
	private int groupId;
	private int parentReplyId;
	private int depth;
	private int orderNo;
	
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
