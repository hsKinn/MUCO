package com.ktds.muco.table.qna.biz;

import java.util.List;

import com.ktds.muco.table.qna.dao.QNADAO;
import com.ktds.muco.table.qna.vo.QNAListVO;
import com.ktds.muco.table.qna.vo.QNASearchVO;
import com.ktds.muco.table.qna.vo.QNAVO;
import com.ktds.muco.util.web.Paging;

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

	public QNAListVO getFAQList(QNASearchVO searchVO) {
		int articleCount = 0;
		
		
		Paging paging = new Paging();
		paging.setTotalArticleCount(articleCount);
		paging.setPageNumber(searchVO.getPageNo() + "");
		
		searchVO.setStartIndex(paging.getStartArticleNumber());
		searchVO.setEndIndex(paging.getEndArticleNumber());
		
		List<QNAVO> faqs = qnaDAO.getFAQList(searchVO);
		
		QNAListVO faqList = new QNAListVO();
		faqList.setQnaList(faqs);
		faqList.setPaging(paging);
		
		return faqList;
		
	}

}
