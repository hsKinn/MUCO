package com.ktds.muco.table.pack.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.pack.biz.PackBiz;

/**
 * Servlet implementation class DeletePlaceOfPackServlet
 */
public class DeletePlaceOfPackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PackBiz packBiz;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlaceOfPackServlet() {
        super();
        packBiz = new PackBiz();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int placeId = Integer.parseInt(request.getParameter("placeId"));
		int packId = Integer.parseInt(request.getParameter("packId"));
		
		System.out.println("placeId"+placeId);
		System.out.println("packId"+packId);
		
		int deletePlaceOfPackCount = 0;
		deletePlaceOfPackCount = packBiz.deletePlaceOfPack(placeId,packId);
		
		response.sendRedirect("/showPackPlace?packId="+packId);
		
	}

}
