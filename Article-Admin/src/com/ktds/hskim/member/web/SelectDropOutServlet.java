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
 * Servlet implementation class SelectDropOutServlet
 */
public class SelectDropOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private MemberBiz memberBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectDropOutServlet() {
        super();
        memberBiz = new MemberBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 요청입니다");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] dropOutMemberIds = request.getParameterValues("dropOutMemberId");
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		int dropCheck = memberBiz.dropOutMembers(dropOutMemberIds, member);
		
		if ( dropCheck > 0 ) {
			response.sendRedirect(Root.get(this) + "/memberList");
		}
		else {
			response.sendRedirect(Root.get(this) + "/memberList?errorCode=fail");
		}
	}

}
