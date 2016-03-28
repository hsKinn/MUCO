package com.ktds.muco.table.pack.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.pack.biz.PackBiz;
import com.ktds.muco.table.pack.vo.PackVO;

/**
 * Servlet implementation class DeletePackServlet
 */
public class DeletePackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PackBiz packBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePackServlet() {
        super();
        packBiz = new PackBiz();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
		
		String email=loginMember.getEmail();
		List<PackVO> packs = packBiz.getPackListByEmail(email);
		
		request.setAttribute("packs", packs);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/pack/deletePack.jsp");
		rd.forward(request, response);
	}

}
