package com.ktds.muco.table.history.web;

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
import com.ktds.muco.table.history.vo.HistoryListVO;
import com.ktds.muco.table.history.vo.HistorySearchVO;
import com.ktds.muco.table.history.vo.HistoryVO;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.vo.PlaceSearchVO;

/**
 * Servlet implementation class MemberListServlet
 */
public class HistoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HistoryBiz historyBiz;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryListServlet() {
        super();
        historyBiz = new HistoryBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNO = 0;
		
		int sortOption;
		if (request.getParameter("sortOption") == null) {
			sortOption = 9;
		} else {
			sortOption = Integer.parseInt(request.getParameter("sortOption"));
		}
		
		HistoryListVO historyListVO;
		HistorySearchVO historySearchVO = new HistorySearchVO();
		HttpSession session = request.getSession();
		
		try {
			// 데이터가 없다면 page는 null 그렇기 때문에 numberFormatException발생..? 그래서
			// catch에다가 search session을 이용한다라..?
			pageNO = Integer.parseInt(request.getParameter("pageNO"));

			// 검색 종류 및 키워드 가져오기
			historySearchVO.setSearchList(request.getParameter("searchList"));
			historySearchVO.setSearchKeyword(request.getParameter("searchKeyword"));

			// 정상적일 때만 pageNO을 설정하도록 한다.
			historySearchVO.setPageNO(pageNO);

		} catch (NumberFormatException nfe) {
			// 그런데 이 searchVO도 null인 경우가 있다.
			historySearchVO = (HistorySearchVO) session.getAttribute("_HISOTRY_SEARCH_");

			// 그러면 다시 0으로 맞춘다.
			if (historySearchVO == null) {
				historySearchVO = new HistorySearchVO();
				historySearchVO.setPageNO(0);
				// 그리고 Keyword를 공백으로 맞춘다.
				historySearchVO.setSearchKeyword("");
			}
		}
		historyListVO = historyBiz.getHistoryList(historySearchVO, sortOption);
		
		session.setAttribute("_HISOTRY_SEARCH_", historySearchVO);
		request.setAttribute("hisotryies", historyListVO);
		
		// History 기록
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(member.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.HISTORY_PAGE);
		history.setHistoryDescription(BuildDescription.get(Description.HISTORY_PAGE, member.getEmail()));
		historyBiz.addHistory(history);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/history/historyList.jsp");
		rd.forward(request, response);
	}

}
