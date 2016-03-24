package com.ktds.cain.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.cain.member.biz.MemberBiz;
import com.ktds.cain.member.vo.MemberVO;
import com.ktds.cain.util.Root;

/**
 * Servlet implementation class AddNewMemberServlet
 */
public class AddNewMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberBiz biz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewMemberServlet() {
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

		MemberVO memberVO = new MemberVO();
		memberVO.setNickName(request.getParameter("nickName"));
		memberVO.setPassword(request.getParameter("password"));
		memberVO.setEmail(request.getParameter("email"));
		
		MemberVO mem = (MemberVO) biz.insertNewMember(memberVO);
		
		if ( mem != null ) {
			System.out.println("확인");
			response.sendRedirect(Root.get(this) + "/memberInformation");
		}
		else {
			response.sendRedirect(Root.get(this) + "/?errorCode=1");
			return;
		}	
	}
}
