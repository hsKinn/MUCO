package com.ktds.muco.table.reportedPlace.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.place.biz.PlaceBiz;
import com.ktds.muco.table.place.vo.PlaceListVO;
import com.ktds.muco.table.place.vo.PlaceSearchVO;

/**
 * Servlet implementation class ReportedPlaceListServlet
 */
public class ReportedPlaceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**@author 이기연
     * @see HttpServlet#HttpServlet()
     */
	
	PlaceBiz placeBiz;
	
    public ReportedPlaceListServlet() {
        super();
        placeBiz = new PlaceBiz();
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
		
		PlaceSearchVO placeSearchVO = new PlaceSearchVO();
		placeSearchVO.setPageNO(pageNO);
		
		PlaceListVO placeListVO = placeBiz.getReportedPlaceList(placeSearchVO);
		
		request.setAttribute("places", placeListVO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/place/placeList.jsp");
		rd.forward(request, response);
		
	}

}