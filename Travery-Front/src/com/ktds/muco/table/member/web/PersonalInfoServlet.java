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
import com.ktds.muco.table.rent.vo.RentVO;
import com.ktds.muco.table.reserve.biz.ReserveBiz;
import com.ktds.muco.table.reserve.vo.ReserveVO;
import com.ktds.muco.table.stay.vo.StayVO;
import com.ktds.muco.table.transport.vo.TransportVO;

/**
 * 
 * Servlet implementation class PersonalInfoServlet
 * 
 * @author 김광민
 * 
 */
public class PersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	private HistoryBiz historyBiz;

=======
	private ReserveBiz reserveBiz;
>>>>>>> origin/YBH14
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonalInfoServlet() {
		super();
<<<<<<< HEAD
		historyBiz = new HistoryBiz();
=======
		reserveBiz = new ReserveBiz();
>>>>>>> origin/YBH14
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

		ReserveVO reserveInfo = new ReserveVO(); 
		TransportVO transportInfo = new TransportVO();
		StayVO stayInfo = new StayVO();
		RentVO rentInfo = new RentVO();
		
		// 2. 세션정보가 있는지 확인
		// true : 세션 정보 있음 - 회원 정보 열람
		if (loginMemberVO != null) {
			
			reserveInfo = reserveBiz.getReserveInfo(loginMemberVO.getEmail());
			transportInfo = reserveBiz.getTransportInfo(loginMemberVO.getEmail());
			stayInfo = reserveBiz.getStayInfo(loginMemberVO.getEmail());
			rentInfo = reserveBiz.getRentInfo(loginMemberVO.getEmail());
			
			if(reserveInfo != null){
				request.setAttribute("reserveInfo", reserveInfo);
				request.setAttribute("transportInfo", transportInfo);
				request.setAttribute("stayInfo", stayInfo);
				request.setAttribute("rentInfo", rentInfo);
			}
			
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
