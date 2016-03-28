package com.ktds.muco.table.country.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.country.biz.CountryBiz;
import com.ktds.muco.table.country.vo.CountryVO;

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
		// response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 요청입니다.");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 선택된 이름의 나라가 있는지 확인 후 있으면 해당 Country Info를 가져온다.
		CountryVO selectedCountryVO = countryBiz.getCountryInfoByCountryName(request);
		boolean isExistCountry = false;
		
		if( selectedCountryVO != null) {
			isExistCountry = true;
		}
		
		// JSON
		StringBuffer json = new StringBuffer();
		json.append("{");
		json.append("\"result\" : true");
		json.append(", \"isExistCountry\" : " + isExistCountry );
		json.append("}");

		// Print Writer
		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
		
		System.out.println(json.toString());
	}
}
