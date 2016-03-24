package com.ktds.cain.member.vo;

import java.util.List;

import com.ktds.cain.util.web.Paging;

public class MemberListVO {

	private List<MemberVO> memberList;
	private Paging paging;
	
	public List<MemberVO> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<MemberVO> memberList) {
		this.memberList = memberList;
	}
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
}
