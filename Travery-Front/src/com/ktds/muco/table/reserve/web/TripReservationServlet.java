package com.ktds.muco.table.reserve.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.ktds.muco.table.pack.biz.PackBiz;
import com.ktds.muco.table.pack.vo.PackVO;

/**
 * 
 * Servlet implementation class TripReservationServlet
 * 
 * @author 김광민
 * 
 */
public class TripReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HistoryBiz historyBiz;
	private PackBiz packBiz;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TripReservationServlet() {
		super();
		historyBiz = new HistoryBiz();
		packBiz = new PackBiz();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// History
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		// 유저가 가진 패키지들 뿌려주기
		List<PackVO> loginUserPackList = new ArrayList<PackVO>(); 
		
		if(member != null){
			loginUserPackList = packBiz.getPackListByEmail(member.getEmail());
			if(loginUserPackList != null){
				request.setAttribute("loginUserPackList", loginUserPackList);	
			}
		}
		
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(member.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.TRIP_RESERVATION);
		history.setHistoryDescription(BuildDescription.get(Description.TRIP_RESERVATION, member.getEmail()));
		historyBiz.addHistory(history);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/reserve/tripReservation.jsp");
		rd.forward(request, response);
	}

}
