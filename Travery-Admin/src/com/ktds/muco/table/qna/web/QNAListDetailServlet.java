package com.ktds.muco.table.qna.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.qna.biz.QNABiz;
import com.ktds.muco.table.qna.vo.QNAVO;

/**
 * Servlet implementation class MemberDetailServlet
 */
public class QNAListDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private QNABiz qnaBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAListDetailServlet() {
        super();
        qnaBiz = new QNABiz();
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
		String qnaId = request.getParameter("qnaId");
		
		QNAVO qnaVO = qnaBiz.showQNADetail(qnaId);

		request.setAttribute("QNA", qnaVO);
		
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/qna/qnaListDetail.jsp");
	    rd.forward(request, response);
	}

}
