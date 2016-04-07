package com.ktds.muco.table.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.member.biz.MemberBiz;
import com.ktds.muco.table.member.vo.MemberVO;

/**
 * Servlet implementation class MemberDetailServlet
 */
public class MemberDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberBiz memberBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDetailServlet() {
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
		String email = request.getParameter("email");
		
		MemberVO memberVO = memberBiz.showMemberDetail(email);

		request.setAttribute("member", memberVO);
		
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/memberListDetail.jsp");
	    rd.forward(request, response);
	}

}
