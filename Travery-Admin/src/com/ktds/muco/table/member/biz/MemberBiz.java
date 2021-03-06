package com.ktds.muco.table.member.biz;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.member.dao.MemberDAO;
import com.ktds.muco.table.member.vo.MemberListVO;
import com.ktds.muco.table.member.vo.MemberSearchVO;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.util.file.MultipartFile;
import com.ktds.muco.util.file.MultipartHttpServletRequest;
import com.ktds.muco.util.web.Paging;

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
	 * 어드민 로그인
	 * 
	 * @author 김광민
	 * 
	 */
	public boolean loginForAdmin(HttpServletRequest request) {

		MemberVO memberVO = new MemberVO();
		memberVO.setEmail(request.getParameter("userEmail"));
		memberVO.setPassword(request.getParameter("userPw"));

		MemberVO loginMemberVO = memberDAO.getMemberByEmailAndPasswordForAdmin(memberVO);

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
	public boolean updatePersonalInfo(MultipartHttpServletRequest request) {
		boolean updateCheck = false;
		
		//1. 세션정보
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("_MEMBER_");
		
		// 파일 받아오기 위한 
		if ( request.getParameter("file").length() > 0 ) {
			MultipartFile file = request.getFile("file");
			File upFile = file.write("D:\\" + file.getFileName());
			
			String fileName = file.getFileName();
			String fileLocation = upFile.getPath(); 
			
			System.out.println(fileName);
			System.out.println(fileLocation);

			// 파일 check & send to DAO
			if (fileName.length() > 0 ) {
				memberVO.setMainImageName(fileName);
				memberVO.setMainImageLocation(fileLocation);
				
				memberDAO.addMainImage(memberVO);
				System.out.println("등록한 프로필 사진: " + fileName);
			}
		}
		
		String name = request.getParameter("name");
		String password = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");
		String phoneNumber = request.getParameter("phoneNumber");
		
		// name 비교
		if ( !name.equals(memberVO.getName()) ) {
			memberVO.setName(name);
			memberDAO.updateName(memberVO);
			updateCheck =  true;
		} 
		// password 비교 
		if ( !password.equals(memberVO.getPassword()) && newPassword.length() > 0 ) {
			memberVO.setPassword(newPassword);
			memberDAO.updatePassword(memberVO);
			updateCheck = true;
		}
		// phonenumber 비교
		if ( !phoneNumber.equals(memberVO.getPhoneNumber()) ) {
			memberVO.setPhoneNumber(phoneNumber);
			memberDAO.updatePhoneNumber(memberVO);
			updateCheck = true;
		} 
		
		return updateCheck;
	}
	
	/**
	 * 이름 중복 체크
	 * 0: 중복 X 
	 * 1: 중복 O
	 * 
	 * @author 이기연
	 * 
	 * 
	 */
	public boolean isExistName(String name) {
		
		return memberDAO.isExistName(name) > 0;
	}

	/**
	 * memebr list 받아오는 method
	 * @author 이기연
	 * 
	 * @param placeSearchVO
	 * @return
	 */
	public MemberListVO getMemberList(MemberSearchVO memberSearchVO, int sortOption) {
		
		
		// 1. 전체 게시글의 수
		int allMemberCount = memberDAO.getAllMemberCount(memberSearchVO, sortOption);
		// 1-1. 기본으로 페이지를 만들어준다. 
		Paging paging = new Paging(20);
		paging.setTotalArticleCount(allMemberCount);
		// 1-2. page 가져올 때 계산 쉽게 하기 위해서 page number은 0부터 시작 
		paging.setPageNumber(memberSearchVO.getPageNO()+"");
		
		memberSearchVO.setStartIndex(paging.getStartArticleNumber());
		memberSearchVO.setEndIndex(paging.getEndArticleNumber());
		
		//전체 article 받아오기
		List<MemberVO> members = memberDAO.getAllMembers(memberSearchVO, sortOption);
		
		// 2. DAO로부터 받아온 결과를 출력
		MemberListVO memberList = new MemberListVO();
		memberList.setMemberList(members);
		// 2-2. 페이지 추가 
		memberList.setPaging(paging);
		
		return memberList;				
	}

	/**
	 * @author 이기연
	 * 차단된 멤버 리스트 불러오기
	 * @param memberSearchVO
	 * @return
	 */
	public MemberListVO getBlockedMemberList(MemberSearchVO memberSearchVO) {
		// 1. 전체 게시글의 수
		int allPlaceCount = memberDAO.getBlockedMemberCount();
		// 1-1. 기본으로 페이지를 만들어준다. 
		Paging paging = new Paging(20);
		paging.setTotalArticleCount(allPlaceCount);
		// 1-2. page 가져올 때 계산 쉽게 하기 위해서 page number은 0부터 시작 
		paging.setPageNumber(memberSearchVO.getPageNO()+"");
		
		memberSearchVO.setStartIndex(paging.getStartArticleNumber());
		memberSearchVO.setEndIndex(paging.getEndArticleNumber());
		
		//전체 article 받아오기
		List<MemberVO> members = memberDAO.getBlockedMembers(memberSearchVO);
		
		// 2. DAO로부터 받아온 결과를 출력
		MemberListVO memberList = new MemberListVO();
		memberList.setMemberList(members);
		// 2-2. 페이지 추가 
		memberList.setPaging(paging);
		
		return memberList;		
	}

	/**
	 * @author 이기연
	 * reported된 member list 받아오기
	 * @param memberSearchVO
	 * @return
	 */
	public MemberListVO getReportedMemberList(MemberSearchVO memberSearchVO) {
		
		// 1. 전체 게시글의 수
		int allPlaceCount = memberDAO.getReportedMemberCount();
		// 1-1. 기본으로 페이지를 만들어준다. 
		Paging paging = new Paging(20);
		paging.setTotalArticleCount(allPlaceCount);
		// 1-2. page 가져올 때 계산 쉽게 하기 위해서 page number은 0부터 시작 
		paging.setPageNumber(memberSearchVO.getPageNO()+"");
		
		memberSearchVO.setStartIndex(paging.getStartArticleNumber());
		memberSearchVO.setEndIndex(paging.getEndArticleNumber());
		
		//전체 article 받아오기
		List<MemberVO> members = memberDAO.getReportedMembers(memberSearchVO);
		
		// 2. DAO로부터 받아온 결과를 출력
		MemberListVO memberList = new MemberListVO();
		memberList.setMemberList(members);
		// 2-2. 페이지 추가 
		memberList.setPaging(paging);
		
		return memberList;	
	}
	
	/**
	 * @author 이기연
	 * 멤버 리스트 디테일 받는 메소드
	 * @param email
	 * @return
	 */
	public MemberVO showMemberDetail(String email) {
		MemberVO memberVO = memberDAO.getMemberDetailByEmail(email);
		return memberVO;
	}

	public boolean isAdmin(String email) {
		return memberDAO.isAdmin(email) > 0;
	}

	/**
	 * @author 이기연
	 * Member 삭제하는 기능
	 * @param deletePlaceIds
	 */
	public void deleteMembers(String[] deleteMemberEmails) {
		for (String email : deleteMemberEmails) {
			memberDAO.deleteMembers(email);
		}
	}

	/**
	 * @author 이기연
	 * Member를 Block하는 기능
	 * @param deleteMemberEmails
	 */
	public void blockMembers(String[] deleteMemberEmails) {
		for (String email : deleteMemberEmails) {
			memberDAO.blockMembersByEmail(email);
		}
	}

	/**
	 * @author 이기연
	 * 1명의 member 삭제
	 * @param email
	 */
	public void deleteMemberByEmail(String email) {
		memberDAO.blockMembersByEmail(email);
	}

	/**
	 * 1명의 member block
	 * @param email
	 */
	public void blockMemberByEmail(String email) {
		memberDAO.blockMembersByEmail(email);
	}

	/**
	 * @author 이기연
	 * 여러명을 어드민으로 승격
	 * @param deleteMemberEmails
	 */
	public void addAdminMembers(String[] deleteMemberEmails) {
		for (String email : deleteMemberEmails) {
			memberDAO.addAdminMemberByEmail(email);
		}
		
	}

	/**
	 * @author 이기연
	 * 여러명의 어드민을 일반으로 ...
	 * @param deleteMemberEmails
	 */
	public void subAdminMembers(String[] deleteMemberEmails) {
		for (String email : deleteMemberEmails) {
			memberDAO.subAdminMemberByEmail(email);
		}
	}

	/**
	 * 일반회원 -> 어드민
	 * @param email
	 */
	public void addAdminMember(String email) {
		memberDAO.addAdminMemberByEmail(email);
	}

	/**
	 * 어드민 -> 일반 회원
	 * @param email
	 */
	public void subAdminMember(String email) {
		memberDAO.subAdminMemberByEmail(email);
	}
	
	/**
	 * block 해제 
	 * @param deleteMemberEmails
	 */
	public void releaseMembers(String[] deleteMemberEmails) {
		for (String email : deleteMemberEmails) {
			memberDAO.releaseBlockedMemberByEmail(email);
		}
	}

	public void releaseBlockedMemberByEmail(String email) {
		memberDAO.releaseBlockedMemberByEmail(email);		
	}

}
