package com.ktds.muco.table.member.web;

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
import com.ktds.muco.table.member.biz.MemberBiz;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz memberBiz;
	private HistoryBiz historyBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutServlet() {
		super();
		memberBiz = new MemberBiz();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberVO loginMemberVO = (MemberVO) session.getAttribute("_MEMBER_");
		request.setAttribute("name", loginMemberVO.getName());

		boolean isLogoutSuccess = memberBiz.logout(request);

		// History
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(loginMemberVO.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.LOGOUT);
		history.setHistoryDescription(BuildDescription.get(Description.LOGOUT, loginMemberVO.getEmail()));
		historyBiz.addHistory(history);

		if (isLogoutSuccess) {
			response.sendRedirect(Root.get(this) + "/");
		} else {
			response.sendRedirect(Root.get(this) + "/");
		}

	}

}