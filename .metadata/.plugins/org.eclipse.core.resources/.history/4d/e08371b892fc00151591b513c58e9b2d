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
import com.ktds.muco.table.pack.vo.PackVO;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class AddMyPackByOnePlaceServlet
 */
public class AddMyPackByOnePlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PackBiz packBiz;
	private HistoryBiz historyBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMyPackByOnePlaceServlet() {
        super();
        packBiz = new PackBiz();
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
		
		PackVO pack = new PackVO();
		
		pack.setPackId( Integer.parseInt(request.getParameter("packList")) );
		// 패키지 선택하지 않은 경우
		if ( pack.getPackId() == 0 ) {
			response.sendRedirect(Root.get(this) + "/detailPlace?placeId=" + pack.getPlaceId());
		}
		
		pack.setPlaceId( Integer.parseInt(request.getParameter("placeId")) );
		
		boolean isSuccess = packBiz.addMyPackByOnePlace( pack );
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		if (isSuccess) {
			
			// History
			HistoryVO history = new HistoryVO();
			history.setIp(request.getRemoteHost());
			history.setEmail(member.getEmail());
			history.setUrl(request.getRequestURI());
			history.setActionCode(ActionCode.ADD_PLACE_TO_MYPACK);
			history.setHistoryDescription(BuildDescription.get(Description.ADD_PLACE_TO_MYPACK, member.getEmail(), pack.getPackId() + ""));
			historyBiz.addHistory(history);
			
			response.sendRedirect(Root.get(this) + "/detailPlace?placeId=" + pack.getPlaceId());
		}
		else {
			
			// History
			HistoryVO history = new HistoryVO();
			history.setIp(request.getRemoteHost());
			history.setEmail(member.getEmail());
			history.setUrl(request.getRequestURI());
			history.setActionCode(ActionCode.ADD_PLACE_TO_MYPACK);
			history.setHistoryDescription(BuildDescription.get(Description.ADD_PLACE_TO_MYPACK_FAIL, member.getEmail(), pack.getPackId() + ""));
			historyBiz.addHistory(history);
			
			response.sendRedirect(Root.get(this) + "/detailPlace?placeId=" + pack.getPlaceId());
		}
	}

}
