package com.ktds.cain.history.biz;

import com.ktds.cain.history.dao.OperationHistoryDAO;
import com.ktds.cain.history.vo.OperationHistoryVO;

public class OperationHistoryBiz {

	private OperationHistoryDAO dao;
	
	public OperationHistoryBiz() {
		dao = new OperationHistoryDAO();
	}
	
	public void addHistory(OperationHistoryVO historyVO) {
	
		dao.insertHistory(historyVO);
	} // 케이블 타이 역활을 하여 해당 배선을 dao쪽으로 빼는 역활
}
