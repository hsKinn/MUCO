package com.ktds.muco.table.history.biz;

import java.util.List;

import com.ktds.muco.table.history.dao.HistoryDAO;
import com.ktds.muco.table.history.vo.HistoryListVO;
import com.ktds.muco.table.history.vo.HistorySearchVO;
import com.ktds.muco.table.history.vo.HistoryVO;
import com.ktds.muco.util.web.Paging;

/**
 * 
 * @author 김광민
 *
 */
public class HistoryBiz {

	private HistoryDAO historyDAO;
	
	public HistoryBiz() {
		historyDAO = new HistoryDAO();
	}
	
	public HistoryListVO getHistoryList(HistorySearchVO historySearchVO) {
		// 1. 전체 게시글의 수
		int allHistoryCount = historyDAO.getAllHistoryCount();
		// 1-1. 기본으로 페이지를 만들어준다. 
		Paging paging = new Paging(25);
		paging.setTotalArticleCount(allHistoryCount);
		// 1-2. page 가져올 때 계산 쉽게 하기 위해서 page number은 0부터 시작 
		paging.setPageNumber(historySearchVO.getPageNO()+"");
		
		historySearchVO.setStartIndex(paging.getStartArticleNumber());
		historySearchVO.setEndIndex(paging.getEndArticleNumber());
		
		//전체 article 받아오기
		List<HistoryVO> historys = historyDAO.getAllHistoryList(historySearchVO);
		
		// 2. DAO로부터 받아온 결과를 출력
		HistoryListVO historyList = new HistoryListVO();
		historyList.setHistoryList(historys); 
		// 2-2. 페이지 추가 
		historyList.setPaging(paging);
		
		return historyList;		
	}

	/**
	 * 30일 지난 history 목록 가져오기
	 * @param historySearchVO
	 * @return
	 */
	public HistoryListVO getOverDatedHistoryList(HistorySearchVO historySearchVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
