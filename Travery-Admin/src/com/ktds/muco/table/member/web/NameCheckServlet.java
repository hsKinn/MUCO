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

/**
 * Servlet implementation class NameCheckServlet
 * 
 * @author 이기연
 * 
 */
public class NameCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberBiz memberBiz;
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
		
		// 세션정보 받아오기
		HttpSession session = request.getSession();
		MemberVO loginMemberVO = (MemberVO) session.getAttribute("_MEMBER_");
		
		String name = request.getParameter("name");
		System.out.println("이름 중복 체크: "+ name);
		
		boolean isExistName;
		
		// 자기 자신의 이름이 들어간 경우 
		// true : 존재 / false : 존재X 
		if( name.equals(loginMemberVO.getName()) ) {
			isExistName = false;
		}
		// 자신의 이름이 아닌 다른 이름을 넣었을 경우
		else {
			isExistName = memberBiz.isExistName(name);
		}
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
