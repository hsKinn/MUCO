package com.ktds.muco.table.member.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.member.dao.MemberDAO;
import com.ktds.muco.table.member.vo.MemberVO;

/**
 * 
 * @author 김광민
 *
 */
public class MemberBiz {

	private MemberDAO memberDAO;

	public MemberBiz() {
		memberDAO = new MemberDAO();
	}

	/**
	 * 
	 * 회원가입
	 * 
	 * @author 유병훈
	 * 
	 */
	public void addNewMember(HttpServletRequest request) {

		MemberVO memberVO = new MemberVO();
		String email = request.getParameter("userEmail");
		String password = request.getParameter("userPassword");
		String name = request.getParameter("userName");

		memberVO.setEmail(email);
		memberVO.setPassword(password);
		memberVO.setName(name);

		memberDAO.addNewMember(memberVO);

	}

	/**
	 * 
	 * 로그인
	 * 
	 * @author 김광민
	 * 
	 */
	public boolean login(HttpServletRequest request) {

		MemberVO memberVO = new MemberVO();
		memberVO.setEmail(request.getParameter("userEmail"));
		memberVO.setPassword(request.getParameter("userPw"));

		MemberVO loginMemberVO = memberDAO.getMemberByEmailAndPassword(memberVO);

		// 해당 유저가 있으면 세션에 등록
		if (loginMemberVO != null) {

			HttpSession session = request.getSession();
			session.setAttribute("_MEMBER_", loginMemberVO);
		}

		return loginMemberVO != null;
	}

	public boolean logout(HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.invalidate();
		
		return true;

	}

	/**
	 * 회원 정보 변경 
	 * 
	 * @author 이기연
	 * 
	 */
	public boolean updatePersonalInfo(HttpServletRequest request) {
		
		//1. 세션정보
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("_MEMBER_");
		
		String fileLocation; 
		String fileName;

		String name = request.getParameter("name");
		String password = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");
		String phoneNumber = request.getParameter("phoneNumber");
		
		// name 비교
		if ( !name.equals(memberVO.getName()) ) {
			memberVO.setName(name);
			memberDAO.updateName(memberVO);
			return true;
		} 
		// password 비교 
		else if ( !password.equals(memberVO.getPassword()) && newPassword.length() > 0 ) {
			memberVO.setPassword(newPassword);
			return true;
		}
		// phonenumber 비교
		else if ( !phoneNumber.equals(memberVO.getPhoneNumber()) ) {
			memberVO.setPhoneNumber(phoneNumber);
			memberDAO.updatePhoneNumber(memberVO);
			return true;
		} 
		
		return false;
	}

}
