package com.ktds.muco.table.place.biz;

import com.ktds.muco.table.image.vo.ImageVO;
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

	public ImageVO placeInfoRecommendedList(PlaceVO placeVO) {
		
		return placeDAO.placeInfoRecommendedList(placeVO);
	}

	public PlaceVO placeInfoCreate(PlaceVO placeVO) {

		String Description = placeVO.getDescription();
		Description = Description.replaceAll("\n", "<br/>");
		placeVO.setDescription(Description);
		return placeDAO.insertPlaceInfo(placeVO);
	}

}
