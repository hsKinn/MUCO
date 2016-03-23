package com.ktds.muco.table.member.biz;

import javax.servlet.http.HttpServletRequest;

import com.ktds.muco.table.member.dao.MemberDAO;
import com.ktds.muco.table.member.vo.MemberVO;

public class MemberBiz {
	
	private MemberDAO memberDAO;
	
	public MemberBiz() {
		memberDAO = new MemberDAO();
	}
	
	/**
	 * 
	 * 회원가입 biz
	 * 
	 * @param request
	 * @author 유병훈
	 */
	public void getAddNewMember(HttpServletRequest request) {

		MemberVO memberVO = new MemberVO();
		String email = request.getParameter("userEmail");
		String password = request.getParameter("userPassword");
		String name = request.getParameter("userName");
		
		memberVO.setEmail(email);
		memberVO.setPasssword(password);
		memberVO.setName(name);
		
		memberDAO.getAddNewMember(memberVO);
		
	}

}