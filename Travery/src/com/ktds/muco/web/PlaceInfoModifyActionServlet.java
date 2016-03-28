package com.ktds.muco.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.biz.RecommendPlaceBiz;


/**
 * Servlet implementation class PlaceInfoModifyActionServlet
 */
public class PlaceInfoModifyActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RecommendPlaceBiz rpbiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceInfoModifyActionServlet() {
        super();
        rpbiz = new RecommendPlaceBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "wrong responses");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);
		
		int placeId = Integer.parseInt(multipartRequest.getParameter("placeId"));
		//System.out.println(articleId);
		
		try{
			rpbiz.modifyArticle(multipartRequest);
			response.sendRedirect("/recommendPlace");
		}
		catch (RuntimeException re) {
			System.out.println(re.getMessage());
			response.sendRedirect("/detail?placeId=" + placeId);
		}
	}	}

}
