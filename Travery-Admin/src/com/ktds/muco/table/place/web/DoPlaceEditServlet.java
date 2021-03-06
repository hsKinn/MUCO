package com.ktds.muco.table.place.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.place.biz.PlaceBiz;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class DoPlaceEditServlet
 */
public class DoPlaceEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PlaceBiz placeBiz; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoPlaceEditServlet() {
        super();
        placeBiz = new PlaceBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 요청입니다");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String placeId = request.getParameter("placeId");
		PlaceVO placeVO = placeBiz.showPlaceDetail(placeId);
		
		placeBiz.doPlaceEdit(placeId, placeVO, request);
		
		response.sendRedirect(Root.get(this) + "/placeDetail?placeId="+placeId);
	
	}

}
