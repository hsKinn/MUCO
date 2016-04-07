package com.ktds.muco.table.reportedPlace.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.reportedPlace.biz.ReportedPlaceBiz;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class ReportedPlaceMassiveDeleteServlet
 */
public class ReportedPlaceMassiveDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private ReportedPlaceBiz reportedPlaceBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportedPlaceMassiveDeleteServlet() {
        super();
        reportedPlaceBiz = new ReportedPlaceBiz();
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
		
		String[] deletereportedIds = request.getParameterValues("deleteReportedPlaceId");
		
		reportedPlaceBiz.deleteReports(deletereportedIds);
		
		response.sendRedirect(Root.get(this) + "/reportedPlaceList");
	}

}
