package com.ktds.muco.table.member.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.member.biz.MemberBiz;

/**
 * Servlet implementation class NameCheckServlet
 * 
 * @author 이기연
 * 
 */
public class NameCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MemberBiz memberBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameCheckServlet() {
        super();
        memberBiz = new MemberBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 요청입니다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println("이름 중복 체크: "+ name);
		
		//true : 존재 / false : 존재X 
		boolean isExistName = memberBiz.isExistName(name);
		
		StringBuffer json = new StringBuffer();
		json.append("{");
		json.append("\"result\" : true");
		json.append(", \"isExistName\" : " + isExistName);
		json.append("}");
		
		PrintWriter out = response.getWriter();
		out.println(json.toString());
		out.flush();
		out.close();
	}

}
