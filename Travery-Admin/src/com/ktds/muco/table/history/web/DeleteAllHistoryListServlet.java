package com.ktds.muco.table.history.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.history.biz.HistoryBiz;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class DeleteAllHistoryListServlet
 */
public class DeleteAllHistoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HistoryBiz historyBiz;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAllHistoryListServlet() {
        super();
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
		historyBiz.deleteAllHistories();
		response.sendRedirect(Root.get(this) + "/historyList");
	}

}
