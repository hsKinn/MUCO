package com.ktds.hskim.member.vo;

import com.ktds.hskim.file.vo.FileVO;

public class MemberVO {
	
	private String memberId;
	private String nickName;
	private String password;
	private String email;
	private String isBlock;
	private String isAdmin;

	public String getIsBlock() {
		return isBlock;
	}
	public void setIsBlock(String isBlock) {
		this.isBlock = isBlock;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isAdmin() {
		if ( this.isAdmin == null ) {
			return false;
		}
		else if ( this.isAdmin != null && this.isAdmin.equals("Y") ) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isBlock() {
		if ( this.isBlock == null ) {
			return false;
		}
		else if ( this.isBlock != null && this.isBlock.equals("Y") ) {
			return true;
		}
		else {
			return false;
		}
	}
}
