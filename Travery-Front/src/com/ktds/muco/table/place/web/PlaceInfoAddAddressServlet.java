package com.ktds.muco.table.place.web;

import java.io.IOException;
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
import com.ktds.muco.table.place.biz.PlaceBiz;
import com.ktds.muco.table.place.vo.PlaceVO;

/**
 * Servlet implementation class PlaceInfoAddAddressServlet
 */
public class PlaceInfoAddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlaceBiz placeBiz;
	private HistoryBiz historyBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlaceInfoAddAddressServlet() {
		super();
		placeBiz = new PlaceBiz();
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

		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("_MEMBER_");
		
		List<PlaceVO> countryList = placeBiz.getCountryList(memberVO);
		
		request.setAttribute("countryList", countryList);
		
		// History
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(memberVO.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.ADD_PLACE_MAP);
		history.setHistoryDescription(BuildDescription.get(Description.ADD_PLACE_MAP, memberVO.getEmail()));
		historyBiz.addHistory(history);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/place/placeInfoMap.jsp");
		rd.forward(request, response);
	}

}
