package com.ktds.muco.table.country.vo;

/**
 * 나라
 * 
 * countryId : 나라 아이디
 * countryName : 나라 이름
 * countryColor : 나라 색깔
 * countryFontColor : 나라 폰트 색깔
 * 
 * @author 김광민
 *
 */
public class CountryVO {

	private int countryId;
	private String countryName;
	private String countryColor;
	private String countryFontColor;

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

	public String getCountryColor() {
		return countryColor;
	}

	public void setCountryColor(String countryColor) {
		this.countryColor = countryColor;
	}

	public String getCountryFontColor() {
		return countryFontColor;
	}

	public void setCountryFontColor(String countryFontColor) {
		this.countryFontColor = countryFontColor;
	}

}
