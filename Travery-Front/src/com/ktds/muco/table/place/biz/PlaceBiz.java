package com.ktds.muco.table.place.biz;

import java.util.List;

import com.ktds.muco.table.place.dao.PlaceDAO;
import com.ktds.muco.table.place.vo.PlaceVO;

/**
 * 
 * @author 김광민
 *
 */
public class PlaceBiz {
	/**
	 * 
	 * @author 김동규
	 *
	 */
	private PlaceDAO placeDAO;

	public PlaceBiz() {
		placeDAO = new PlaceDAO();
	}

	public List<PlaceVO> placeInfoRecommendedList(int placeId) {
		
		return placeDAO.placeInfoRecommendedList(placeId);
	}

	public int placeInfoCreate(PlaceVO placeVO) {

		String Description = placeVO.getDescription();
		Description = Description.replaceAll("\n", "<br/>");
		placeVO.setDescription(Description);
		return placeDAO.insertPlaceInfo(placeVO);
	}

}
