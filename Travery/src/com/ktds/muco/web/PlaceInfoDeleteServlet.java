package com.ktds.muco.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.biz.RecommendPlaceBiz;
import com.ktds.muco.vo.MemberVO;
import com.ktds.muco.vo.PlaceVO;

/**
 * Servlet implementation class PlaceInfoDeleteServlet
 */
public class PlaceInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecommendPlaceBiz rpbiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceInfoDeleteServlet() {
        super();
        rpbiz =new RecommendPlaceBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int placeId = Integer.parseInt(request.getParameter("placeId"));
		
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");

		PlaceVO placeInfo = rpbiz.getDetail(placeId);
		
		
		rpbiz.getDelete(loginMember, placeInfo);
		response.sendRedirect("/recommendPlace");
	}

}
