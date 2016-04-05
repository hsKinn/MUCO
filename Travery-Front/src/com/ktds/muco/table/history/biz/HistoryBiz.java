package com.ktds.muco.table.history.biz;

import com.ktds.muco.table.history.dao.HistoryDAO;
import com.ktds.muco.table.history.vo.HistoryVO;

public class HistoryBiz {
	
	private HistoryDAO historyDAO;
	
	public HistoryBiz() {
		
		historyDAO = new HistoryDAO();
		
	}

	/**
	 * Add History
	 * 
	 * @param history
	 * @author 김광민
	 */
	public void addHistory(HistoryVO history) {
		historyDAO.addHistory(history);
	}
}
