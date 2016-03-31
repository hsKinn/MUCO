package com.ktds.muco.table.member.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.member.biz.MemberBiz;

/**
 * Servlet implementation class MemberEmailCheckServlet
 */
public class MemberEmailCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz memberBiz;

	public MemberEmailCheckServlet() {
		super();
		memberBiz = new MemberBiz();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 요청입니다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isExistMemberEmail = memberBiz.getMemberEmailCheck(request);

		StringBuffer json = new StringBuffer();
		json.append("{");
		json.append("\"result\" : true");
		json.append(", \"isExistMemberEmail\" : " + isExistMemberEmail);
		json.append("}");

		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();

	}

}
