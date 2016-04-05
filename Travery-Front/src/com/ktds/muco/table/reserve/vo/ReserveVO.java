package com.ktds.muco.table.reserve.vo;

import com.ktds.muco.table.pack.vo.PackVO;

/**
 * 
 * @author 김광민
 *
 */
public class ReserveVO extends PackVO {

	private int reserveId;
	private String departureName;
	private String departDate;
	private String arriveDate;
	private int isOneWay;
	private int personCount;

	
	public int getPersonCount() {
		return personCount;
	}

	public void setPersonCount(int personCount) {
		this.personCount = personCount;
	}

	public String getDepartureName() {
		return departureName;
	}

	public void setDepartureName(String departureName) {
		this.departureName = departureName;
	}

	public int getReserveId() {
		return reserveId;
	}

	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}

	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	public String getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}

	public int getIsOneWay() {
		return isOneWay;
	}

	public void setIsOneWay(int isOneWay) {
		this.isOneWay = isOneWay;
	}

}
