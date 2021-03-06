package com.ktds.muco.table.place.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.evaluation.biz.EvaluationBiz;
import com.ktds.muco.table.evaluation.vo.EvaluationListVO;
import com.ktds.muco.table.place.biz.PlaceBiz;
import com.ktds.muco.table.place.vo.PlaceVO;

/**
 * Servlet implementation class OriginPlaceDetailServlet
 */
public class PlaceDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PlaceBiz placeBiz;
	private EvaluationBiz evaluationBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceDetailServlet() {
        super();
        placeBiz = new PlaceBiz();
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
		String placeId = request.getParameter("placeId");
		EvaluationListVO evaluationListVO;
		
		PlaceVO placeVO = placeBiz.showPlaceDetail(placeId);
//		evaluationListVO = evaluationBiz.getAvgEvaluationListByPlaceId(placeId);
		
		request.setAttribute("placeDetail", placeVO);
		request.setAttribute("registerMember", placeVO.getWriter());
//		request.setAttribute("evaluationList", evaluationListVO);
		
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/place/placeListDetail.jsp");
	    rd.forward(request, response);
	}

}
