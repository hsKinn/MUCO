package com.ktds.muco.table.qna.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.qna.biz.QNABiz;
import com.ktds.muco.table.qna.vo.QNAVO;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class QNADoEditServlet
 */
public class QNADoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private QNABiz qnaBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNADoEditServlet() {
        super();
        qnaBiz = new QNABiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 요청입니다");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qnaId = request.getParameter("qnaId");
		QNAVO qnaVO = qnaBiz.showQNADetail(qnaId);
		
		qnaBiz.doQnaEdit(qnaId, qnaVO, request);
		
		response.sendRedirect(Root.get(this) + "/qnaDetail?qnaId="+qnaId);
	
	}

}
