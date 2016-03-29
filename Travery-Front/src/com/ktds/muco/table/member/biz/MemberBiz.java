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
	 * 회원Email 중복체크 biz
	 * 
	 * @param request
	 * @author 유병훈
	 */
	public boolean getMemberEmailCheck(HttpServletRequest request) {

		String userEmail = request.getParameter("checkUserEmail");
		
		return memberDAO.getMemberEmailCheck(userEmail) > 0;
		
	}

	/**
	 * 
	 * 검색 기준 변경
	 * 
	 * Hit The Road 여행지 검색에서
	 * 
	 * @param request
	 * @return
	 * @author 김광민
	 */
	public String[] selectedStandard(HttpServletRequest request) {
		
		String selectedStandard = request.getParameter("selectedStandard");
		String selectedStandardName = request.getParameter("selectedStandardName");

		System.out.println("selectedStandard in Biz : " + selectedStandard);
		System.out.println("selectedStandardName in Biz : " + selectedStandardName);

		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("_MEMBER_");

		if (!selectedStandard.isEmpty() && !selectedStandardName.isEmpty() ) {
			
			String[] splitedStandardName = selectedStandardName.split("-");
			
			if(selectedStandard.equals("X")){
				memberVO.setAxisX(splitedStandardName[0], splitedStandardName[1]);
				
				System.out.println("selectedStandardName 0 in Biz : " + splitedStandardName[0]);
				System.out.println("selectedStandardName 1 in Biz : " + splitedStandardName[1]);
			}
			else{
				memberVO.setAxisY(splitedStandardName[0], splitedStandardName[1]);
				
				System.out.println("selectedStandardName 0 in Biz : " + splitedStandardName[0]);
				System.out.println("selectedStandardName 1 in Biz : " + splitedStandardName[1]);
			}
			session.setAttribute("_MEMBER_", memberVO);
			
			return splitedStandardName;
		}
		return null;
	}

}
