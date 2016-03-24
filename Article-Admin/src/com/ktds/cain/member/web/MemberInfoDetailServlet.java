package com.ktds.cain.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.cain.member.biz.MemberBiz;
import com.ktds.cain.member.vo.MemberVO;

/**
 * Servlet implementation class MemberInfoDetailServlet
 */
public class MemberInfoDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz biz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInfoDetailServlet() {
        super();
        biz = new MemberBiz();
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
		String memberId = request.getParameter("memberId");
		
		MemberVO member = biz.infoDetail(memberId);
		request.setAttribute("member", member);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/infoDetail.jsp");
		rd.forward(request, response);
	}

}
