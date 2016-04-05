package com.ktds.muco.table.placeReply.web;

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
import com.ktds.muco.table.placeReply.biz.PlaceReplyBiz;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class DeletePlaceReplyServlet
 */
public class DeletePlaceReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PlaceReplyBiz placeReplyBiz;
	private HistoryBiz historyBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlaceReplyServlet() {
        super();
        
        placeReplyBiz = new PlaceReplyBiz();
        historyBiz = new HistoryBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int placeReplyId = Integer.parseInt(request.getParameter("placeReplyId"));
		int placeId = Integer.parseInt(request.getParameter("placeId"));
		
		boolean check = placeReplyBiz.deletePlaceReply(placeReplyId);
		
		// History
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(member.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.DEL_PLACE_REPLY);

		
		if ( check ) {
			
			history.setHistoryDescription(BuildDescription.get(Description.DEL_PLACE_REPLY, member.getEmail(), placeId+"", placeReplyId+""));
			historyBiz.addHistory(history);
			
			response.sendRedirect(Root.get(this) + "/detailPlace?placeId=" + placeId);
		}
		else {
			
			history.setHistoryDescription(BuildDescription.get(Description.DEL_PLACE_REPLY_FAIL, member.getEmail(), placeId+"", placeReplyId+""));
			historyBiz.addHistory(history);
			
			response.sendRedirect(Root.get(this) + "/detailPlace?placeId=" + placeId);
		}
		
	}

}
