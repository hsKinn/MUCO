package com.ktds.muco.table.place.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.place.biz.PlaceBiz;
import com.ktds.muco.table.place.vo.PlaceListVO;
import com.ktds.muco.table.place.vo.PlaceSearchVO;

/**
 * Servlet implementation class OriginPlaceListActionServlet
 * @author 이기연
 */
public class OriginPlaceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PlaceBiz placeBiz;      
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public OriginPlaceListServlet() {
        super();
        placeBiz = new PlaceBiz();
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
//		String sortOption1 = request.getParameter("sortOption");
//		int sortOption = 3;
		int sortOption = Integer.parseInt(request.getParameter("sortOption"));
		System.out.println("소트 옵션: " + sortOption);
		
		PlaceListVO placeListVO;
		int pageNO = 0;

		try {
			pageNO = Integer.parseInt(request.getParameter("pageNO"));
		} catch (NumberFormatException nfe) {
		}
		
		PlaceSearchVO placeSearchVO = new PlaceSearchVO();
		placeSearchVO.setPageNO(pageNO);
		
		placeListVO = placeBiz.getOriginPlaceList(placeSearchVO, sortOption);
		request.setAttribute("places", placeListVO);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/place/originPlaceList.jsp");
		rd.forward(request, response);	
	}

}
