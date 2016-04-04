package com.ktds.muco.table.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.member.biz.MemberBiz;
import com.ktds.muco.table.member.vo.MemberListVO;
import com.ktds.muco.table.member.vo.MemberSearchVO;

/**
 * Servlet implementation class BlockedMemberListServlet
 */
public class BlockedMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberBiz memberBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlockedMemberListServlet() {
        super();
        memberBiz = new MemberBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNO = 0;
		
		try {
			pageNO = Integer.parseInt(request.getParameter("pageNO"));
		} catch (NumberFormatException nfe) {
		}
		
		MemberSearchVO memberSearchVO = new MemberSearchVO();
		memberSearchVO.setPageNO(pageNO);
		
		MemberListVO memberListVO = memberBiz.getBlockedMemberList(memberSearchVO);
		
		request.setAttribute("members", memberListVO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/blockedMemberList.jsp");
		rd.forward(request, response);
	}

}
