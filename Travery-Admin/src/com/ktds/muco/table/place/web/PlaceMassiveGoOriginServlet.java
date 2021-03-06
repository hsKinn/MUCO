package com.ktds.muco.table.place.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.place.biz.PlaceBiz;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class PlaceMassiveGoOriginServlet
 */
public class PlaceMassiveGoOriginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PlaceBiz placeBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceMassiveGoOriginServlet() {
    	placeBiz = new PlaceBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘 못 된 요청입니다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// html에서 radio check 박스에 선택 된 것만 넘어온다. 컬렉션들로 구성된 것들은 모두 배열로 들어온다. 하나만 선택되더라도
		int placeType = Integer.parseInt(request.getParameter("placeType"));
		String[] deletePlaceIds = request.getParameterValues("deletePlaceId");
		
//		자기가 쓴 글만 삭제하도록 하기 위한 session check! 		
//		HttpSession session = request.getSession();
//		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		placeBiz.goOriginPlaces(deletePlaceIds);
		
		// 1 : new place 
		// 0 : origin place
		response.sendRedirect(Root.get(this) + "/newPlaceList?sortOption=9");
	}

}
