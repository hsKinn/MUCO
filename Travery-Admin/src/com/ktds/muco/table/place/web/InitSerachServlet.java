package com.ktds.muco.table.place.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class InitSerachServlet
 */
public class InitSerachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitSerachServlet() {
        super();
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
		HttpSession session = request.getSession();
		//session 없애기
		session.removeAttribute("_NEW_PLACE_SEARCH_");
		session.removeAttribute("_ORIGIN_PLACE_SEARCH_");
		
		// 1 : new place 
		// 0 : origin place
		if ( placeType == 0 ) {
			response.sendRedirect(Root.get(this) + "/originPlaceList?sortOption=9");
		} else {
			response.sendRedirect(Root.get(this) + "/newPlaceList?sortOption=9");
		}
	}

}
