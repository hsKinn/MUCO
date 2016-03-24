package com.ktds.cain.article.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.cain.article.biz.ArticlesBiz;

/**
 * Servlet implementation class DoModifyServlet
 */
public class DoModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticlesBiz biz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoModifyServlet() {
        super();
        biz = new ArticlesBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "wrong responses");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);
		
		int articleId = Integer.parseInt(multipartRequest.getParameter("articleId"));
		//System.out.println(articleId);
		
		try{
			biz.modifyArticle(multipartRequest);
			response.sendRedirect("/list");
		}
		catch (RuntimeException re) {
			System.out.println(re.getMessage());
			response.sendRedirect("/detail?articleId=" + articleId);
		}


	}
}
