package com.ktds.muco.table.place.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.biz.PlaceBiz;
import com.ktds.muco.table.place.vo.PlaceVO;

/**
 * Servlet implementation class PlaceInfoAddAddressServlet
 */
public class PlaceInfoAddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlaceBiz placeBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlaceInfoAddAddressServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("_MEMBER_");
		
		List<PlaceVO> countryList = placeBiz.getCountryList(memberVO);
		
		request.setAttribute("countryList", countryList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/place/placeInfoMap.jsp");
		rd.forward(request, response);
	}

}
