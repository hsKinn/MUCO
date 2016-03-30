package com.ktds.muco.table.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ha.backend.Sender;

import com.ktds.muco.table.member.vo.MemberVO;

/**
 * 
 * Servlet implementation class PersonalInfoServlet
 * 
 * @author 김광민
 * 
 */
public class PersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
<<<<<<< HEAD
	 */
	public PersonalInfoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
=======
	 */
	public PersonalInfoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
>>>>>>> origin/롯드4
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
<<<<<<< HEAD
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * @author 이기연
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1. 세션정보
		HttpSession session = request.getSession();
		MemberVO loginMemberVO = (MemberVO) session.getAttribute("_MEMBER_");
		
		// 2. 세션정보가 있는지 확인
		// true : 세션 정보 있음 - 회원 정보 열람
		if ( loginMemberVO != null) {
			request.setAttribute("email", loginMemberVO.getEmail());
			request.setAttribute("name", loginMemberVO.getName());
			request.setAttribute("password", loginMemberVO.getPassword());
			request.setAttribute("phoneNumber", loginMemberVO.getPhoneNumber());
			request.setAttribute("mainImageName", loginMemberVO.getMainImageName());
			request.setAttribute("mainImageLocation", loginMemberVO.getMainImageLocation());
			
			System.out.println("파일 location: "+loginMemberVO.getMainImageLocation());
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/personalInfo.jsp");
			rd.forward(request, response);
			
			System.out.println(loginMemberVO.getPassword());
		}
		// false : 세션 정보 없음 - 회원 정보 열람 불가
		else {
			response.sendRedirect("/");
		}
=======
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/personalInfo.jsp");
		rd.forward(request, response);
>>>>>>> origin/롯드4
	}

}
