package com.ktds.muco.table.qna.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.qna.biz.QNABiz;
import com.ktds.muco.table.qna.vo.QNAListVO;

/**
 * Servlet implementation class TermsAccessServlet
 */
public class TermsAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QNABiz qnaBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TermsAccessServlet() {
		super();
		qnaBiz = new QNABiz();
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

		// QNAListVO faq = qnaBiz.getFAQList();

		request.setAttribute("menuNo", menuNo);
		// request.setAttribute("faq", faq);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/common/termsAccess.jsp");
		rd.forward(request, response);

	}

}
