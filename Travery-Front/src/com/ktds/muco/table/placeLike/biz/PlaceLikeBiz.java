package com.ktds.muco.table.placeLike.biz;

import com.ktds.muco.table.placeLike.dao.PlaceLikeDAO;
import com.ktds.muco.table.placeLike.vo.PlaceLikeVO;

public class PlaceLikeBiz {

	private PlaceLikeDAO placeLikeDAO;
	
	public PlaceLikeBiz() {
		placeLikeDAO = new PlaceLikeDAO();
	}
	/**
	 * insertOrDeletePlaceLike
	 * 
	 * @author 김동규
	 * 
	 * @param placeLikeVO
	 */
	public void insertOrDeletePlaceLike(PlaceLikeVO placeLikeVO) {
		if ( isExistPlaceLike(placeLikeVO) ) {
			placeLikeDAO.deletePlaceLike(placeLikeVO);
		}
		else {
			placeLikeDAO.insertPlaceLike(placeLikeVO);
		}
	}
	/**
	 * isExistPlaceLike
	 * 
	 * @author 김동규
	 * 
	 * @param placeLikeVO
	 * @return
	 */
	public boolean isExistPlaceLike(PlaceLikeVO placeLikeVO) {
		return placeLikeDAO.selectPlaceLikeCount(placeLikeVO) > 0;
	}

}
