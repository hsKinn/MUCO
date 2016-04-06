package com.ktds.muco.table.packReply.web;

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
import com.ktds.muco.table.packReply.biz.PackReplyBiz;
import com.ktds.muco.table.packReply.vo.PackReplyVO;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class DoWritePackReplyServlet
 */
public class DoWritePackReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PackReplyBiz packReplyBiz;
	private HistoryBiz historyBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoWritePackReplyServlet() {
        super();
        
        packReplyBiz = new PackReplyBiz();
        historyBiz = new HistoryBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 요청입니다");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int packId = Integer.parseInt(request.getParameter("packId"));
		int depth = Integer.parseInt(request.getParameter("depth"));
		int parentReplyId = Integer.parseInt(request.getParameter("parentReplyId"));
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		int packReplyId = Integer.parseInt(request.getParameter("packReplyId"));
		String description = request.getParameter("description");
		
		PackReplyVO packReply = new PackReplyVO();
		packReply.setPackId(packId);
		packReply.setDepth(depth);
		packReply.setParentReplyId(parentReplyId);
		packReply.setGroupId(groupId);
		packReply.setOrderNo(orderNo);
		packReply.setPackReplyDescription(description);
		packReply.setPackReplyId(packReplyId);
	
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		if ( member != null ) {
			
			
			
			packReply.setEmail(member.getEmail());
		}
		
		packReplyBiz.addNewReplyDepthOne(packReply);
		
		
		// History
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(member.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.PACK_REPLY_ADD);
		if(packId > 0) {
			history.setHistoryDescription(BuildDescription.get(Description.PACK_REPLY_ADD, member.getEmail(), packId+""));
		} else {
			history.setHistoryDescription(BuildDescription.get(Description.PACK_REPLY_ADD_FAIL, member.getEmail(), packId+""));
		}
		historyBiz.addHistory(history);
		
		response.sendRedirect(Root.get(this) + "/sharePack");
	}

}
