package com.ktds.muco.table.country.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.member.biz.MemberBiz;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class RemoveAllSelectedCountriesServlet
 * @author 김광민
 */
public class RemoveAllSelectedCountriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz memberBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveAllSelectedCountriesServlet() {
        super();
        memberBiz = new MemberBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isSuccess = memberBiz.removeAllSelectedCountries(request);
		
		if(isSuccess){
			response.sendRedirect(Root.get(this) + "/hitTheRoad?isSuccessRemoveCountries=true");
		}
		else {
			response.sendRedirect(Root.get(this) + "/hitTheRoad?isSuccessRemoveCountries=false");
		}
	}

}
