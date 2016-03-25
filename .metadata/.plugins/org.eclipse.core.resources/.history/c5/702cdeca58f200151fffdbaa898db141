package com.ktds.muco.table.country.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 김광민
 *
 */
public class SelectedCountryVO {

	private List<CountryVO> selectedCountryList;
	
	/**
	 * 생성자
	 */
	public SelectedCountryVO() {
		selectedCountryList = new ArrayList<CountryVO>();
	}

	public List<CountryVO> getSelectedCountryList() {
		return selectedCountryList;
	}

	public void setSelectedCountryList(List<CountryVO> selectedCountryList) {
		this.selectedCountryList = selectedCountryList;
	}
	
	/**
	 * 선택된 나라 리스트에 "새롭게 선택된 나라" 추가
	 * 
	 * @param selectedCountry
	 * @author 김광민
	 */
	public void addSelectedCountry(CountryVO countryVO) {
		this.selectedCountryList.add(countryVO);
		
		for (CountryVO sysoCountryVO : selectedCountryList) {
			
			System.out.println(sysoCountryVO.getCountryId() + "in selectedCountryVO");
			System.out.println(sysoCountryVO.getCountryName() + "in selectedCountryVO");
			System.out.println(sysoCountryVO.getCountryColor() + "in selectedCountryVO");
			System.out.println(sysoCountryVO.getCountryFontColor() + "in selectedCountryVO");
			
		}
	}

}
