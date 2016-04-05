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
import com.ktds.muco.table.pack.biz.SharePackBiz;

/**
 * Servlet implementation class HitCountPackServlet
 */
public class HitCountPackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SharePackBiz sharePackBiz;
	private HistoryBiz historyBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HitCountPackServlet() {
        super();
        sharePackBiz = new SharePackBiz();
        historyBiz = new HistoryBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int packId = Integer.parseInt(request.getParameter("packId"));
		
		// History
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(member.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.ADD_HIT_PACK);
		if(packId > 0) {
			history.setHistoryDescription(BuildDescription.get(Description.ADD_HIT_PACK, member.getEmail(), packId+""));
		} else {
			history.setHistoryDescription(BuildDescription.get(Description.ADD_HIT_PACK_FAIL, member.getEmail(), packId+""));
		}
		historyBiz.addHistory(history);

		sharePackBiz.hitCountPack(packId);
	}

}
