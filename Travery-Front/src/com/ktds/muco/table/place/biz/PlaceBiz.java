package com.ktds.muco.table.place.biz;

import com.ktds.muco.table.image.dao.ImageDAO;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.dao.PlaceDAO;
import com.ktds.muco.table.place.vo.PlaceListVO;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.table.place.vo.RecommendPlaceListVO;

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
	
	
	/**
	 * Get Top Recommend Place List
	 * 
	 * @author 김현섭
	 * 
	 * @return
	 */
	public RecommendPlaceListVO getTopRecommendPlace () {
		
		RecommendPlaceListVO recommendPlaceList = new RecommendPlaceListVO();
		
		recommendPlaceList.setDailyList(placeDAO.getPlaceListByDaily());
		recommendPlaceList.setWeeklyList(placeDAO.getPlaceListByWeekly());
		recommendPlaceList.setMonthlyList(placeDAO.getPlaceListByMonthly());
		
		return recommendPlaceList;
		
	} // getTopRecommendPlace END
	

	public PlaceListVO getUserRecommendList(MemberVO member) {

		PlaceListVO placeListVO = new PlaceListVO();
		placeListVO.setPlaceList(placeDAO.getUserRecommendPlaceList(member));
		placeListVO.setImageList(imageDAO.getImageLocationList(member));
		return placeListVO;
	}

	public PlaceVO placeInfoCreate(PlaceVO placeVO) {

		String Description = placeVO.getPlaceDescription();
		Description = Description.replaceAll("\n", "<br/>");
		placeVO.setPlaceDescription(Description);
		return placeDAO.insertPlaceInfo(placeVO);
	}
}
