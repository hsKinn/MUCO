package com.ktds.muco.table.place.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.place.biz.PlaceBiz;
import com.ktds.muco.table.place.vo.PlaceListVO;
import com.ktds.muco.table.place.vo.PlaceSearchVO;

/**
 * 
 * Servlet implementation class PlaceInfoControlServlet
 * 
 * @author 김동규
 * 
 */
public class PlaceInfoControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlaceBiz placeBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlaceInfoControlServlet() {
		super();
		placeBiz = new PlaceBiz();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PlaceSearchVO placeSearchVO = new PlaceSearchVO();
		HttpSession session = request.getSession();

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
			}	// 받아오는 값이 null 값이 기 때문에 해당 구문을 작성하여 셋팅한다.
		}

		session.setAttribute("_SEARCH_", placeSearchVO);
						
		PlaceListVO placeListVO = placeBiz.placeInfoRecommendedList(placeSearchVO);
		
		request.setAttribute("placeInfo", placeListVO);
		request.setAttribute("placeSearchVO", placeSearchVO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/place/placeInfoControl.jsp");
		rd.forward(request, response);				
	}
}
