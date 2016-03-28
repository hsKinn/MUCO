package com.ktds.hskim.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.hskim.member.biz.MemberBiz;
import com.ktds.hskim.member.vo.MemberVO;
import com.ktds.hskim.util.Root;

/**
 * Servlet implementation class MemberBlockServlet
 */
public class MemberBlockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberBiz memberBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberBlockServlet() {
        super();
        
        memberBiz = new MemberBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		
		MemberVO member = memberBiz.getDetailMember(memberId);
		
		memberBiz.memberBlock(member);
		
		response.sendRedirect(Root.get(this) + "/memberDetail?memberId=" + memberId);
	}

}
