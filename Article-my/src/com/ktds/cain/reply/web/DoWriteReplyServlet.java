package com.ktds.cain.reply.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.cain.member.vo.MemberVO;
import com.ktds.cain.reply.biz.ReplyBiz;
import com.ktds.cain.reply.vo.ReplyVO;

/**
 * Servlet implementation class DoWriteReplyServlet
 */
public class DoWriteReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyBiz biz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoWriteReplyServlet() {
        super();
        biz = new ReplyBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "wrong responses.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int articleId = Integer.parseInt(request.getParameter("articleId"));
		int depth = Integer.parseInt(request.getParameter("depth"));
		int parentReplyId = Integer.parseInt(request.getParameter("parentReplyId"));
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		int replyId = Integer.parseInt(request.getParameter("replyId"));
		String description = request.getParameter("description");
		
		
		
		ReplyVO replyInfo = new ReplyVO();
		replyInfo.setArticleId(articleId);
		replyInfo.setDepth(depth);
		replyInfo.setParentReplyId(parentReplyId);
		replyInfo.setGroupId(groupId);
		replyInfo.setOrderNo(orderNo);
		replyInfo.setDescription(description);
		replyInfo.setReplyId(replyId);
		
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		if ( member != null ) {
			replyInfo.setMemberId(member.getMemberId());
		}
		biz.addNewReplyDepthOne(replyInfo);
		response.sendRedirect("/detail?articleId=" + articleId );

	}
}
