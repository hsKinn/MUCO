package com.ktds.muco.table.qna.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.qna.biz.QNABiz;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class MakeFAQServlet
 */
public class MakeFAQServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QNABiz qnaBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeFAQServlet() {
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
		
		qnaBiz.makeFAQ(qnaId);
		response.sendRedirect(Root.get(this) + "/qnaList");
	}

}
