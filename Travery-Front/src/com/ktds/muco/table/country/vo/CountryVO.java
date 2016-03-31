package com.ktds.muco.table.country.vo;

import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.place.vo.PlaceVO;

/**
 * 나라
 * 
 * countryId : 나라 아이디 countryName : 나라 이름 countryColor : 나라 색깔 countryFontColor
 * : 나라 폰트 색깔
 * 
 * @author 김광민
 *
 */
public class CountryVO {

	private int countryId;
	private String countryName;

	// 해당 나라에 속한 여행지 리스트
	private List<PlaceVO> placeList;

	public CountryVO() {
		placeList = new ArrayList<PlaceVO>();
	}

	public List<PlaceVO> getPlaceList() {
		return placeList;
	}

	public void setPlaceList(List<PlaceVO> placeList) {
		this.placeList = placeList;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
