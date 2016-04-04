package com.ktds.muco.table.packReply.biz;

import com.ktds.muco.table.packReply.dao.PackReplyDAO;
import com.ktds.muco.table.packReply.vo.PackReplyVO;

/**
 * 
 * @author 김광민
 *
 */
public class PackReplyBiz {
	
	private PackReplyDAO packReplyDAO;
	
	public PackReplyBiz() {
		packReplyDAO = new PackReplyDAO();
	}

	
	/**
	 * Add New Reply
	 * 
	 * @author 김현섭
	 * 
	 * @param packReply
	 * @return
	 */
	public boolean addNewReplyDepthOne( PackReplyVO packReply ) {
		
		int orderNo = this.getNewOrderNo(packReply);
		packReply.setOrderNo(orderNo);
		
		// 일반 댓글 아닐 시
		if ( orderNo > 0 ) {
			packReplyDAO.updateOrderNoByGroupId(packReply);
		}

		return packReplyDAO.insertReply(packReply) > 0;
	} // addNewReplyDepthOne END
	
	
	/**
	 * Get New Order Number
	 * 
	 * @author 김현섭
	 * 
	 * @param packReply
	 * @return
	 */
	private int getNewOrderNo ( PackReplyVO packReply ) {
		
		if ( packReplyDAO.selectCountParentReplyId(packReply) > 0 ) {
			// 존재할 경우
			int newOrderNo = packReplyDAO.selectMaxOrderNoByParentReplyId(packReply);
			return newOrderNo + 1;
		}
		else {
			// 일반 댓글이나 첫 번째 대댓글인 경우
			// depth나 replyParentId로 일반 댓글이나 대댓글인 경우를 구분
			
			if ( packReply.getParentReplyId() != 0 ) {
				int newOrderNo = packReplyDAO.selectLatestOrderNoByParentReplyId(packReply);
				return newOrderNo + 1;
			}
		}
			
		return 0;
	} // getNewOrderNo end

}