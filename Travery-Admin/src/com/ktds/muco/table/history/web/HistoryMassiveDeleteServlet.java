package com.ktds.muco.table.history.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.history.biz.HistoryBiz;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class HistoryMassiveDeleteServlet
 */
public class HistoryMassiveDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HistoryBiz historyBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryMassiveDeleteServlet() {
        super();
        historyBiz = new HistoryBiz();
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
		String[] deleteHisotryIds = request.getParameterValues("hisotryId");
		historyBiz.deleteHistories(deleteHisotryIds);
		response.sendRedirect(Root.get(this) + "/historyList");
		
	}

}
