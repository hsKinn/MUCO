package com.ktds.muco.table.pack.web;

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
import com.ktds.muco.table.pack.biz.PackBiz;
import com.ktds.muco.table.pack.vo.PackVO;
import com.ktds.muco.table.place.vo.PlaceVO;

public class ShowPackPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PackBiz packBiz;
	private HistoryBiz historyBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowPackPlaceServlet() {
		super();
		packBiz = new PackBiz();
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
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
		int packId = Integer.parseInt(request.getParameter("packId"));		
		
		String email=loginMember.getEmail();
		
		List<PackVO> packs = packBiz.getPackListByEmail(email);		
		List<PlaceVO> places = packBiz.getPlaceListByPackId(packId);
		

		// History
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(loginMember.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.SHOW_PACK);
		if ( packId != 0) {
			history.setHistoryDescription(BuildDescription.get(Description.SHOW_PACK, loginMember.getEmail(), packId+""));
		} else {
			history.setHistoryDescription(BuildDescription.get(Description.SHOW_PACK, loginMember.getEmail()));
		}
		historyBiz.addHistory(history);
		
		request.setAttribute("packs", packs);
		request.setAttribute("places", places);
		request.setAttribute("packId", packId);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/pack/showPackPlace.jsp");
		rd.forward(request, response);

	}

}
