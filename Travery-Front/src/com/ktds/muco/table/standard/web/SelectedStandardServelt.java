package com.ktds.muco.table.standard.web;

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
 * Servlet implementation class SelectedStandardServelt
 */
public class SelectedStandardServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz memberBiz;
	private HistoryBiz historyBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectedStandardServelt() {
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

		boolean isChangedStandard = memberBiz.selectedStandard(request);

		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		String selectedStandard = request.getParameter("selectedStandard");
		String selectedStandardName = request.getParameter("selectedStandardName");
		
		if(isChangedStandard) {
			
			// History
			HistoryVO history = new HistoryVO();
			history.setIp(request.getRemoteHost());
			history.setEmail(member.getEmail());
			history.setUrl(request.getRequestURI());
			history.setActionCode(ActionCode.SELECTED_STANDARD);
			history.setHistoryDescription(BuildDescription.get(Description.SELECTED_STANDARD, member.getEmail(), selectedStandard, selectedStandardName));
			historyBiz.addHistory(history);
			response.sendRedirect(Root.get(this) + "/hitTheRoad");
		}
		else {
			
			// History
			HistoryVO history = new HistoryVO();
			history.setIp(request.getRemoteHost());
			history.setEmail(member.getEmail());
			history.setUrl(request.getRequestURI());
			history.setActionCode(ActionCode.SELECTED_STANDARD);
			history.setHistoryDescription(BuildDescription.get(Description.SELECTED_STANDARD_FAIL, member.getEmail(), selectedStandard, selectedStandardName));
			historyBiz.addHistory(history);
			response.sendRedirect(Root.get(this) + "/hitTheRoad");
			
			response.sendRedirect(Root.get(this) + "/hitTheRoad");
		}
	}

}
