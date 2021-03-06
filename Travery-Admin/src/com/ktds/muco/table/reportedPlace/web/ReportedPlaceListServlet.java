package com.ktds.muco.table.reportedPlace.web;

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
import com.ktds.muco.table.place.vo.PlaceSearchVO;
import com.ktds.muco.table.reportedPlace.biz.ReportedPlaceBiz;
import com.ktds.muco.table.reportedPlace.vo.RepoertedPlaceListVO;
import com.ktds.muco.table.reportedPlace.vo.ReportedPlaceSearchVO;

/**
 * Servlet implementation class ReportedPlaceListServlet
 */
public class ReportedPlaceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @author 이기연
	 * @see HttpServlet#HttpServlet()
	 */

	private HistoryBiz historyBiz;
	private ReportedPlaceBiz reportedPlaceBiz;

	public ReportedPlaceListServlet() {
		super();
		reportedPlaceBiz = new ReportedPlaceBiz();
		historyBiz = new HistoryBiz();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pageNO = 0;
		
		int sortOption;
		if (request.getParameter("sortOption") == null) {
			sortOption = 9;
		} else {
			sortOption = Integer.parseInt(request.getParameter("sortOption"));
		}
		
		RepoertedPlaceListVO reportedPlaceListVO;
		ReportedPlaceSearchVO reportedPlaceSearchVO = new ReportedPlaceSearchVO();
		HttpSession session = request.getSession();

		try {
			pageNO = Integer.parseInt(request.getParameter("pageNO"));

			// 검색 종류 및 키워드 가져오기
			reportedPlaceSearchVO.setSearchList(request.getParameter("searchList"));
			reportedPlaceSearchVO.setSearchKeyword(request.getParameter("searchKeyword"));

			// 정상적일 때만 pageNO을 설정하도록 한다.
			reportedPlaceSearchVO.setPageNO(pageNO);

		} catch (NumberFormatException nfe) {
			// 그런데 이 searchVO도 null인 경우가 있다.
			reportedPlaceSearchVO = (ReportedPlaceSearchVO) session.getAttribute("_REPORT_PLACE_SEARCH_");

			// 그러면 다시 0으로 맞춘다.
			if (reportedPlaceSearchVO == null) {
				reportedPlaceSearchVO = new ReportedPlaceSearchVO();
				reportedPlaceSearchVO.setPageNO(0);
				// 그리고 Keyword를 공백으로 맞춘다.
				reportedPlaceSearchVO.setSearchKeyword("");
			}
		}

		reportedPlaceListVO = reportedPlaceBiz.getReportedPlaceList(reportedPlaceSearchVO, sortOption);
		session.setAttribute("_REPORT_PLACE_SEARCH_", reportedPlaceSearchVO);


		request.setAttribute("reportedPlaces", reportedPlaceListVO);

		// History
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");

		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(member.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.REPORTED_PLACE);
		history.setHistoryDescription(BuildDescription.get(Description.REPORTED_PLACE, member.getEmail()));
		historyBiz.addHistory(history);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/place/reportedPlaceList.jsp");
		rd.forward(request, response);

	}

}