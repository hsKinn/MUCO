package com.ktds.hskim.history.biz;

import com.ktds.hskim.history.dao.OperationHistoryDAO;
import com.ktds.hskim.history.vo.OperationHistoryVO;

public class OperationHistoryBiz {
	
	private OperationHistoryDAO dao= null;
	
	public OperationHistoryBiz() {
		dao = new OperationHistoryDAO();
	}
	
	public void addHistory( OperationHistoryVO historyVO ) {
		
		dao.insertHistory(historyVO);
	}
	
	
}


