package com.ktds.cain.article.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.cain.article.biz.ArticlesBiz;
import com.ktds.cain.article.vo.ArticleListVO;
import com.ktds.cain.article.vo.ArticleSearchVO;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticlesBiz biz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListServlet() {
		super();
		biz = new ArticlesBiz();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		int pageNo = 0;
		ArticleSearchVO searchVO = new ArticleSearchVO();
		HttpSession session = request.getSession();

		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			
			searchVO.setPageNo(pageNo);
			searchVO.setSearchKeyword( request.getParameter("searchKeyword") );
			searchVO.setSearchType(request.getParameter("searchType"));
		}
		catch(NumberFormatException nfe) {
			
			searchVO = (ArticleSearchVO)session.getAttribute("_SEARCH_");
			
			if ( searchVO == null) {
				searchVO = new ArticleSearchVO();
				searchVO.setPageNo(0);
				searchVO.setSearchKeyword("");
				searchVO.setSearchType("1");
			}	// 받아오는 값이 null 값이 기 때문에 해당 구문을 작성하여 셋팅한다.
		}

		session.setAttribute("_SEARCH_", searchVO);
		ArticleListVO avo = biz.articlesList(searchVO);
		
		request.setAttribute("articles", avo);
		request.setAttribute("searchVO", searchVO);
		

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/list.jsp");
		rd.forward(request, response);
	}

}