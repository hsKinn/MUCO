package com.ktds.hskim.article.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.hskim.article.biz.ArticleBiz;
import com.ktds.hskim.article.vo.ArticleVO;
import com.ktds.hskim.history.biz.OperationHistoryBiz;
import com.ktds.hskim.history.vo.ActionCode;
import com.ktds.hskim.history.vo.BuildDescription;
import com.ktds.hskim.history.vo.Description;
import com.ktds.hskim.history.vo.OperationHistoryVO;
import com.ktds.hskim.util.Root;

/**
 * Servlet implementation class DetailArticleServlet
 */
public class DetailArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleBiz articleBiz;
	private OperationHistoryBiz historyBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailArticleServlet() {
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
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		ArticleVO article = articleBiz.getDetailArticle(articleId);
		
		// 필터에 담은 중복 코드
		OperationHistoryVO historyVO = (OperationHistoryVO) request.getAttribute("OperationHistoryVO");
		historyVO.setActionCode(ActionCode.ARTICLE);
		historyVO.setDescription(BuildDescription.get( Description.DETAIL, historyVO.getMemberId(), articleId+"") );
		historyVO.setEtc(BuildDescription.get(Description.DETAIL_DESCRIPTION, article.getTitle(), article.getMemberId(), article.getDescript() ));
		
		historyBiz.addHistory(historyVO);
		
		if ( article != null ) {
			request.setAttribute("selectedArticle", article);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/detail.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect(Root.get(this) + "/list?errorCode=fail");
		}
		
	}

}
