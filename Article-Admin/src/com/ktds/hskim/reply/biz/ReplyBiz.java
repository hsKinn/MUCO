package com.ktds.hskim.reply.biz;

import com.ktds.hskim.reply.dao.ReplyDAO;
import com.ktds.hskim.reply.vo.ReplyVO;

public class ReplyBiz {
	
	private ReplyDAO replyDAO;
	
	public ReplyBiz() {
		replyDAO = new ReplyDAO();
	}
	
	/**
	 * 댓글 등록
	 */
	public boolean addNewReplyDepthOne ( ReplyVO reply ) {

		int orderNo = this.getNewOrderNo(reply);
		reply.setOrderNo(orderNo);
		
		// 일반 댓글 아닐 시
		if ( orderNo > 0 ) {
			replyDAO.updateOrderNoByGroupId(reply);
		}

		return replyDAO.insertReply(reply) > 0;
	} // addNewReplyDepthOne end
	
	
	/**
	 * orderNo 변경
	 * 일반 댓글과 첫 번째 대댓글을 달 때
	 * depth 부모글의 depth + 1
	 * order 부모글의 orderNo + 1
	 * 
	 * 존재하는 대댓글을 달 때
	 * depth 부모 글의 depth + 1
	 * order 현재 ParentReplyId
	 */
	private int getNewOrderNo ( ReplyVO reply ) {
		
		if ( replyDAO.selectCountParentReplyId(reply) > 0 ) {
			// 존재할 경우
			int newOrderNo = replyDAO.selectMaxOrderNoByParentReplyId(reply);
			return newOrderNo + 1;
		}
		else {
			// 일반 댓글이나 첫 번째 대댓글인 경우
			// depth나 replyParentId로 일반 댓글이나 대댓글인 경우를 구분
			
			if ( reply.getParentReplyId() != 0 ) {
				int newOrderNo = replyDAO.selectLatestOrderNoByParentReplyId(reply);
				return newOrderNo + 1;
			}
		}
			
		return 0;
	} // getNewOrderNo end
	
	
}
