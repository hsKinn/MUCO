package com.ktds.muco.table.place.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ktds.muco.table.place.dao.PlaceDAO;
import com.ktds.muco.table.place.vo.PlaceListVO;
import com.ktds.muco.table.place.vo.PlaceSearchVO;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.table.reserve.vo.ReserveListVO;
import com.ktds.muco.table.reserve.vo.ReserveSearchVO;
import com.ktds.muco.util.web.Paging;

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

	public List<PlaceVO> placeInfoRecommendedList() {
		return placeDAO.placeInfoRecommendedList();
	}

	public int placeInfoCreate(PlaceVO placeVO) {

		String Description = placeVO.getDescription();
		Description = Description.replaceAll("\n", "<br/>");
		placeVO.setDescription(Description);
		return placeDAO.insertPlaceInfo(placeVO);
	}
	
	/**
	 * placeId로 place list 받기
	 * @author 이기연
	 * @param placeSearchVO
	 * @param sortOption 
	 * @return
	 */
	public PlaceListVO getPlaceList(PlaceSearchVO placeSearchVO, int sortOption, int placeType) {
		
		// 1. 전체 게시글의 수
		int allPlaceCount = placeDAO.getAllPlaceCount(placeSearchVO, placeType);
		// 1-1. 기본으로 페이지를 만들어준다. 
		Paging paging = new Paging(20);
		paging.setTotalArticleCount(allPlaceCount);
		// 1-2. page 가져올 때 계산 쉽게 하기 위해서 page number은 0부터 시작 
		paging.setPageNumber(placeSearchVO.getPageNO()+"");
		
		placeSearchVO.setStartIndex(paging.getStartArticleNumber());
		placeSearchVO.setEndIndex(paging.getEndArticleNumber());
		
		//전체 article 받아오기
		List<PlaceVO> places = placeDAO.getAllPlaces(placeSearchVO, sortOption, placeType);
		
		// 2. DAO로부터 받아온 결과를 출력
		PlaceListVO originPlaceList = new PlaceListVO();
		originPlaceList.setPlaceList(places); 
		// 2-2. 페이지 추가 
		originPlaceList.setPaging(paging);
		
		return originPlaceList;
	}

	
	/**
	 * 
	 * @author 이기연
	 * @param placeId
	 * @return
	 */
	public PlaceVO showPlaceDetail(String placeId) {

		PlaceVO placeVO = placeDAO.getPlaceDetailByPlaceId(placeId);
		return placeVO;
	}

	/**
	 * @author 이기연 
	 * place 삭제
	 * @param placeId
	 */
	public void detelePlaceByPlaceId(int placeId) {
		placeDAO.deletePlaceByPlaceId(placeId);
	}

	/**
	 * @author 이기연
	 * place를 massive delete 하는 biz
	 * @param deletePlaceIds
	 */
	public void deletePlaces(String[] deletePlaceIds) {
		for (String placeId : deletePlaceIds) {
			placeDAO.deletePlaceByPlaceId(Integer.parseInt(placeId));
		}		
	}

	/**
	 * @author 이기연
	 * placeId로 goOriginPlace
	 * @param placeId
	 */
	public void goOriginPlaceByPlaceId(int placeId) {
		placeDAO.goOriginPlaceByPlaceId(placeId);
	}

	/**
	 * @author 이기연
	 * place를 Origin place로 보내는 massive go origin Biz
	 * @param deletePlaceIds
	 */
	public void goOriginPlaces(String[] deletePlaceIds) {
		for (String placeId : deletePlaceIds) {
			placeDAO.goOriginPlaceByPlaceId(Integer.parseInt(placeId));
		}	
	}
	/**
	 * @author 이기연
	 * place를 New place로 보내는 go origin Biz
	 * @param placeId
	 */
	public void goNewPlaceByPlaceId(int placeId) {
		placeDAO.goNewPlaceByPlaceId(placeId);
		
	}

	/**
	 * @author 이기연
	 * place 여러개를 New place로 보내는 massive go origin Biz
	 * @param deletePlaceIds
	 */
	public void goNewPlaces(String[] deletePlaceIds) {
		for (String placeId : deletePlaceIds) {
			placeDAO.goNewPlaceByPlaceId(Integer.parseInt(placeId));
		}	
	}
	
	
	/**
	 * @author place를 수정하는 method
	 * @param placeId
	 * @param placeVO
	 * @param request 
	 * @return 
	 */
	public PlaceVO doPlaceEdit(String placeId, PlaceVO placeVO, HttpServletRequest request) {
		// 어느 부분이 수정되었는지 확인해야한다. 
		String updatedPlaceName = request.getParameter("placeNameInputBox");
		String updatedDescription = request.getParameter("placeDescriptionInputBox");
		
		//1. 여행지명 
		if( placeVO.getPlaceName().equals(updatedPlaceName)) {
		} else {
			placeDAO.updatePlaceName(placeId, updatedPlaceName);
		}
		//2. 여행지 설명
		if (placeVO.getDescription().equals(updatedDescription)) {
		} else {
			placeDAO.updateDescription(placeId, updatedDescription);
		}
		
		return null;
	}

}
