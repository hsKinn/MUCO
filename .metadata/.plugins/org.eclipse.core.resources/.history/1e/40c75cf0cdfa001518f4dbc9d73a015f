package com.ktds.muco.table.placeReply.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.placeReply.biz.PlaceReplyBiz;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class DeletePlaceReplyServlet
 */
public class DeletePlaceReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PlaceReplyBiz placeReplyBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlaceReplyServlet() {
        super();
        
        placeReplyBiz = new PlaceReplyBiz();
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
		
		int placeReplyId = Integer.parseInt(request.getParameter("placeReplyId"));
		
		boolean check = placeReplyBiz.deletePlaceReply(placeReplyId);
		
		if ( check ) {
			response.sendRedirect(Root.get(this) + "/recommendPlace");
		}
		else {
			response.sendRedirect(Root.get(this) + "recommendPlace?deleteFail");
		}
		
	}

}
