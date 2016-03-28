package com.ktds.hskim.article.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.hskim.article.biz.ArticleBiz;
import com.ktds.hskim.article.vo.ArticleVO;
import com.ktds.hskim.member.vo.MemberVO;
import com.ktds.hskim.util.Root;

/**
 * Servlet implementation class ModifyServlet
 */
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleBiz articleBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        articleBiz = new ArticleBiz();
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
		
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		ArticleVO article = articleBiz.getDetailArticle(articleId);
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		if ( article.getMemberId().equals(member.getMemberId()) || member.isAdmin() ) {
			
			String description = article.getDescript();
			description = description.replaceAll("<br/>", "\n");
			article.setDescript(description);
			
			request.setAttribute("article", article);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/write.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect(Root.get(this) + "/list");
		}
			
		
	}

}
