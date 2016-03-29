package com.ktds.muco.table.member.vo;

import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.country.vo.CountryVO;
import com.ktds.muco.table.place.vo.PlaceVO;

/**
 * 
 * Member VO
 * 
 * mainImageName 메인 사진 이름 mainImageLocation 메인 사진 위치 joinDate 회원가입 날짜
 * recentAccessDate 최근 접속 날짜 selectedCountryList 사용자가 Hit the road에서 선택한 나라들
 * 
 * @author 김광민
 *
 */
public class MemberVO extends PlaceVO {
	private String email = "";
	private String password = "";
	private String name = "";
	private String phoneNumber = "";
	private int isAdmin = 0;
	private String mainImageName = "";
	private String mainImageLocation = "";
	private String joinDate = "";
	private String recentAccessDate = "";

	private List<CountryVO> selectedCountryList;

	public MemberVO() {

		email = "";
		password = "";
		name = "";
		phoneNumber = "";
		isAdmin = 0;
		mainImageName = "";
		mainImageLocation = "";
		joinDate = "";
		recentAccessDate = "";

		selectedCountryList = new ArrayList<CountryVO>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getMainImageName() {
		return mainImageName;
	}

	public void setMainImageName(String mainImageName) {
		this.mainImageName = mainImageName;
	}

	public String getMainImageLocation() {
		return mainImageLocation;
	}

	public void setMainImageLocation(String mainImageLocation) {
		this.mainImageLocation = mainImageLocation;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getRecentAccessDate() {
		return recentAccessDate;
	}

	public void setRecentAccessDate(String recentAccessDate) {
		this.recentAccessDate = recentAccessDate;
	}

	public List<CountryVO> getSelectedCountryList() {
		return selectedCountryList;
	}

	public void setSelectedCountryList(List<CountryVO> selectedCountryList) {
		this.selectedCountryList = selectedCountryList;
	}

	/**
	 * 
	 * 중복 확인
	 * 
	 * @param countryVO
	 * @author 김광민
	 */
	public boolean isExistCountryByCountryName(String selectedCountryName) {

		for (CountryVO countryVO : this.getSelectedCountryList()) {

			if (selectedCountryName.equals(countryVO.getCountryName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * 리스트에 선택된 나라 추가
	 * 
	 * @param countryVO
	 * @author 김광민
	 */
	public boolean addSelectedCountry(CountryVO countryVO) {

		// 최대 20개 나라 선택 가능
		if (selectedCountryList.size() < 20) {

			System.out.println(selectedCountryList.size());

			this.selectedCountryList.add(countryVO);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * 리스트에 선택된 나라 제거
	 * 
	 * @param countryVO
	 * @author 김광민
	 */
	public boolean removeSelectedCountryByCountryName(String selectedCountryName) {

		int i = 0;
		for (CountryVO newCountryVO : this.getSelectedCountryList()) {

			if (selectedCountryName.equals(newCountryVO.getCountryName())) {

				this.selectedCountryList.remove(i);
				return true;
			}
			i++;
		}
		return false;
	}
}
