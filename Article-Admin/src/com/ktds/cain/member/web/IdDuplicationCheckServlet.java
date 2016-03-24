package com.ktds.cain.member.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.cain.member.biz.MemberBiz;
import com.ktds.cain.member.vo.MemberVO;

/**
 * Servlet implementation class IdDuplicationCheckServlet
 */
public class IdDuplicationCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz biz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdDuplicationCheckServlet() {
        super();
        biz = new MemberBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendError(HttpServletResponse.SC_FORBIDDEN, "wrong request.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVO member = new MemberVO();
		member.setNickName(request.getParameter("nickName"));
		boolean checkData = biz.invalidCheckNickName(member);			
		
		System.out.println(checkData);
		
		StringBuffer json = new StringBuffer();
		
		json.append("{");
		json.append("\"result\" : true");
		json.append(", \"checkData\" : " + checkData);
		json.append("}");
		
		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
		
	}
}
