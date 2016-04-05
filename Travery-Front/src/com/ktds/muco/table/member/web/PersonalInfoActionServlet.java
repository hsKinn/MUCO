package com.ktds.muco.table.member.web;

import java.io.IOException;

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
import com.ktds.muco.table.member.biz.MemberBiz;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.util.file.MultipartHttpServletRequest;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class PersonalInfoActionServlet
 * 
 * @author 이기연
 * 
 */
public class PersonalInfoActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberBiz memberBiz;
	private HistoryBiz historyBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonalInfoActionServlet() {
		super();
		memberBiz = new MemberBiz();
		historyBiz = new HistoryBiz();
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

		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);
		boolean editPresonalInfoSuccess = memberBiz.updatePersonalInfo(multipartRequest);

		// History
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(member.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.PERSONAL_INFO);
		if(editPresonalInfoSuccess) {
			history.setHistoryDescription(BuildDescription.get(Description.DO_PERSONAL_INFO, member.getEmail()));
		} else {
			history.setHistoryDescription(BuildDescription.get(Description.DO_PERSONAL_INFO_FAIL, member.getEmail()));
		}
		historyBiz.addHistory(history);
			
		response.sendRedirect(Root.get(this) + "/personalInfo");

	}

}
