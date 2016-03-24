package com.ktds.cain.article.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.cain.article.biz.ArticlesBiz;
import com.ktds.cain.util.Root;

/**
 * Servlet implementation class HitServlet
 */
public class HitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticlesBiz biz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HitServlet() {
        super();
        biz = new ArticlesBiz();
        
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
		
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		try {
			biz.getHit(articleId);
		}
		catch ( RuntimeException re ) {
			System.out.println(re.getMessage());
			response.sendRedirect(Root.get(this) +"/detail?articleId=" + articleId);
		}
	}

}
