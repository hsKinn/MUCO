package com.ktds.muco.table.reportedPlace.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.reportedPlace.biz.ReportedPlaceBiz;
import com.ktds.muco.table.reportedPlace.vo.ReportedPlaceVO;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class DoReportServlet
 */
public class DoReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReportedPlaceBiz reportPlaceBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoReportServlet() {
        super();
        
        reportPlaceBiz = new ReportedPlaceBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");	
		
		int placeId = Integer.parseInt(request.getParameter("placeId"));
		String category = request.getParameter("category");
		String reportDescription = request.getParameter("reportDescription");
		
		ReportedPlaceVO reportPlace = new ReportedPlaceVO();
		reportPlace.setEmail(member.getEmail());
		reportPlace.setPlaceId(placeId);
		reportPlace.setCategory(category);
		reportPlace.setReportDescription(reportDescription);
		
		if ( reportPlaceBiz.setReportPlace ( reportPlace ) ) {
			response.sendRedirect(Root.get(this) + "/detailPlace?placeId=" + placeId);
		}
		else {
			response.sendRedirect(Root.get(this) + "/detailPlace?vote=fail&placeId=" + placeId);
		}
		
	}

}
