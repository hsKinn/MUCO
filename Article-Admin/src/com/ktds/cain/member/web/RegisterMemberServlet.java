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
 * Servlet implementation class RegisterMemberServlet
 */
public class RegisterMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz biz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterMemberServlet() {
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

		MemberVO member = new MemberVO();
		biz.login(member, request);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/register.jsp");
		rd.forward(request, response);

	}

}
