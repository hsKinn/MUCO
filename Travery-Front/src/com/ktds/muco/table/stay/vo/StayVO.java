package com.ktds.muco.table.stay.vo;

import com.ktds.muco.table.reserve.vo.ReserveVO;

/**
 *
 * stayType 숙박 종류
 * stayClass 숙박 등급
 * 
 * @author 김광민
 *
 */
public class StayVO extends ReserveVO {

	private int stayId;
	private String stayType;
	private String stayClass;

	public int getStayId() {
		return stayId;
	}

	public void setStayId(int stayId) {
		this.stayId = stayId;
	}

	public String getStayType() {
		return stayType;
	}

	public void setStayType(String stayType) {
		this.stayType = stayType;
	}

	public String getStayClass() {
		return stayClass;
	}

	public void setStayClass(String stayClass) {
		this.stayClass = stayClass;
	}

}
