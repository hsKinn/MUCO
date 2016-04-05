package com.ktds.muco.table.country.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.country.biz.CountryBiz;
import com.ktds.muco.table.history.biz.HistoryBiz;
import com.ktds.muco.table.history.vo.ActionCode;
import com.ktds.muco.table.history.vo.BuildDescription;
import com.ktds.muco.table.history.vo.Description;
import com.ktds.muco.table.history.vo.HistoryVO;
import com.ktds.muco.table.member.vo.MemberVO;
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
	private HistoryBiz historyBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectedCountryServlet() {
		super();
		countryBiz = new CountryBiz();
		historyBiz = new HistoryBiz();
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
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		String selectedCountryName = request.getParameter("selectedCountryName");
		
		if( isSuccess ) {
			// History
			HistoryVO history = new HistoryVO();
			history.setIp(request.getRemoteHost());
			history.setEmail(member.getEmail());
			history.setUrl(request.getRequestURI());
			history.setActionCode(ActionCode.SELECT_COUNTRY);
			history.setHistoryDescription(BuildDescription.get(Description.SELECT_COUNTRY, member.getEmail(), selectedCountryName));
			historyBiz.addHistory(history);
			
			response.sendRedirect(Root.get(this) + "/hitTheRoad");
		}
		else {
			// History
			HistoryVO history = new HistoryVO();
			history.setIp(request.getRemoteHost());
			history.setEmail(member.getEmail());
			history.setUrl(request.getRequestURI());
			history.setActionCode(ActionCode.SELECT_COUNTRY);
			history.setHistoryDescription(BuildDescription.get(Description.SELECT_COUNTRY_FAIL, member.getEmail(), selectedCountryName));
			historyBiz.addHistory(history);
			
			response.sendRedirect(Root.get(this) + "/hitTheRoad");
		}
	}
}











