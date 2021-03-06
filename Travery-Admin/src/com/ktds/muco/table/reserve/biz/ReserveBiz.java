package com.ktds.muco.table.reserve.biz;

import java.util.List;

import com.ktds.muco.table.reserve.dao.ReserveDAO;
import com.ktds.muco.table.reserve.vo.ReserveListVO;
import com.ktds.muco.table.reserve.vo.ReserveSearchVO;
import com.ktds.muco.table.reserve.vo.ReserveVO;
import com.ktds.muco.util.web.Paging;

/**
 * 
 * @author 김광민
 *
 */
public class ReserveBiz {

	private ReserveDAO reserveDAO;

	public ReserveBiz() {
		reserveDAO = new ReserveDAO();
	}
	
	public ReserveListVO getReserveList(ReserveSearchVO reserveSearchVO, int sortOption) {
		
		// 1. 전체 게시글의 수
		int allReserveCount = reserveDAO.getAllReserveListCount(reserveSearchVO);
		// 1-1. 기본으로 페이지를 만들어준다. 
		Paging paging = new Paging(10);
		paging.setTotalArticleCount(allReserveCount);
		// 1-2. page 가져올 때 계산 쉽게 하기 위해서 page number은 0부터 시작 
		paging.setPageNumber(reserveSearchVO.getPageNO()+"");
		
		reserveSearchVO.setStartIndex(paging.getStartArticleNumber());
		reserveSearchVO.setEndIndex(paging.getEndArticleNumber());
		
		//전체 article 받아오기
		List<ReserveVO> reserves = reserveDAO.getAllReservation(reserveSearchVO, sortOption);
		
		// 2. DAO로부터 받아온 결과를 출력
		ReserveListVO reserveList = new ReserveListVO();
		reserveList.setReserveList(reserves); 
		// 2-2. 페이지 추가 
		reserveList.setPaging(paging);
		
		return reserveList;		
	}

}
