package com.ktds.muco.table.qna.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.history.biz.HistoryBiz;
import com.ktds.muco.table.history.vo.ActionCode;
import com.ktds.muco.table.history.vo.BuildDescription;
import com.ktds.muco.table.history.vo.Description;
import com.ktds.muco.table.history.vo.HistoryVO;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.pack.vo.PackSearchVO;
import com.ktds.muco.table.qna.biz.QNABiz;
import com.ktds.muco.table.qna.vo.QNAListVO;
import com.ktds.muco.table.qna.vo.QNASearchVO;

/**
 * Servlet implementation class QNAListServlet
 */
public class QNAListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HistoryBiz historyBiz;
	private QNABiz qnaBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAListServlet() {
        super();
        historyBiz = new HistoryBiz();
        qnaBiz = new QNABiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNO = 0;
		int sortOption;
		
		if (request.getParameter("sortOption") == null) {
			sortOption = 0;
		} else {
			sortOption = Integer.parseInt(request.getParameter("sortOption"));
		}
		
		QNAListVO qnaListVO; 
		QNASearchVO qnaSearchVO = new QNASearchVO();
		HttpSession session = request.getSession();
		
		try {
			// 데이터가 없다면 page는 null 그렇기 때문에 numberFormatException발생..? 그래서
			// catch에다가 search session을 이용한다라..?
			pageNO = Integer.parseInt(request.getParameter("pageNO"));

			// 검색 종류 및 키워드 가져오기
			qnaSearchVO.setSearchList(request.getParameter("searchList"));
			qnaSearchVO.setSearchKeyword(request.getParameter("searchKeyword"));

			// 정상적일 때만 pageNO을 설정하도록 한다.
			qnaSearchVO.setPageNO(pageNO);

		} catch (NumberFormatException nfe) {
			// 그런데 이 searchVO도 null인 경우가 있다.
			qnaSearchVO = (QNASearchVO) session.getAttribute("_QNA_SEARCH_");

			// 그러면 다시 0으로 맞춘다.
			if (qnaSearchVO == null) {
				qnaSearchVO = new QNASearchVO();
				qnaSearchVO.setPageNO(0);
				// 그리고 Keyword를 공백으로 맞춘다.
				qnaSearchVO.setSearchKeyword("");
			}
		}
		
		qnaListVO = qnaBiz.getQnaList(qnaSearchVO, sortOption);
		
		// search를 session에 넣는다. session 정보로 detail을 본다음 다시 목록보기로 돌아가기 위해서
		// session은 메모리가 허용하는 곳 까지 모두 저장할 수 있다.
		session.setAttribute("_PACK_SEARCH_", qnaSearchVO);
		
		request.setAttribute("QNAs", qnaListVO);
		
		// History
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(member.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.QNA_PAGE);
		history.setHistoryDescription(BuildDescription.get(Description.QNA_PAGE, member.getEmail()));
		historyBiz.addHistory(history);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/qna/qnaList.jsp");
		rd.forward(request, response);
		
	}

}
