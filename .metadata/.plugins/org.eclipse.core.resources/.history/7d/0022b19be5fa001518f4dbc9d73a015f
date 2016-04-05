package com.ktds.muco.table.place.web;

import java.io.IOException;

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
import com.ktds.muco.table.place.biz.PlaceBiz;

/**
 * Servlet implementation class ViewCountRecommendPlaceServlet
 */
public class ViewCountRecommendPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlaceBiz placeBiz;
	private HistoryBiz historyBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCountRecommendPlaceServlet() {
        super();
        placeBiz = new PlaceBiz();
        historyBiz = new HistoryBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int placeId = Integer.parseInt(request.getParameter("placeId"));
		
		// History
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(member.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.ADD_PLACE_HIT);
		history.setHistoryDescription(BuildDescription.get(Description.ADD_PLACE_HIT, member.getEmail()));
		historyBiz.addHistory(history);
		
		placeBiz.viewCountRecommendPlace(placeId);
	}
}
