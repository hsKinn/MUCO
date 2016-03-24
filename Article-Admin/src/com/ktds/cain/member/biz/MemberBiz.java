package com.ktds.cain.member.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.cain.article.vo.ArticleSearchVO;
import com.ktds.cain.member.dao.MemberDAO;
import com.ktds.cain.member.vo.MemberListVO;
import com.ktds.cain.member.vo.MemberVO;
import com.ktds.cain.util.web.Paging;

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
	
	

	public MemberVO insertNewMember(MemberVO memberVO) {
		mdao.insertNewMember(memberVO);
		return memberVO;
	}
	
	public boolean invalidCheckNickName( MemberVO memberVO) {
		return mdao.invalidCheckNickName(memberVO) > 0;
	}
	
	public MemberListVO membersList(ArticleSearchVO searchVO) {
		
		int allMemberCount = 0;
		List<MemberVO> members = null;

		
		if ( searchVO.getSearchType().equals("1")) {
			allMemberCount = mdao.allMemberCount(searchVO);
		} else if ( searchVO.getSearchType().equals("2")) {
			allMemberCount = mdao.searchNickNameCount(searchVO);
		} else if ( searchVO.getSearchType().equals("3")) {
			allMemberCount = mdao.searchEmailCount(searchVO);
		} else if ( searchVO.getSearchType().equals("4")) {
			allMemberCount = mdao.searchAdminCount(searchVO);
		}
		
		Paging paging = new Paging();
		paging.setTotalArticleCount(allMemberCount);
		paging.setPageNumber(searchVO.getPageNo() + ""); 
		
		searchVO.setStartIndex( paging.getStartArticleNumber() );
		searchVO.setEndIndex( paging.getEndArticleNumber() );

		if ( searchVO.getSearchType().equals("1")) {
			members = mdao.allMember(searchVO);
		} else if ( searchVO.getSearchType().equals("2")) {
			members = mdao.searchNickName(searchVO);
		} else if ( searchVO.getSearchType().equals("3")) {
			members = mdao.searchEmail(searchVO);
		} else if ( searchVO.getSearchType().equals("4")) {
			members = mdao.searchAdmin(searchVO);
		}
		
		MemberListVO memberList = new MemberListVO();
		memberList.setMemberList(members);
		memberList.setPaging(paging);
		
		return memberList;
	}

	public MemberVO infoDetail(String memberId) {
		MemberVO member = mdao.getInfoDetail(memberId);
		return member;
	}

	public boolean infoDelete(MemberVO loginMember, MemberVO memberInfo) {
		if ( loginMember.isAdmin() || loginMember.getMemberId().equals(memberInfo.getMemberId())) {

			mdao.singleDeleteInfo( memberInfo.getMemberId() );
			mdao.multiDeleteInfo( memberInfo.getMemberId() );
			return true;
		}
		else {
			return false;
		}		
	}

	public void multiDeleteInfo(String[] deleteMemberIds, MemberVO member) {
		
		if ( member.isAdmin() ) {
			for ( String memberId : deleteMemberIds ) {
				mdao.multiDeleteInfo(memberId);
			}
		}
	}
}
