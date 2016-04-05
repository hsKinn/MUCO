package com.ktds.muco.table.placeLike.web;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.ktds.muco.table.placeLike.biz.PlaceLikeBiz;
import com.ktds.muco.table.placeLike.vo.PlaceLikeVO;

/**
 * Servlet implementation class PlaceLikeServlet
 */
public class PlaceLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlaceLikeBiz placeLikeBiz;
	private HistoryBiz historyBiz;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlaceLikeServlet() {
		super();
		placeLikeBiz = new PlaceLikeBiz();
		historyBiz = new HistoryBiz();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int placeId = Integer.parseInt(request.getParameter("placeId"));
		
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("_MEMBER_");

		PlaceLikeVO placeLikeVO = new PlaceLikeVO();
		placeLikeVO.setPlaceId(placeId);
		placeLikeVO.setWriter(memberVO);
		
		placeLikeBiz.insertOrDeletePlaceLike(placeLikeVO);
		boolean isExistPlaceLike = placeLikeBiz.isExistPlaceLike(placeLikeVO);

		// History
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(memberVO.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.ADD_PLACE_LIKE);
		history.setHistoryDescription(BuildDescription.get(Description.ADD_PLACE_LIKE, memberVO.getEmail(), placeId+""));
		historyBiz.addHistory(history);
		
		StringBuffer json = new StringBuffer();

		json.append("{");
		json.append("\"result\" : true");
		json.append(", \"isplaceLike\" : " + isExistPlaceLike);
		json.append("}");

		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
	}
}
