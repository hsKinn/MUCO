package com.ktds.muco.table.placeReply.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.placeReply.biz.PlaceReplyBiz;
import com.ktds.muco.table.placeReply.vo.PlaceReplyVO;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class DoWritePlaceReplyServlet
 */
public class DoWritePlaceReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlaceReplyBiz placeReplyBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoWritePlaceReplyServlet() {
        super();
        placeReplyBiz = new PlaceReplyBiz();
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

		int placeId = Integer.parseInt(request.getParameter("placeId"));
		int depth = Integer.parseInt(request.getParameter("depth"));
		int parentReplyId = Integer.parseInt(request.getParameter("parentReplyId"));
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		int placeReplyId = Integer.parseInt(request.getParameter("placeReplyId"));
		String description = request.getParameter("description");
		
		PlaceReplyVO placeReply = new PlaceReplyVO();
		placeReply.setPlaceId(placeId);
		placeReply.setDepth(depth);
		placeReply.setParentReplyId(parentReplyId);
		placeReply.setGroupId(groupId);
		placeReply.setOrderNo(orderNo);
		placeReply.setPlaceReplyDescription(description);
		placeReply.setPlaceReplyId(placeReplyId);
	
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		if ( member != null ) {
			placeReply.setEmail(member.getEmail());
		}		
		
		placeReplyBiz.addNewPlaceReplyDepthOne(placeReply);
		
		response.sendRedirect(Root.get(this) + "/detailPlace?placeId=" + placeId);
	}

}
