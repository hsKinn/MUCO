package com.ktds.muco.table.qna.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	/**
	 * @author 이기연
	 * @param qnaSearchVO
	 * @param sortOption
	 * @return
	 */
	public QNAListVO getQnaList(QNASearchVO qnaSearchVO, int sortOption) {
		// 1. 전체 게시글의 수
		int allPackCount = qnaDAO.getQnaListCount(qnaSearchVO);
		// 1-1. 기본으로 페이지를 만들어준다.
		Paging paging = new Paging(20);
		paging.setTotalArticleCount(allPackCount);
		// 1-2. page 가져올 때 계산 쉽게 하기 위해서 page number은 0부터 시작
		paging.setPageNumber(qnaSearchVO.getPageNO() + "");

		qnaSearchVO.setStartIndex(paging.getStartArticleNumber());
		qnaSearchVO.setEndIndex(paging.getEndArticleNumber());

		// 전체 article 받아오기
		List<QNAVO> qnas = qnaDAO.getAllQnas(qnaSearchVO, sortOption);

		// 2. DAO로부터 받아온 결과를 출력
		QNAListVO qnaList = new QNAListVO();
		qnaList.setQnaList(qnas);
		// 2-2. 페이지 추가
		qnaList.setPaging(paging);

		return qnaList;
	}

	/**
	 * @author 이기연
	 * qna detail 보여주는 list
	 * @param qnaId
	 * @return
	 */
	public QNAVO showQNADetail(String qnaId) {
		QNAVO qnaVO = qnaDAO.getQNADetailByQnaId(qnaId);
		System.out.println("1"+qnaVO.getQnaId());
		System.out.println("2"+qnaVO.getAnswerDescription());
		return qnaVO;
	}

	/**
	 * @author 이기연
	 * qna 리스트 대량 삭제
	 * @param deleteQnaIds
	 */
	public void deleteQNAs(String[] deleteQnaIds) {
		for (String qnaId : deleteQnaIds) {
			qnaDAO.deleteQna(qnaId);
		}
	}

	/**
	 * 답변 체크 해주기
	 * @param qnaId
	 */
	public void makeAnswer(String qnaId) {
		qnaDAO.makeAnswer(qnaId);
	}

	/**
	 * FAQ로 만들기
	 * @param qnaId
	 */
	public void makeFAQ(String qnaId) {
		qnaDAO.makeFAQ(qnaId);		
	}

	/**
	 * QNA 삭제하기
	 * @param qnaId
	 */
	public void deleteQna(String qnaId) {
		qnaDAO.deleteQna(qnaId);		
	}

	/**
	 * qna 수정하는 servlet
	 * @param qnaId
	 * @param qnaVO
	 * @param request
	 */
	public void doQnaEdit(String qnaId, QNAVO qnaVO, HttpServletRequest request) {
		// 어느 부분이 수정되었는지 확인해야한다. 
		String qnaAnswerSheet = request.getParameter("qnaAnswerSheet");
		try {
			//1. 여행지명 
			if( qnaVO.getAnswerDescription().equals(qnaAnswerSheet) ) {
				System.out.println("들어가져?");
			} else {
				qnaDAO.updateQnaAnswerSheet(qnaId, qnaAnswerSheet);
				System.out.println("들어가져?????");
			}
		} catch (NullPointerException ne) {
			qnaVO.setAnswerDescription("");
			//1. 여행지명 
			if( qnaVO.getAnswerDescription().equals(qnaAnswerSheet) ) {
				System.out.println("들어가져?");
			} else {
				qnaDAO.updateQnaAnswerSheet(qnaId, qnaAnswerSheet);
				System.out.println("들어가져?????");
			}
		}
		
	}

}
