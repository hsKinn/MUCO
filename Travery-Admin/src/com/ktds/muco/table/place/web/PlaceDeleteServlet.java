package com.ktds.muco.table.place.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.place.biz.PlaceBiz;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class PlaceDeleteServlet
 */
public class PlaceDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PlaceBiz placeBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceDeleteServlet() {
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
		int placeId = Integer.parseInt(request.getParameter("placeId"));

		placeBiz.detelePlace(placeId);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/place/placeList.jsp");
//		rd.forward(request, response);
		
		response.sendRedirect(Root.get(this) + "/placeList");
		
	}

}