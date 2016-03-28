package com.ktds.cain.article.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.cain.article.biz.ArticlesBiz;
import com.ktds.cain.member.vo.MemberVO;
import com.ktds.cain.util.Root;

/**
 * Servlet implementation class MassiveDeleteServlet
 */
public class MassiveDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticlesBiz biz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MassiveDeleteServlet() {
        super();
        biz = new ArticlesBiz();
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
		
		String[] deleteArticleIds = request.getParameterValues("deleteArticleId");
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		biz.deleteArticles(deleteArticleIds, member);
		
		response.sendRedirect(Root.get(this) + "/list");
	}
}
