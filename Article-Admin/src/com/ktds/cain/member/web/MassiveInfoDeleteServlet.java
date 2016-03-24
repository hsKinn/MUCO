package com.ktds.cain.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.cain.member.biz.MemberBiz;
import com.ktds.cain.member.vo.MemberVO;
import com.ktds.cain.util.Root;

/**
 * Servlet implementation class MassiveInfoDeleteServlet
 */
public class MassiveInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz biz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MassiveInfoDeleteServlet() {
        super();
        biz = new MemberBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "wrong responses.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] deleteMemberIds = request.getParameterValues("deleteMemberId");
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		biz.multiDeleteInfo(deleteMemberIds, member);
		
		response.sendRedirect(Root.get(this) + "/memberInformation");
	}

}
