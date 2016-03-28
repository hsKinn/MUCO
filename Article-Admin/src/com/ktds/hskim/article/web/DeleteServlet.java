package com.ktds.hskim.article.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.hskim.article.biz.ArticleBiz;
import com.ktds.hskim.article.vo.ArticleVO;
import com.ktds.hskim.file.biz.FileBiz;
import com.ktds.hskim.member.vo.MemberVO;
import com.ktds.hskim.util.Root;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleBiz articleBiz;
	private FileBiz fileBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        articleBiz = new ArticleBiz();
        fileBiz = new FileBiz();
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
		
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
		
		ArticleVO targetArticleInfo = articleBiz.getDetailArticle(articleId);
		
		boolean checkDeleteArticle = articleBiz.deleteArticle(loginMember, targetArticleInfo);
		
		
		// deleteArticleAction
		if ( checkDeleteArticle ) {
			response.sendRedirect(Root.get(this) + "/list");
		}
		else {
			// Delete 실패
			response.sendRedirect(Root.get(this) + "/list?errorCode=fail");
		}

	}

}
