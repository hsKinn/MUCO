package com.ktds.hskim.member.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.hskim.member.dao.MemberDAO;
import com.ktds.hskim.member.vo.MemberListVO;
import com.ktds.hskim.member.vo.MemberSearchVO;
import com.ktds.hskim.member.vo.MemberVO;
import com.ktds.hskim.util.web.Paging;

public class MemberBiz {
	
	private MemberDAO memberDAO;
	
	public MemberBiz() {
		memberDAO = new MemberDAO();
	} // 생성자
	
	
	/**
	 * 로그인
	 */
	public boolean login (MemberVO member, HttpServletRequest request) {
		
		// 1 회원 정보 가져오기
		MemberVO loginMember = memberDAO.getMemberByIdAndPassword(member);
		
		// 2 일치하는 회원 정보 세션에 넣기
		if ( loginMember != null ) {
			 HttpSession session = request.getSession();
			 session.setAttribute("_MEMBER_", loginMember);
		}
		
		// 3 결과 보고
		return loginMember != null;
	} // login end
	
	
	/**
	 * 회원 가입
	 */
	public boolean join (MemberVO member) {
		
		int addResult = memberDAO.addNewMember(member);
		
		if ( addResult > 0 ) {
			return true;
		}
		else {
			return false;
		}
	} //join end


	public MemberListVO getAllMemberList(MemberSearchVO searchVO) {
	
		int allMemberCount = memberDAO.getAllMemberCount();
		
		Paging paging = new Paging();
		paging.setTotalArticleCount(allMemberCount);
		paging.setPageNumber( searchVO.getPageNo() + "" );
		
		searchVO.setStartIndex( paging.getStartArticleNumber() );
		searchVO.setEndIndex( paging.getEndArticleNumber() );
		
		List<MemberVO> members = memberDAO.getMemberList(searchVO);

		MemberListVO memberList = new MemberListVO();
		memberList.setMemberList(members);
		memberList.setPaging(paging);
		
		return memberList;
	}


	public int dropOutMembers(String[] dropOutMemberIds, MemberVO member) {
		if ( member.isAdmin() ) {
			
			for (String memberId : dropOutMemberIds ) {
				if ( memberId.equals("admin") ) {
					return 0;
				}
				memberDAO.dropOutMember(memberId);
			}
			
			return 1;
		}
		else {
			return 0;
		}
		
	}
	
	public MemberVO getDetailMember(String memberId) {
		MemberVO member = memberDAO.getDetailMember(memberId);
		
		return member;
	}
	
	public void changePassword ( MemberVO member ) {
		
		memberDAO.changePassword(member);
		
	}


	public void dropOutMember(String memberId) {
		
		memberDAO.dropOutMember(memberId);
		
	}


	public void memberBlock(MemberVO member) {
		
		if ( member.getIsBlock() != null && member.getIsBlock().equals("Y") ) {
			member.setIsBlock(null);
		}
		else {
			member.setIsBlock("Y");
		}
		
		memberDAO.memberBlock(member);
	}


	public int blockMembers(String[] blockMemberIds, MemberVO member) {
		
		if ( member.isAdmin() ) {
			
			for (String memberId : blockMemberIds ) {
				if ( memberId.equals("admin") ) {
					return 0;
				}
			}
			
			for (String memberId : blockMemberIds ) {
				
				MemberVO blockMember = memberDAO.getDetailMember(memberId);
				
				if ( blockMember.getIsBlock() != null && blockMember.getIsBlock().equals("Y") ) {
					blockMember.setIsBlock(null);
				}
				else {
					blockMember.setIsBlock("Y");
				}
				
				memberDAO.memberBlock(blockMember);
			}
			
			return 1;
		}
		else {
			return 0;
		}
	}
	
}
