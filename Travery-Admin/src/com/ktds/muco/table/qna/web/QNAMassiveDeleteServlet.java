package com.ktds.muco.table.qna.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.qna.biz.QNABiz;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class QNAMassiveDeleteServlet
 */
public class QNAMassiveDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private QNABiz qnaBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAMassiveDeleteServlet() {
        super();
        qnaBiz = new QNABiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘 못 된 요청입니다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] deleteQnaIds = request.getParameterValues("deleteQnaId");
		qnaBiz.deleteQNAs(deleteQnaIds);
		
		response.sendRedirect(Root.get(this) + "/qnaList");
	}

}
