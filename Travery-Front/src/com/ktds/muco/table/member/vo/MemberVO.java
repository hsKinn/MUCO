package com.ktds.muco.table.member.vo;

import com.ktds.muco.table.place.vo.PlaceVO;

/**
 * 
 * Member VO
 * 
 * mainImageName 메인 사진 이름 mainImageLocation 메인 사진 위치 joinDate 회원가입 날짜
 * recentAccessDate 최근 접속 날짜
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
}
