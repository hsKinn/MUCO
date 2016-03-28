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
 * Servlet implementation class CountryCheckServlet
 */
public class CountryCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CountryBiz countryBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryCheckServlet() {
        super();
        countryBiz = new CountryBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 요청입니다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkCountry = request.getParameter("checkCountry");
		
		CountryVO countryVO = countryBiz.getCountryList(checkCountry);
		
		
		StringBuffer json = new StringBuffer();
		json.append("{");
		json.append("\"result\" : true");
		json.append(", \"countryName\" : \"" + countryVO.getCountryName()+"\"");
		json.append(", \"countryColor\" : \"" + countryVO.getCountryColor()+"\"");
		json.append(", \"countryFontColor\" : \"" + countryVO.getCountryFontColor()+"\"" );
		json.append("}");
		
		PrintWriter out = response.getWriter();
		out.print( json.toString() );
		out.flush();
		out.close();
	}

}
