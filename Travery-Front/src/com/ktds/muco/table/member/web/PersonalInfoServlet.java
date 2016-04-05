package com.ktds.muco.table.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.history.biz.HistoryBiz;
import com.ktds.muco.table.history.vo.ActionCode;
import com.ktds.muco.table.history.vo.BuildDescription;
import com.ktds.muco.table.history.vo.Description;
import com.ktds.muco.table.history.vo.HistoryVO;
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
	private HistoryBiz historyBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonalInfoServlet() {
		super();
		historyBiz = new HistoryBiz();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 * @author 이기연
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 세션정보
		HttpSession session = request.getSession();
		MemberVO loginMemberVO = (MemberVO) session.getAttribute("_MEMBER_");

		// 2. 세션정보가 있는지 확인
		// true : 세션 정보 있음 - 회원 정보 열람
		if (loginMemberVO != null) {
			request.setAttribute("email", loginMemberVO.getEmail());
			request.setAttribute("name", loginMemberVO.getName());
			request.setAttribute("password", loginMemberVO.getPassword());
			request.setAttribute("phoneNumber", loginMemberVO.getPhoneNumber());
			request.setAttribute("mainImageName", loginMemberVO.getMainImageName());
			request.setAttribute("mainImageLocation", loginMemberVO.getMainImageLocation());

			System.out.println("파일 location: " + loginMemberVO.getMainImageLocation());

			// History
			HistoryVO history = new HistoryVO();
			history.setIp(request.getRemoteHost());
			history.setEmail(loginMemberVO.getEmail());
			history.setUrl(request.getRequestURI());
			history.setActionCode(ActionCode.PERSONAL_INFO);
			history.setHistoryDescription(BuildDescription.get(Description.PERSONAL_INFO, loginMemberVO.getEmail()));
			historyBiz.addHistory(history);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/personalInfo.jsp");
			rd.forward(request, response);

			System.out.println(loginMemberVO.getPassword());
		}
		// false : 세션 정보 없음 - 회원 정보 열람 불가
		else {
			response.sendRedirect("/");
		}
	}

}
