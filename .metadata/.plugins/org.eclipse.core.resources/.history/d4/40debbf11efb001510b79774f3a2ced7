package com.ktds.muco.table.history.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.history.biz.HistoryBiz;
import com.ktds.muco.table.history.vo.HistoryListVO;
import com.ktds.muco.table.history.vo.HistorySearchVO;

/**
 * Servlet implementation class MemberListServlet
 */
public class HistoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HistoryBiz historyBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryListServlet() {
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
		int pageNO = 0;
		
		try {
			pageNO = Integer.parseInt(request.getParameter("pageNO"));
		} catch (NumberFormatException nfe) {
		}
		
		HistorySearchVO historySearchVO = new HistorySearchVO();
		historySearchVO.setPageNO(pageNO);
		
		HistoryListVO hisotryListVO = historyBiz.getHistoryList(historySearchVO);
		
		request.setAttribute("hisotryies", hisotryListVO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/history/historyList.jsp");
		rd.forward(request, response);
	}

}
