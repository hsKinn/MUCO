package com.ktds.cain.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.cain.member.biz.MemberBiz;
import com.ktds.cain.util.Root;

/**
 * Servlet implementation class InfoModifyServlet
 */
public class InfoModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz biz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoModifyServlet() {
        super();
        biz = new MemberBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "wrong responses");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		
		try{
			biz.modifyArticle(request);
			response.sendRedirect(Root.get(this) + "/list");
		}
		catch (RuntimeException re) {
			System.out.println(re.getMessage());
			response.sendRedirect(Root.get(this) + "/memberInfoDetail?memberId=" + memberId);
		}
	}

}
