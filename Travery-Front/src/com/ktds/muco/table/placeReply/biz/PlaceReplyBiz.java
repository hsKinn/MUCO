package com.ktds.muco.table.placeReply.biz;

import com.ktds.muco.table.placeReply.dao.PlaceReplyDAO;
import com.ktds.muco.table.placeReply.vo.PlaceReplyVO;

/**
 * 
 * @author 김동규
 *
 */
public class PlaceReplyBiz {

	private PlaceReplyDAO placeReplyDAO;
	
	public PlaceReplyBiz() {
		placeReplyDAO = new PlaceReplyDAO();
	}
	
	
	/**
	 * addNewPlaceReplyDepthOne
	 * 
	 * @author 김동규
	 * 
	 * @param placeReply
	 * @return
	 */

	public boolean addNewPlaceReplyDepthOne(PlaceReplyVO placeReply) {
		int orderNo = this.getNewPlaceOrderNo(placeReply);
		placeReply.setOrderNo(orderNo);
		
		if ( orderNo > 0 ) {
			placeReplyDAO.updatePlaceOrderNoByGroupId(placeReply);
		}

		return placeReplyDAO.insertPlaceReply(placeReply) > 0;
		
	}
	
	
	/**
	 * getNewPlaceOrderNo
	 * 
	 * @author 김동규
	 * 
	 * @param placeReply
	 * @return
	 */
	public int getNewPlaceOrderNo(PlaceReplyVO placeReply) {
		if ( placeReplyDAO.selectPlaceCountParentReplyId(placeReply) > 0 ) {
			
			int newOrderNo = placeReplyDAO.selectPlaceMaxOrderNoByParentReplyId(placeReply);
			return newOrderNo + 1;
		}
		else {
			
			if ( placeReply.getParentReplyId() != 0 ) {
				int newOrderNo = placeReplyDAO.selectPlaceLatestOrderNoByParentReplyId(placeReply);
				return newOrderNo + 1;
			}
		}
			
		return 0;
	}
	
	
	/**
	 * Delete Place Reply By Place Reply ID
	 * 
	 * @author 김현섭
	 * 
	 * @param placeReplyId
	 * @return
	 */
	public boolean deletePlaceReply(int placeReplyId) {
		
		if ( placeReplyDAO.deletePlaceReply(placeReplyId) > 0) {
			return true;
		}
		else {
			return false;
		}
	} // deletePlaceReply END
	
}
