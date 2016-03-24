package com.ktds.muco.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.biz.RecommendPlaceBiz;
import com.ktds.muco.vo.MemberVO;
import com.ktds.muco.vo.PlaceVO;

/**
 * Servlet implementation class PlaceInfoModifyServlet
 */
public class PlaceInfoModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecommendPlaceBiz rpbiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceInfoModifyServlet() {
        super();
        rpbiz = new RecommendPlaceBiz();
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
		
		PlaceVO place = rpbiz.getDetail(placeId);
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		
		if ( place.getMemberId().equals(member.getMemberId())) {
			
			String Description = place.getDescription();
			Description = Description.replaceAll("<br/>", "\n");
			place.setDescription(Description);

			request.setAttribute("place", place);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/write.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("/recommendPlace");
		}
		
	}
}
