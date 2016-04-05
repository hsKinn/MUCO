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
import com.ktds.muco.table.place.biz.PlaceBiz;
import com.ktds.muco.table.place.vo.PlaceListVO;
import com.ktds.muco.table.place.vo.PlaceSearchVO;

/**
 * Servlet implementation class ReportedPlaceListServlet
 */
public class ReportedPlaceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**@author 이기연
     * @see HttpServlet#HttpServlet()
     */
	
	private HistoryBiz historyBiz;
	private PlaceBiz placeBiz;
	
    public ReportedPlaceListServlet() {
        super();
        placeBiz = new PlaceBiz();
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
		
		try {
			pageNO = Integer.parseInt(request.getParameter("pageNO"));
		} catch (NumberFormatException nfe) {
		}
		
		PlaceSearchVO placeSearchVO = new PlaceSearchVO();
		placeSearchVO.setPageNO(pageNO);
		
		PlaceListVO placeListVO = placeBiz.getReportedPlaceList(placeSearchVO);
		
		request.setAttribute("places", placeListVO);
		
		// History
		HttpSession session = request.getSession();
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
