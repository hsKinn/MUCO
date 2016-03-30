package com.ktds.muco.table.place.biz;

import com.ktds.muco.table.image.dao.ImageDAO;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.dao.PlaceDAO;
import com.ktds.muco.table.place.vo.PlaceListVO;
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
	private ImageDAO imageDAO;

	public PlaceBiz() {
		placeDAO = new PlaceDAO();
		imageDAO = new ImageDAO();
	}

	public PlaceListVO getUserRecommendList(MemberVO member) {
		
		PlaceListVO placeListVO = new PlaceListVO();
		placeListVO.setPlaceList(placeDAO.getUserRecommendPlaceList(member));
		placeListVO.setImageList(imageDAO.getImageLocationList(member));
		return placeListVO;
	}

	public PlaceVO placeInfoCreate(PlaceVO placeVO) {

		String Description = placeVO.getDescription();
		Description = Description.replaceAll("\n", "<br/>");
		placeVO.setDescription(Description);
		return placeDAO.insertPlaceInfo(placeVO);
	}
}
