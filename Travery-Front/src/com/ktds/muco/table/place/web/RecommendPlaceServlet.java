package com.ktds.muco.table.place.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.place.vo.PlaceListVO;

/**
 * 
 * Servlet implementation class RecommendPlaceServlet
 * 
 * @author 김광민
 * 
 */
public class RecommendPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
<<<<<<< HEAD
	 */
	public RecommendPlaceServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
=======
	 */
	public RecommendPlaceServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
>>>>>>> origin/롯드4
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
<<<<<<< HEAD
=======
		
		
/*				HttpSession session = request.getSession();

		try {
			placeSearchVO.setSearchKeyword( request.getParameter("searchKeyword") );
			placeSearchVO.setSearchType(request.getParameter("searchType"));
		}
		catch(NumberFormatException nfe) {
			
			placeSearchVO = (PlaceSearchVO)session.getAttribute("_SEARCH_");
			
			if ( placeSearchVO == null) {
				placeSearchVO = new PlaceSearchVO();
				placeSearchVO.setSearchKeyword("");
				placeSearchVO.setSearchType("1");
			}
		}

		session.setAttribute("_SEARCH_", placeSearchVO);

						
		PlaceListVO placeListVO = placeBiz.placeInfoRecommendedList(placeSearchVO);	
		request.setAttribute("placeInfo", placeListVO);
		request.setAttribute("placeSearchVO", placeSearchVO);
		*/
		
		
		
		
		
		
>>>>>>> origin/롯드4
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/place/recommendPlace.jsp");
		rd.forward(request, response);
	}

}
