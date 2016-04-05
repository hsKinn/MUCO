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
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class DeletePackReplyServlet
 */
public class DeletePackReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PackReplyBiz packReplyBiz;
	private HistoryBiz historyBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePackReplyServlet() {
        super();
        
        packReplyBiz = new PackReplyBiz();
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
		
		int packReplyId = Integer.parseInt(request.getParameter("packReplyId"));
		
		boolean check = packReplyBiz.deletePackReply(packReplyId);
		
		// History
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(member.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.PACK_REPLY_DEL);
		
		if (check) {
			
			history.setHistoryDescription(BuildDescription.get(Description.PACK_REPLY_DEL, member.getEmail(), packReplyId+""));
			historyBiz.addHistory(history);
			
			response.sendRedirect(Root.get(this) + "/sharePack");
		}
		else {
			
			
			history.setHistoryDescription(BuildDescription.get(Description.PACK_REPLY_DEL_FAIL, member.getEmail(), packReplyId+""));
			historyBiz.addHistory(history);
			
			response.sendRedirect(Root.get(this) + "/sharePack?deleteFail");
		}
	}

}
