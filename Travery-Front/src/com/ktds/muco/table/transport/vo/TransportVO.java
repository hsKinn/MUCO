package com.ktds.muco.table.transport.vo;

import com.ktds.muco.table.reserve.vo.ReserveVO;

/**
 * 비행기 좌석 등급
 * @author 유병훈
 *
 */
public class TransportVO extends ReserveVO{
	
	private int transportId;
	private String transportClass;
	
	public int getTransportId() {
		return transportId;
	}
	public void setTransportId(int transportId) {
		this.transportId = transportId;
	}
	public String getTransportClass() {
		return transportClass;
	}
	public void setTransportClass(String transportClass) {
		this.transportClass = transportClass;
	}
	
	
	
}
