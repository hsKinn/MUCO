package com.ktds.muco.table.place.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.country.biz.CountryBiz;
import com.ktds.muco.table.country.vo.CountryVO;

/**
 * 
 * Servlet implementation class HitTheRoadServlet
 * 
 * @author 김광민
 * 
 */
public class HitTheRoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CountryBiz countryBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HitTheRoadServlet() {
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

		List<CountryVO> countryList = countryBiz.getCountryList();
		request.setAttribute("countryList", countryList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/place/hitTheRoad.jsp");
		rd.forward(request, response);
	}

}
