package com.ktds.muco.table.member.web;

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
import com.ktds.muco.table.member.biz.MemberBiz;
import com.ktds.muco.table.member.vo.MemberListVO;
import com.ktds.muco.table.member.vo.MemberSearchVO;
import com.ktds.muco.table.member.vo.MemberVO;

/**
 * Servlet implementation class ReportedMemberListServlet
 */
public class ReportedMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberBiz memberBiz;
	private HistoryBiz historyBiz;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportedMemberListServlet() {
        super();
        memberBiz = new MemberBiz();
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
		
		MemberSearchVO memberSearchVO = new MemberSearchVO();
		memberSearchVO.setPageNO(pageNO);
		
		MemberListVO memberListVO = memberBiz.getReportedMemberList(memberSearchVO);
		
		request.setAttribute("members", memberListVO);
		
		// History
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(member.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.REPORTED_MEMBER);
		history.setHistoryDescription(BuildDescription.get(Description.REPORTED_MEMBER, member.getEmail()));
		historyBiz.addHistory(history);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/memberList.jsp");
		rd.forward(request, response);
	}

}
