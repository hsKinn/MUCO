package com.ktds.muco.table.member.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.member.biz.MemberBiz;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.util.root.Root;


/**
 * Servlet implementation class PersonalInfoActionServlet
 * 
 * @author 이기연
 */
public class PersonalInfoActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MemberBiz memberBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalInfoActionServlet() {
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

		// form POST
		boolean editPresonalInfoSuccess = memberBiz.updatePersonalInfo(request);
		
		if (editPresonalInfoSuccess) {
			response.sendRedirect(Root.get(this) + "/personalInfo");
		}
		else {
			response.sendRedirect(Root.get(this) + "/personalInfo");
		}
		
		//aJax 

	
	}

}
