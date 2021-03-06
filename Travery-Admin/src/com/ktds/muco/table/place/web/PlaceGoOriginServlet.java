package com.ktds.muco.table.place.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.place.biz.PlaceBiz;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class PlaceGoOriginServlet
 */
public class PlaceGoOriginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PlaceBiz placeBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceGoOriginServlet() {
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
		int placeType = Integer.parseInt(request.getParameter("placeType"));
		int placeId = Integer.parseInt(request.getParameter("placeId"));

		placeBiz.goOriginPlaceByPlaceId(placeId);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/place/placeList.jsp");
//		rd.forward(request, response);
		
		// 1 : new place 
		// 0 : origin place
		response.sendRedirect(Root.get(this) + "/placeList");
	}

}
