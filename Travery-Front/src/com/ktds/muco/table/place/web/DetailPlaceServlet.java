package com.ktds.muco.table.place.web;

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
import com.ktds.muco.table.place.vo.PlaceVO;

/**
 * Servlet implementation class DetailPlaceServlet
 */
public class DetailPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PlaceBiz placeBiz;
	private HistoryBiz historyBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailPlaceServlet() {
        super();
        
        placeBiz = new PlaceBiz();
        historyBiz = new HistoryBiz();
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

		int placeId = Integer.parseInt(request.getParameter("placeId"));
		
		// 여행지 상세정보 가져오기
		// PLACE_ID, PLACE_NAME, LATITUDE, LONGTITUDE, ADDRESS, VIEW_COUNT, LIKE_COUNT
		// DESCRIPTION, EMAIL, NAME, COUNTRY_NAME, imageList(사진 목록), replyList(리플 목록)
		PlaceVO seletedPlace = placeBiz.getDetailPlaceInfo( placeId );
		
		request.setAttribute( "place", seletedPlace );
		request.setAttribute( "writer", seletedPlace.getWriter() );
		
		// History
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(member.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.PLACE_DETAIL);
		history.setHistoryDescription(BuildDescription.get(Description.PLACE_DETAIL, member.getEmail(), placeId+""));
		historyBiz.addHistory(history);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/place/detailPlace.jsp");
		rd.forward(request, response);
	}

}
