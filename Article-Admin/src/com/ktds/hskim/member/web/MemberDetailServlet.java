package com.ktds.hskim.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.hskim.member.biz.MemberBiz;
import com.ktds.hskim.member.vo.MemberVO;
import com.ktds.hskim.util.Root;

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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		
		MemberVO member = memberBiz.getDetailMember(memberId);
		
		if ( member != null ) {
			request.setAttribute("seletedMember", member);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/detail.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect(Root.get(this) + "/list?errorCode=fail");
		}
		
		

	}

}
