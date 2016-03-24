package com.ktds.cain.member.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.cain.member.dao.MemberDAO;
import com.ktds.cain.member.vo.MemberVO;

public class MemberBiz {

	private MemberDAO mdao;
	
	public MemberBiz() {
		mdao = new MemberDAO();
	}
	
	public boolean login(MemberVO member, HttpServletRequest request) {
		
		//	get member info
		
		MemberVO loginMember = mdao.getMemberByIdAndPassword(member);
		
		// if have member info into session
		
		if ( loginMember != null ) {
			HttpSession session = request.getSession();
			session.setAttribute("_MEMBER_", loginMember);
		}
		
		
		// get results reports.
		
		return loginMember != null;
	}
	
	

	public boolean insertNewMember(MemberVO vo, HttpServletRequest request) {
		
		vo.setNickName(request.getParameter("newNickName"));
		vo.setPassword(request.getParameter("newPassword"));
		vo.setEmail(request.getParameter("newEmail"));

		if (mdao.insertNewMember(vo) > 0) {
				return true;
		}
		return false;
	}
}
