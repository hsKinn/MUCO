package com.ktds.muco.table.member.vo;

import com.ktds.muco.table.place.vo.PlaceVO;

public class MemberVO extends PlaceVO {

	private String email;
	private String passsword;
	private String name;
	private int isAdmin;
	private String mainImageName;
	private String mainImageLocation;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
