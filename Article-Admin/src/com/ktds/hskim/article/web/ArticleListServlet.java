package com.ktds.hskim.article.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.hskim.article.biz.ArticleBiz;
import com.ktds.hskim.article.vo.ArticleListVO;
import com.ktds.hskim.article.vo.ArticleSearchVO;
import com.ktds.hskim.history.biz.OperationHistoryBiz;
import com.ktds.hskim.history.vo.ActionCode;
import com.ktds.hskim.history.vo.BuildDescription;
import com.ktds.hskim.history.vo.Description;
import com.ktds.hskim.history.vo.OperationHistoryVO;
import com.ktds.hskim.member.vo.MemberVO;

/**
 * Servlet implementation class ArticleListServlet
 */
public class ArticleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleBiz articleBiz;
	private OperationHistoryBiz historyBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleListServlet() {
        super();
        articleBiz = new ArticleBiz();
        historyBiz = new OperationHistoryBiz();
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
		
		int pageNo = 0; 
		ArticleSearchVO searchVO = new ArticleSearchVO();
		HttpSession session = request.getSession();
		String searchType = request.getParameter("searchType");
				
		OperationHistoryVO historyVO = new OperationHistoryVO();
		
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		historyVO.setIp(request.getRemoteHost());
		historyVO.setMemberId(member.getMemberId());
		historyVO.setUrl(request.getRequestURI());
		historyVO.setActionCode(ActionCode.ARTICLE);
		
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			searchVO.setPageNo(pageNo);
			searchVO.setSearchKeyword( request.getParameter("searchKeyword") );
			
			
			// Paging History
			historyVO.setDescription(BuildDescription.get( Description.LIST_PAGING, member.getMemberId(), pageNo+"" ) );
			historyBiz.addHistory(historyVO);
			
		}
		catch(NumberFormatException nfe) {
			
			// List History
			historyVO.setDescription(BuildDescription.get( Description.LIST, request.getRemoteHost(), member.getMemberId()) );
			historyBiz.addHistory(historyVO);
			
			searchVO = (ArticleSearchVO) session.getAttribute("_SEARCH_");
			
			if ( searchVO == null ) {
				searchVO = new ArticleSearchVO();
				searchVO.setPageNo(0);
				searchVO.setSearchKeyword("");
			}
		}
		
		session.setAttribute("_SEARCH_", searchVO);
		
		ArticleListVO articles = articleBiz.getAllArticleList(searchVO, searchType);
		
		request.setAttribute("articles", articles);
		request.setAttribute("searchVO", searchVO);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/list.jsp");
		rd.forward(request, response);
		
	}
}
