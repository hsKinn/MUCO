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
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		PlaceListVO placeListVO = placeBiz.getUserRecommendList(member);
		
		request.setAttribute("placeList", placeListVO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/place/placeInfoControl.jsp");
		rd.forward(request, response);				
	}
}
