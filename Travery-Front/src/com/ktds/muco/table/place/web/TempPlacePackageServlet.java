package com.ktds.muco.table.place.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.place.biz.PlaceBiz;
import com.ktds.muco.table.place.vo.PlaceVO;

/**
 * Servlet implementation class TempPlacePackageServlet
 */
public class TempPlacePackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PlaceBiz placeBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TempPlacePackageServlet() {
        super();

        placeBiz = new PlaceBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 요청입니다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String selectedPlaceId2 = request.getParameter("selectedPlaceId");
		String[] splitId = selectedPlaceId2.split("s");

		int selectedPlaceId = 0;
		int i=0;
		try {
			selectedPlaceId = Integer.parseInt(splitId[1]);
		} catch (NumberFormatException nfe) {	}
		
		PlaceVO placeVO = placeBiz.getTempPlacePackage(selectedPlaceId);
		
		List<PlaceVO> tempPlacePackageList = new ArrayList<PlaceVO>();
		StringBuffer json = new StringBuffer();
		
		if ( !(tempPlacePackageList.contains(placeVO)) ) {
			tempPlacePackageList.add(placeVO);
			
			
			json.append("{");
			json.append("\"result\" : true");
			json.append(", \"tempPlacePackageList\" : " + tempPlacePackageList.get(i) );
			json.append("}");
			
			i++;
		}
		else if (tempPlacePackageList.contains(placeVO)) {
			tempPlacePackageList.remove(placeVO);
			i--;
		}
		
		
		
		PrintWriter out = response.getWriter();
		out.print( json.toString() );
		out.flush();
		out.close();
		
		
	}

}
