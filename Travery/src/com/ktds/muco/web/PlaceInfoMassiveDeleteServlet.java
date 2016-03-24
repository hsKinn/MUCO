package com.ktds.muco.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.cain.article.vo.ArticleVO;
import com.ktds.cain.util.Root;
import com.ktds.muco.biz.RecommendBiz;
import com.ktds.muco.biz.RecommendPlaceBiz;
import com.ktds.muco.vo.MemberVO;

/**
 * Servlet implementation class PlaceInfoMassiveDeleteServlet
 */
public class PlaceInfoMassiveDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecommendPlaceBiz rpbiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceInfoMassiveDeleteServlet() {
        super();
        rpbiz = new RecommendPlaceBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "wrong responses.");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] deletePlaceIds = request.getParameterValues("deletePlaceId");
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		rpbiz.deleteArticles(deletePlaceIds, member);
			
		response.sendRedirect("/recommedPlace");
		
	}
}
