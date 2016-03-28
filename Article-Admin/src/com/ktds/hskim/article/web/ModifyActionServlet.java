package com.ktds.hskim.article.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.hskim.article.biz.ArticleBiz;
import com.ktds.hskim.util.MultipartHttpServletRequest;
import com.ktds.hskim.util.Root;

/**
 * Servlet implementation class ModifyActionServlet
 */
public class ModifyActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticleBiz articleBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyActionServlet() {
        super();
        
        articleBiz = new ArticleBiz();
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
		
		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);
		
		int articleId = Integer.parseInt(multipartRequest.getParameter("articleId"));
		
		try {
			articleBiz.modifyArticle(multipartRequest);
			response.sendRedirect(Root.get(this) + "/list");
		}
		catch(RuntimeException re) {
			System.out.println(re.getMessage());
			response.sendRedirect(Root.get(this) + "/detail?articleId=" + articleId);
		}
	}

}
