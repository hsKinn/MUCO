package com.ktds.muco.table.pack.web;

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
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.pack.biz.PackBiz;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class AddMyPackByPlaceServlet
 * 
 * @author 유병훈
 */
public class AddMyPackByPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PackBiz packBiz;
	private HistoryBiz historyBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMyPackByPlaceServlet() {
        super();
        packBiz = new PackBiz();
        historyBiz = new HistoryBiz();
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
		
		String[] selectedPlaceId = request.getParameterValues("addPackByPlaceId");
		String packId2 = request.getParameter("packId");
		String packTitle = request.getParameter("packTitle");
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		

			
		if ( packTitle == null) {
			int packId = Integer.parseInt(packId2);
			boolean isSuccess = packBiz.getAddMyPackByPlace(selectedPlaceId, packId);
			
			if (isSuccess) {
				
				// History
				HistoryVO history = new HistoryVO();
				history.setIp(request.getRemoteHost());
				history.setEmail(member.getEmail());
				history.setUrl(request.getRequestURI());
				history.setActionCode(ActionCode.ADD_PLACE_TO_MYPACK);
				history.setHistoryDescription(BuildDescription.get(Description.ADD_PLACE_TO_MYPACK, member.getEmail(), packId + ""));
				historyBiz.addHistory(history);
				
				response.sendRedirect(Root.get(this) + "/hitTheRoad");
			}
			else {
				
				// History
				HistoryVO history = new HistoryVO();
				history.setIp(request.getRemoteHost());
				history.setEmail(member.getEmail());
				history.setUrl(request.getRequestURI());
				history.setActionCode(ActionCode.ADD_PLACE_TO_MYPACK);
				history.setHistoryDescription(BuildDescription.get(Description.ADD_PLACE_TO_MYPACK_FAIL, member.getEmail(), packId + ""));
				historyBiz.addHistory(history);
				response.sendRedirect(Root.get(this) + "/hitTheRoad");
			}
			
		}
		
		if ( packId2 == null ){
			packTitle = request.getParameter("packTitle");
			session = request.getSession();
			MemberVO memberVO = (MemberVO) session.getAttribute("_MEMBER_");
			
			String email = memberVO.getEmail();
			
			boolean isSuccess = packBiz.getCreateMyPackByPackTitle(email, packTitle, selectedPlaceId);
			
			if (isSuccess) {
				
				// History
				HistoryVO history = new HistoryVO();
				history.setIp(request.getRemoteHost());
				history.setEmail(member.getEmail());
				history.setUrl(request.getRequestURI());
				history.setActionCode(ActionCode.ADD_PLACE_TO_MYPACK);
				history.setHistoryDescription(BuildDescription.get(Description.ADD_PLACE_TO_MYPACK, member.getEmail(), packId2 + ""));
				historyBiz.addHistory(history);
				
				response.sendRedirect(Root.get(this) + "/hitTheRoad");
			}
			else {
				
				// History
				HistoryVO history = new HistoryVO();
				history.setIp(request.getRemoteHost());
				history.setEmail(member.getEmail());
				history.setUrl(request.getRequestURI());
				history.setActionCode(ActionCode.ADD_PLACE_TO_MYPACK);
				history.setHistoryDescription(BuildDescription.get(Description.ADD_PLACE_TO_MYPACK_FAIL, member.getEmail(), packId2 + ""));
				historyBiz.addHistory(history);
				
				response.sendRedirect(Root.get(this) + "/hitTheRoad");
			}
			
		}
	}

}
