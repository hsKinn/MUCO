package com.ktds.cain.reply.biz;

import com.ktds.cain.reply.dao.ReplyDAO;
import com.ktds.cain.reply.vo.ReplyVO;

public class ReplyBiz {
	
	private ReplyDAO rdao;
	
	public ReplyBiz() {
		rdao = new ReplyDAO();
	}
	
	public boolean addNewReplyDepthOne(ReplyVO reply) {
		
//		일반 댓글 과 첫번째 대댓글을 달때
//		부모글의 depth +1
//		부모글의 order_no +1
//
//
//		부모 글의 depth + 1
//		현재 parentReplyId 값의 max + 1

		
		
		int orderNo = this.getNewOrderNo(reply);
		reply.setOrderNo(orderNo);
		
		if ( orderNo > 0 ) {
			rdao.updateOrderNoByGroupId(reply);
		}
		
		return rdao.insertReply(reply) > 0;
	}
	private int getNewOrderNo(ReplyVO reply) {
		
		if ( rdao.selectCountParentReplyId(reply) > 0 ) {
			int newOrderNo = rdao.selectMaxOrderNoByParentReplyId(reply);
			System.out.println("A" + newOrderNo);
			return newOrderNo + 1;
		}
		else {
			if( reply.getParentReplyId() != 0 ) {
				int newOrderNo = rdao.selectLatestOrderNoByParentReplyId(reply);
				System.out.println("B" + newOrderNo);
				return newOrderNo + 1;
			} //일반댓글일때
		}
		return 0;
	}
}
