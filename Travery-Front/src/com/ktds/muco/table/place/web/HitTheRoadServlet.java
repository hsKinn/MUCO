package com.ktds.muco.table.place.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.country.vo.CountryVO;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.vo.PlaceVO;

/**
 * 
 * Servlet implementation class HitTheRoadServlet
 * 
 * @author 김광민
 * 
 */
public class HitTheRoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HitTheRoadServlet() {
		super();
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

		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("_MEMBER_");
		
		if(memberVO != null) {
			// 나라 리스트가 존재하면
			if( !memberVO.getSelectedCountryList().isEmpty() ) {
				List<CountryVO> selectedCountryList = memberVO.getSelectedCountryList();
				request.setAttribute("selectedCountryList", selectedCountryList);
				
				List<PlaceVO> selectedAllPlaceList = new ArrayList<PlaceVO>();
				for (CountryVO selectedCountryVO : selectedCountryList) {
					// 나라의 여행지 리스트가 존재하면
					if( !selectedCountryVO.getPlaceList().isEmpty() ) {
							for (PlaceVO placeVO : selectedCountryVO.getPlaceList()) {
								selectedAllPlaceList.add(placeVO);
							}
					}
				}
				request.setAttribute("selectedAllPlaceList", selectedAllPlaceList);
			}
			
			// 여행지 리스트가 존재하면
			if( !memberVO.getTempSelectedPlaceList().isEmpty() ) {
				List<PlaceVO> tempSelectedPlaceList = memberVO.getTempSelectedPlaceList();
				request.setAttribute("tempSelectedPlaceList", tempSelectedPlaceList);	
			}
			
		}
		
		String errorCode = request.getParameter("errorCode");
		if( errorCode != null ) {
			request.setAttribute("removeCountryName", errorCode);
		}
		
		if (request.getParameter("selectedPlaceId") != null ) {
			
			int errorCodeSecond = 0;
			
			try {
				errorCodeSecond = Integer.parseInt(request.getParameter("selectedPlaceId"));
			} catch (NumberFormatException nfe) {}
			
			if( errorCodeSecond != 0 ) {
				request.setAttribute("removePlaceId", errorCodeSecond);
			}
		}
		
		boolean isSuccessRemoveCountries = Boolean.parseBoolean(request.getParameter("isSuccessRemoveCountries"));
		if( isSuccessRemoveCountries ) {
			request.setAttribute("isSuccessRemoveCountries", isSuccessRemoveCountries);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/place/hitTheRoad.jsp");
		rd.forward(request, response);

	}
}








