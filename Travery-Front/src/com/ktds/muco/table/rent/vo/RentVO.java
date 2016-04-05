package com.ktds.muco.table.rent.vo;

import com.ktds.muco.table.reserve.vo.ReserveVO;

/**
 * 렌트카 종류, 대여일, 반납일
 * @author 유병훈
 *
 */
public class RentVO extends ReserveVO{
	
	private int rentId;
	private String rentType;
	private String rentStartDate;
	private String rentEndDate;
	private int personCount;
	
	
	public int getPersonCount() {
		return personCount;
	}
	public void setPersonCount(int personCount) {
		this.personCount = personCount;
	}
	public int getRentId() {
		return rentId;
	}
	public void setRentId(int rentId) {
		this.rentId = rentId;
	}
	public String getRentType() {
		return rentType;
	}
	public void setRentType(String rentType) {
		this.rentType = rentType;
	}
	public String getRentStartDate() {
		return rentStartDate;
	}
	public void setRentStartDate(String rentStartDate) {
		this.rentStartDate = rentStartDate;
	}
	public String getRentEndDate() {
		return rentEndDate;
	}
	public void setRentEndDate(String rentEndDate) {
		this.rentEndDate = rentEndDate;
	}
	
	
	
}
