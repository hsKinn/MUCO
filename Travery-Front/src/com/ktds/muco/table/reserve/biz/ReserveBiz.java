package com.ktds.muco.table.reserve.biz;

import javax.servlet.http.HttpServletRequest;

import com.ktds.muco.table.rent.vo.RentVO;
import com.ktds.muco.table.reserve.dao.ReserveDAO;
import com.ktds.muco.table.reserve.vo.ReserveVO;
import com.ktds.muco.table.stay.vo.StayVO;
import com.ktds.muco.table.transport.vo.TransportVO;

/**
 * 
 * @author 김광민
 *
 */
public class ReserveBiz {
	
	private ReserveDAO reserveDAO;
	
	public ReserveBiz() {
		reserveDAO = new ReserveDAO();
	}
	
	
	/**
	 * reserveVO 입력 및 reserveId 리턴
	 * @author 유병훈
	 *
	 */
	public int getReserveId(HttpServletRequest request) {
		
		String departureName = request.getParameter("departure");
		int arriveByPackId = Integer.parseInt(request.getParameter("destination"));
		String departDate = request.getParameter("departureDate");
		String arriveDate = request.getParameter("destinationDate");
		int traPerson = Integer.parseInt(request.getParameter("traPerson"));
		
		ReserveVO reserveVO = new ReserveVO();
		reserveVO.setDepartureName(departureName);
		reserveVO.setPackId(arriveByPackId);
		reserveVO.setDepartDate(departDate);
		reserveVO.setArriveDate(arriveDate);
		reserveVO.setPersonCount(traPerson);
			
		int reserveId = reserveDAO.getReserveId(reserveVO);
		
		return reserveId;
		
	}

	/**
	 * transportVO 입력 및 transportId 리턴
	 * @author 유병훈
	 *
	 */
	public int getTransportId(HttpServletRequest request) {

		String transportClass = request.getParameter("traGrade");
		
		TransportVO transportVO = new TransportVO();
		transportVO.setTransportClass(transportClass);
		
		int transportId = reserveDAO.getTransportId(transportVO);
		
		return transportId;
		
	}

	/**
	 * stayVO 입력 및 stayId 리턴
	 * @author 유병훈
	 *
	 */
	public int getStayId(HttpServletRequest request) {
		
		String stayType = request.getParameter("accommodations");
		String stayClass = request.getParameter("accGrade");
		String checkInDate = request.getParameter("checkIn");
		String checkOutDate = request.getParameter("checkOut");
		int accPerson = Integer.parseInt(request.getParameter("accPerson"));
		
		StayVO stayVO = new StayVO();
		stayVO.setStayType(stayType);
		stayVO.setStayClass(stayClass);
		stayVO.setCheckInDate(checkInDate);
		stayVO.setCheckOutDate(checkOutDate);
		stayVO.setPersonCount(accPerson);
		
		int stayId = reserveDAO.getStayId(stayVO);
		
		return stayId;
		
	}
	
	/**
	 * rentVO 입력 및 rentId 리턴
	 * @author 유병훈
	 *
	 */
	public int getRentId(HttpServletRequest request) {

		String rentType = request.getParameter("rentCar");
		String rentStartDate = request.getParameter("rentDate");
		String rentEndDate = request.getParameter("returnDate");
		int rentPerson = Integer.parseInt(request.getParameter("rentPerson"));
		
		RentVO rentVO = new RentVO();
		rentVO.setRentType(rentType);
		rentVO.setRentStartDate(rentStartDate);
		rentVO.setRentEndDate(rentEndDate);
		rentVO.setPersonCount(rentPerson);
		
		int rentId = reserveDAO.getRentId(rentVO);
		
		return rentId;
		
	}


	public boolean getReserveTransport(int reserveId, int transportId) {
		
		int isSuccess = 0;
		isSuccess = reserveDAO.getReserveTransport(reserveId, transportId);
		
		if ( isSuccess > 0 ) {
			return true;
		}
		return false;
	}


	public boolean getReserveStay(int reserveId, int stayId) {
		
		int isSuccess = 0;
		isSuccess = reserveDAO.getReserveStay(reserveId, stayId);
		
		if ( isSuccess > 0 ) {
			return true;
		}
		return false;
	}


	public boolean getReserveRent(int reserveId, int rentId) {
		
		int isSuccess = 0;
		isSuccess = reserveDAO.getReserveRent(reserveId, rentId);
		
		if ( isSuccess > 0 ) {
			return true;
		}
		return false;
	}


	public ReserveVO getReserveInfo(String email) {

		ReserveVO reserveVO = new ReserveVO();
		reserveVO = reserveDAO.getReserveInfo(email);
		
		return reserveVO;
	}


	public TransportVO getTransportInfo(String email) {
		
		TransportVO transportVO = new TransportVO();
		transportVO = reserveDAO.getTransportInfo(email);
		
		return transportVO;
	}


	public StayVO getStayInfo(String email) {
		
		StayVO stayVO = new StayVO();
		stayVO = reserveDAO.getStayInfo(email);
		
		return stayVO;
	}


	public RentVO getRentInfo(String email) {
		RentVO rentVO = new RentVO();
		rentVO = reserveDAO.getRentInfo(email);
		
		return rentVO;
	}


}
