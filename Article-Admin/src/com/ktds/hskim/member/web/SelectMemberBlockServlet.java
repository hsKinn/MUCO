package com.ktds.hskim.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.hskim.member.biz.MemberBiz;
import com.ktds.hskim.member.vo.MemberVO;
import com.ktds.hskim.util.Root;

/**
 * Servlet implementation class SelectMemberBlockServlet
 */
public class SelectMemberBlockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberBiz memberBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMemberBlockServlet() {
        super();
        memberBiz = new MemberBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 접근");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] blockMemberIds = request.getParameterValues("dropOutMemberId");
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		int blockCheck = memberBiz.blockMembers(blockMemberIds, member);
		
		if ( blockCheck > 0 ) {
			response.sendRedirect(Root.get(this) + "/memberList");
		}
		else {
			response.sendRedirect(Root.get(this) + "/memberList?errorCode=fail");
		}
		
	}

}
