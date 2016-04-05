package com.ktds.muco.table.evaluation.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.evaluation.biz.EvaluationBiz;
import com.ktds.muco.table.evaluation.vo.EvaluationVO;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class DoVoteServlet
 */
public class DoVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EvaluationBiz evaluationBiz; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoVoteServlet() {
        super();
        evaluationBiz = new EvaluationBiz();
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
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");		
		
		int placeId = Integer.parseInt(request.getParameter("placeId"));
		
		EvaluationVO evaluation = new EvaluationVO();
		evaluation.setPlaceId(placeId);
		evaluation.setEmail(member.getEmail());
		
		/**
		 * Vote Score 배열
		 * 
		 * [0] : Bright-Dark
		 * [1] : HightPrice-LowPrice
		 * [2] : Active-Calm
		 * [3] : Artificial-Natural
		 */
		int voteScore[] = new int[] {
										Integer.parseInt(request.getParameter("bright"))
										, Integer.parseInt(request.getParameter("highPrice"))
										, Integer.parseInt(request.getParameter("active"))
										, Integer.parseInt(request.getParameter("artificial"))
									};
		
		if ( evaluationBiz.setVoteScore( voteScore, evaluation ) ) {
			response.sendRedirect(Root.get(this) + "/detailPlace?placeId=" + placeId);
		}
		else {
			response.sendRedirect(Root.get(this) + "/detailPlace?vote=fail&placeId=" + placeId);
		}
		
		
	}

}
