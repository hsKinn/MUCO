package com.ktds.muco.table.place.biz;

import java.util.List;

import com.ktds.muco.table.place.dao.PlaceDAO;
import com.ktds.muco.table.place.vo.PlaceListVO;
import com.ktds.muco.table.place.vo.PlaceSearchVO;
import com.ktds.muco.table.place.vo.PlaceVO;
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
	 * placeId로 origin place list 받기
	 * @author 이기연
	 * @param placeSearchVO
	 * @return
	 */
	public PlaceListVO getOriginPlaceList(PlaceSearchVO placeSearchVO) {
		
		// 1. 전체 게시글의 수
		int allPlaceCount = placeDAO.getAllOriginPlaceCount();
		// 1-1. 기본으로 페이지를 만들어준다. 
		Paging paging = new Paging(10);
		paging.setTotalArticleCount(allPlaceCount);
		// 1-2. page 가져올 때 계산 쉽게 하기 위해서 page number은 0부터 시작 
		paging.setPageNumber(placeSearchVO.getPageNO()+"");
		
		placeSearchVO.setStartIndex(paging.getStartArticleNumber());
		placeSearchVO.setEndIndex(paging.getEndArticleNumber());
		
		//전체 article 받아오기
		List<PlaceVO> places = placeDAO.getAllOriginPlaces(placeSearchVO);
		
		// 2. DAO로부터 받아온 결과를 출력
		PlaceListVO originPlaceList = new PlaceListVO();
		originPlaceList.setPlaceList(places); 
		// 2-2. 페이지 추가 
		originPlaceList.setPaging(paging);
		
		return originPlaceList;
	}

	/**
	 * placeId로 new place list 받기
	 * @author 이기연
	 * @param placeSearchVO
	 * @return
	 */
	public PlaceListVO getNewPlaceList(PlaceSearchVO placeSearchVO) {

		// 1. 전체 게시글의 수
		int allPlaceCount = placeDAO.getAllNewPlaceCount();
		// 1-1. 기본으로 페이지를 만들어준다. 
		Paging paging = new Paging(10);
		paging.setTotalArticleCount(allPlaceCount);
		// 1-2. page 가져올 때 계산 쉽게 하기 위해서 page number은 0부터 시작 
		paging.setPageNumber(placeSearchVO.getPageNO()+"");
		
		placeSearchVO.setStartIndex(paging.getStartArticleNumber());
		placeSearchVO.setEndIndex(paging.getEndArticleNumber());
		
		//전체 article 받아오기
		List<PlaceVO> places = placeDAO.getAllNewPlaces(placeSearchVO);
		
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
	 * @author 신고된 place list 받아오기
	 * @param placeSearchVO
	 * @return
	 */
	public PlaceListVO getReportedPlaceList(PlaceSearchVO placeSearchVO) {
		
		// 1. 전체 게시글의 수
		int allPlaceCount = placeDAO.getAllReportedPlaceCount();
		// 1-1. 기본으로 페이지를 만들어준다. 
		Paging paging = new Paging(10);
		paging.setTotalArticleCount(allPlaceCount);
		// 1-2. page 가져올 때 계산 쉽게 하기 위해서 page number은 0부터 시작 
		paging.setPageNumber(placeSearchVO.getPageNO()+"");
		
		placeSearchVO.setStartIndex(paging.getStartArticleNumber());
		placeSearchVO.setEndIndex(paging.getEndArticleNumber());
		
		//전체 article 받아오기
		List<PlaceVO> places = placeDAO.getAllReportedPlaces(placeSearchVO);
		
		// 2. DAO로부터 받아온 결과를 출력
		PlaceListVO originPlaceList = new PlaceListVO();
		originPlaceList.setPlaceList(places); 
		// 2-2. 페이지 추가 
		originPlaceList.setPaging(paging);
		
		return originPlaceList;		
	}

	/**
	 * @author 이기연 
	 * place 삭제
	 * @param placeId
	 */
	public void detelePlace(int placeId) {
		placeDAO.deletePlace(placeId);
	}


}