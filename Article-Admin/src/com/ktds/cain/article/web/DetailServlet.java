package com.ktds.cain.article.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.cain.article.biz.ArticlesBiz;
import com.ktds.cain.article.vo.ArticleVO;

/**
 * Servlet implementation class DetailServlet
 */
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticlesBiz biz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
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
		
		ArticleVO article = biz.getDetail(articleId);
		request.setAttribute("article", article);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/detail.jsp");
		rd.forward(request, response);
	}

}
