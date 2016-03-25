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
 * Servlet implementation class SelectedCountryServlet
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
		
		// DB에 있는지 확인한 뒤 있으면 해당 나라 VO 리스트를 받아온다.
		boolean isExistCountry = countryBiz.getCountryByCountryName(request);

		if (isExistCountry) {
			System.out.println("성공 in servlet ");
		} else {
			System.out.println("실패 int servlet ");
		}
		response.sendRedirect(Root.get(this) + "/hitTheRoad");

	}

}