package com.ktds.muco.table.country.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.country.biz.CountryBiz;
import com.ktds.muco.util.root.Root;

/**
 * 
 * Servlet implementation class SelectCountryServlet
 * 
 * @author 김광민
 * 
 */
public class SelectedCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CountryBiz countryBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectedCountryServlet() {
		super();
		countryBiz = new CountryBiz();
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

		// 선택된 이름의 나라가 있는지 확인 후 있으면 해당 Country Info를 가져온다.
		boolean isSuccess = countryBiz.getCountryInfoByCountryName(request);
		
		if( isSuccess ) {
			// 해당 여행지가 DB에 있으면
			response.sendRedirect(Root.get(this) + "/hitTheRoad");
		}
		else {
			// 해당 여행지가 DB에 없거나 이미 선택 되어있다면
			// 나라명을 errorCode로 보낸다.
			String selectedCountryName = request.getParameter("selectedCountryName");
			response.sendRedirect(Root.get(this) + "/hitTheRoad?errorCode=" + selectedCountryName);
		}
	}
}











