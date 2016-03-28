package com.ktds.muco.table.packLike.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.packLike.biz.PackLikeBiz;
import com.ktds.muco.table.packLike.vo.PackLikeVO;

/**
 * Servlet implementation class PackLikeServlet
 */
public class PackLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PackLikeBiz packLikeBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PackLikeServlet() {
        super();
        
        packLikeBiz = new PackLikeBiz();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 접근");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int packId = Integer.parseInt(request.getParameter("packId"));
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");		
		
		PackLikeVO packLike = new PackLikeVO();
		packLike.setPackId(packId);
		packLike.setEmail(member.getEmail());
		
		packLikeBiz.insertOrDeletePackLike(packLike);
		boolean isExistPackLike = packLikeBiz.isExistPackLike(packLike);
		
		StringBuffer json = new StringBuffer();
		
		json.append("{");
		json.append("\"result\" : true");
		json.append(", \"isPackLike\" : " + isExistPackLike );
		json.append("}");
		
		PrintWriter out = response.getWriter();
		out.print( json.toString() );
		out.flush();
		out.close();		
	}

}
