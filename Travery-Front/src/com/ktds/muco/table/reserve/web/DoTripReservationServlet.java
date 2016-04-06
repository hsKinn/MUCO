package com.ktds.muco.table.reserve.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.reserve.biz.ReserveBiz;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class DoTripReservationServlet
 */
public class DoTripReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ReserveBiz reserveBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoTripReservationServlet() {
        super();
        reserveBiz = new ReserveBiz();
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
		
		int reserveId = reserveBiz.getReserveId(request);
		int transportId = reserveBiz.getTransportId(request);
		int stayId = reserveBiz.getStayId(request);
		int rentId = reserveBiz.getRentId(request);
		
		boolean isSuccessTransport = reserveBiz.getReserveTransport(reserveId, transportId);
		boolean isSuccessStay = reserveBiz.getReserveStay(reserveId, stayId);
		boolean isSuccessRent = reserveBiz.getReserveRent(reserveId, rentId);
		
		if ( isSuccessTransport && isSuccessStay && isSuccessRent ) {
			response.sendRedirect(Root.get(this) + "/tripReservation");
		}
		else {
			response.sendRedirect(Root.get(this) + "/tripReservation");
		}
		
	}

}
