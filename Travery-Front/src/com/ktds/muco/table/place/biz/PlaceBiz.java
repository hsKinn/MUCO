package com.ktds.muco.table.place.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.image.dao.ImageDAO;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.dao.PlaceDAO;
import com.ktds.muco.table.place.vo.PlaceListVO;
import com.ktds.muco.table.place.vo.PlaceSearchVO;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.table.place.vo.RecommendPlaceListVO;
import com.ktds.muco.util.web.Paging;

/**
 * 
 * @author 김광민
 *
 */
public class PlaceBiz {

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
	public RecommendPlaceListVO getTopRecommendPlace ( MemberVO member ) {
		
		RecommendPlaceListVO recommendPlaceList = new RecommendPlaceListVO();
		
		recommendPlaceList.setDailyList(placeDAO.getPlaceListByDaily(member));
		recommendPlaceList.setWeeklyList(placeDAO.getPlaceListByWeekly(member));
		recommendPlaceList.setMonthlyList(placeDAO.getPlaceListByMonthly(member));
		
		return recommendPlaceList;
		
	} // getTopRecommendPlace END
	
	
	/**
	 * getAllRecommendPlaceList
	 * 
	 * @author 김동규
	 * 
	 * @param placeSearchVO
	 * @return
	 */
	public PlaceListVO getAllRecommendPlaceList(PlaceSearchVO placeSearchVO, MemberVO member, int sortOption) {
		
		int allPlaceCount = 0;
		int placeCountByPlaceName = 0;
		
		Paging paging = new Paging(4);
		List<PlaceVO> placeList = new ArrayList<PlaceVO>();
		
		if ( placeSearchVO.getSearchKeyword().isEmpty() ) {
			allPlaceCount = placeDAO.getAllPlaceCount(placeSearchVO);
			paging.setTotalArticleCount(allPlaceCount);
		} 
		else {
			placeCountByPlaceName = placeDAO.getPlaceCountByPlaceName(placeSearchVO);
			paging.setTotalArticleCount(placeCountByPlaceName);
		}
		
		paging.setPageNumber(placeSearchVO.getPageNo() + ""); 
		
		placeSearchVO.setStartIndex( paging.getStartArticleNumber() );
		placeSearchVO.setEndIndex( paging.getEndArticleNumber() );
		
		// Get List
		/*
		 * Sort Option 1 : Like Count DESC 2 : View Count DESC 3 : Create Date
		 * ASC
		 * 
		 */
		if ( placeSearchVO.getSearchKeyword().isEmpty() ) {
			if (sortOption == 1) {
				placeList = placeDAO.getAllPlaceList(placeSearchVO, member);
			} 
			else if (sortOption == 2) {
				placeList = placeDAO.getAllPlaceListOrderByView(placeSearchVO, member);
			} 
			else if (sortOption == 3) {
				placeList = placeDAO.getAllPlaceListOrderByDate(placeSearchVO, member);
			}
		}
		else {
			if (sortOption == 1) {
				placeList = placeDAO.getPlaceListByPlaceName(placeSearchVO, member);
			} 
			else if (sortOption == 2) {
				placeList = placeDAO.getPlaceListByPlaceNameOrderByView(placeSearchVO, member);
			} 
			else if (sortOption == 3) {
				placeList = placeDAO.getPlaceListByPlaceNameOrderByDate(placeSearchVO, member);
			}			
		}
	
		PlaceListVO placeListVO = new PlaceListVO();
		placeListVO.setPlaceList(placeList);
		placeListVO.setPaging(paging);
		
		return placeListVO;
	}
	
	
	/**
	 * viewCountRecommendPlace
	 * 
	 * @author 김동규
	 * 
	 * @param int placeId
	 * @return 
	 */
	public boolean viewCountRecommendPlace(int placeId) {

		return placeDAO.viewCountRecommendPlace(placeId) > 0;

	} 
	
	/**
	 * Get User Recommend Place List
	 * 
	 * @author 김현섭
	 * 
	 * @param member
	 * @return
	 */
	public List<PlaceVO> getUserRecommendList(MemberVO member) {

		return placeDAO.getUserRecommendPlaceList(member);
	}
	
	/**
	 * 
	 * @param placeVO
	 * @return
	 */

	public PlaceVO placeInfoCreate(PlaceVO placeVO) {

		String Description = placeVO.getPlaceDescription();
		Description = Description.replaceAll("\n", "<br/>");
		placeVO.setPlaceDescription(Description);
		return placeDAO.insertPlaceInfo(placeVO);
	}
}
