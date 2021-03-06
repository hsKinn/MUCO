package com.ktds.muco.table.reportedPlace.biz;

import java.util.List;

import com.ktds.muco.table.place.vo.PlaceListVO;
import com.ktds.muco.table.reportedPlace.dao.ReportedPlaceDAO;
import com.ktds.muco.table.reportedPlace.vo.RepoertedPlaceListVO;
import com.ktds.muco.table.reportedPlace.vo.ReportedPlaceSearchVO;
import com.ktds.muco.table.reportedPlace.vo.ReportedPlaceVO;
import com.ktds.muco.util.web.Paging;

/**
 * 
 * @author 김광민
 *
 */
public class ReportedPlaceBiz {

	private ReportedPlaceDAO reportedPlaceDAO;

	public ReportedPlaceBiz() {
		reportedPlaceDAO = new ReportedPlaceDAO();
	}

	public RepoertedPlaceListVO getReportedPlaceList(ReportedPlaceSearchVO reportedPlaceSearchVO, int sortOption) {
		// 1. 전체 게시글의 수
		int allPlaceCount = reportedPlaceDAO.getAllReportedPlaceCount(reportedPlaceSearchVO);
		// 1-1. 기본으로 페이지를 만들어준다. 
		Paging paging = new Paging(10);
		paging.setTotalArticleCount(allPlaceCount);
		// 1-2. page 가져올 때 계산 쉽게 하기 위해서 page number은 0부터 시작 
		paging.setPageNumber(reportedPlaceSearchVO.getPageNO()+"");
		
		reportedPlaceSearchVO.setStartIndex(paging.getStartArticleNumber());
		reportedPlaceSearchVO.setEndIndex(paging.getEndArticleNumber());
		
		//전체 article 받아오기
		List<ReportedPlaceVO> reportedPlaces = reportedPlaceDAO.getAllReportedPlaces(reportedPlaceSearchVO, sortOption);
		
		// 2. DAO로부터 받아온 결과를 출력
		RepoertedPlaceListVO reportedPlaceList = new RepoertedPlaceListVO();
		reportedPlaceList.setReportedPlaceList(reportedPlaces);
		// 2-2. 페이지 추가 
		reportedPlaceList.setPaging(paging);
		
		return reportedPlaceList;	
	}

	/**
	 * reportedPlace삭제
	 * @param deletePlaceIds
	 */
	public void deleteReports(String[] deletereportedIds) {
		for (String reportedId : deletereportedIds) {
			reportedPlaceDAO.deleteReport(Integer.parseInt(reportedId));
		}	
	}

}
