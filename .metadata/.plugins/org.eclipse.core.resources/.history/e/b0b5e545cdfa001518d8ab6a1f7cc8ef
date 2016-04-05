package com.ktds.muco.table.place.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.biz.PlaceBiz;
import com.ktds.muco.table.place.vo.PlaceListVO;
import com.ktds.muco.table.place.vo.PlaceSearchVO;
import com.ktds.muco.table.place.vo.RecommendPlaceListVO;

/**
 * 
 * Servlet implementation class RecommendPlaceServlet
 * 
 * @author 김광민
 * 
 */
public class RecommendPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PlaceBiz placeBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecommendPlaceServlet() {
		super();
		
		placeBiz = new PlaceBiz();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
		
		int sortOption = 1;
		int pageNo = 0;

		try {
			sortOption = Integer.parseInt(request.getParameter("sortOption"));
		}
		catch (NumberFormatException nfe) {
		}

		PlaceSearchVO placeSearchVO = new PlaceSearchVO();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			placeSearchVO.setPageNo(pageNo);
			placeSearchVO.setSearchKeyword(request.getParameter("searchPlaceKeyword"));

		}
		catch(NumberFormatException nfe) {
			
			placeSearchVO = (PlaceSearchVO) session.getAttribute("_PLACE_SEARCH_");
			
			if ( placeSearchVO == null ) {
				placeSearchVO = new PlaceSearchVO();
				placeSearchVO.setPageNo(0);
				placeSearchVO.setSearchKeyword("");
				placeSearchVO.setSearchType("1");
			}			
		}
		
		session.setAttribute("_PLACE_SEARCH_", placeSearchVO);
		
		PlaceListVO placeListVO = placeBiz.getAllRecommendPlaceList(placeSearchVO, member, sortOption);
		
		
		request.setAttribute("placeList", placeListVO);
		request.setAttribute("placeSearch", placeSearchVO);
		
		// Recommend Place 상단 부분
		RecommendPlaceListVO recommendPlaceList = placeBiz.getTopRecommendPlace(member);
		request.setAttribute("recommendPlaceList", recommendPlaceList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/place/recommendPlace.jsp");
		rd.forward(request, response);
	}

}
