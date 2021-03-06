package com.ktds.muco.table.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.history.biz.HistoryBiz;
import com.ktds.muco.table.history.vo.ActionCode;
import com.ktds.muco.table.history.vo.BuildDescription;
import com.ktds.muco.table.history.vo.Description;
import com.ktds.muco.table.history.vo.HistoryVO;
import com.ktds.muco.table.member.biz.MemberBiz;

/**
 * 
 * Servlet implementation class DoJoinServlet
 * 
 * @author 유병훈
 * 
 */
public class DoJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberBiz memberBiz;
	private HistoryBiz historyBiz;

	public DoJoinServlet() {
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
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "회원가입 할 수 없습니다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("userEmail");
		
		// History
		if (memberBiz.addNewMember(request) ) {
			HistoryVO history = new HistoryVO();
			history.setIp(request.getRemoteHost());
			history.setEmail(email);
			history.setUrl(request.getRequestURI());
			history.setActionCode(ActionCode.JOIN);
			history.setHistoryDescription(BuildDescription.get(Description.JOIN, email));
			historyBiz.addHistory(history);
		}
		else {
			HistoryVO history = new HistoryVO();
			history.setIp(request.getRemoteHost());
			history.setEmail(email);
			history.setUrl(request.getRequestURI());
			history.setActionCode(ActionCode.JOIN);
			history.setHistoryDescription(BuildDescription.get(Description.JOIN_FAIL, email));
			historyBiz.addHistory(history);
		}
		
		response.sendRedirect("/");
	}
}
