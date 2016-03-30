package com.ktds.muco.table.qna.biz;

import java.util.List;

import com.ktds.muco.table.qna.dao.QNADAO;
import com.ktds.muco.table.qna.vo.QNAVO;

/**
 * 
 * @author 김광민
 *
 */
public class QNABiz {
	
	private QNADAO qnaDAO;
	
	public QNABiz() {
		qnaDAO = new QNADAO();
	}

	public List<QNAVO> getFAQList() {
		List<QNAVO> faqList = qnaDAO.getFAQList();
		return faqList;
	}

}
