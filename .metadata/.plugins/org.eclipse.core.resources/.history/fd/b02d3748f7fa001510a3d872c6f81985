package com.ktds.muco.table.place.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.place.biz.PlaceBiz;

/**
 * Servlet implementation class ViewCountRecommendPlaceServlet
 */
public class ViewCountRecommendPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlaceBiz placeBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCountRecommendPlaceServlet() {
        super();
        placeBiz = new PlaceBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int placeId = Integer.parseInt(request.getParameter("placeId"));
		
		placeBiz.viewCountRecommendPlace(placeId);
	}
}
