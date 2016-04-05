package com.ktds.muco.table.qna.web;

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
import com.ktds.muco.table.qna.biz.QNABiz;
import com.ktds.muco.table.qna.vo.QNAVO;

/**
 * Servlet implementation class TermsAccessServlet
 */
public class TermsAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QNABiz qnaBiz;
	private HistoryBiz historyBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TermsAccessServlet() {
		super();
		qnaBiz = new QNABiz();
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

		int menuNo = Integer.parseInt(request.getParameter("menuNo"));

		List<QNAVO> faqs = qnaBiz.getFAQList();

		request.setAttribute("menuNo", menuNo);
		request.setAttribute("faqs", faqs);

		// History
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(member.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.QNA);
		history.setHistoryDescription(BuildDescription.get(Description.QNA, member.getEmail()));
		historyBiz.addHistory(history);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/common/termsAccess.jsp");
		rd.forward(request, response);

	}

}
