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
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class TempSelectedPlaceServlet
 */
public class TempSelectedPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PlaceBiz placeBiz;
	private HistoryBiz historyBiz;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TempSelectedPlaceServlet() {
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
		
		// 선택된 여행지가 있는지 확인 후 있으면 해당 Place Info를 가져온다.
		
		String selectedPlaceId2 = request.getParameter("selectedPlaceId");
		String[] splitId = selectedPlaceId2.split("s");
		int selectedPlaceId = 0;
		selectedPlaceId = Integer.parseInt(splitId[1]);
		
		boolean isSuccess =  placeBiz.addTempSelectedPlaceByPlaceId(request);
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		if( isSuccess ) {
			
			// History
			HistoryVO history = new HistoryVO();
			history.setIp(request.getRemoteHost());
			history.setEmail(member.getEmail());
			history.setUrl(request.getRequestURI());
			history.setActionCode(ActionCode.SELECTED_PLACE);
			history.setHistoryDescription(BuildDescription.get(Description.SELECTED_PLACE, member.getEmail(), selectedPlaceId + ""));
			historyBiz.addHistory(history);
			
			// 해당 여행지가 DB에 있으면
			response.sendRedirect(Root.get(this) + "/hitTheRoad?placeId=" + selectedPlaceId);
		}
		else {
			// 해당 여행지가 DB에 없거나 이미 선택 되어있다면
			// 여행지ID를 errorCode로 보낸다.
			System.out.println("selectedPlaceId2 : " + splitId[1]);
			
			try {
				selectedPlaceId = Integer.parseInt(splitId[1]);
			} catch (NumberFormatException nfe) {	}
			
			// History
			HistoryVO history = new HistoryVO();
			history.setIp(request.getRemoteHost());
			history.setEmail(member.getEmail());
			history.setUrl(request.getRequestURI());
			history.setActionCode(ActionCode.SELECTED_PLACE);
			history.setHistoryDescription(BuildDescription.get(Description.SELECTED_PLACE_FAIL, member.getEmail(), selectedPlaceId + ""));
			historyBiz.addHistory(history);
			
			response.sendRedirect(Root.get(this) + "/hitTheRoad?errorCodeSecond=" + selectedPlaceId);
		}
		
	}

}
