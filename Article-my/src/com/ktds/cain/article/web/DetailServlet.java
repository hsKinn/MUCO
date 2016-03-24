package com.ktds.cain.article.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.cain.article.biz.ArticlesBiz;
import com.ktds.cain.article.vo.ArticleVO;
import com.ktds.cain.favo.biz.FavoriteBiz;
import com.ktds.cain.favo.vo.FavoVO;
import com.ktds.cain.history.biz.OperationHistoryBiz;
import com.ktds.cain.history.vo.ActionCode;
import com.ktds.cain.history.vo.BuildDescription;
import com.ktds.cain.history.vo.Description;
import com.ktds.cain.history.vo.OperationHistoryVO;
import com.ktds.cain.member.vo.MemberVO;

/**
 * Servlet implementation class DetailServlet
 */
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticlesBiz biz;
	private OperationHistoryBiz historyBiz;
	private FavoriteBiz favoriteBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        biz = new ArticlesBiz();
        historyBiz = new OperationHistoryBiz();
        favoriteBiz = new FavoriteBiz();
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
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		FavoVO favoriteVO = new FavoVO();
		favoriteVO.setArticleId(articleId);
		favoriteVO.setMemberId(member.getMemberId());
		boolean isExistsFavoriteData = favoriteBiz.isExistFavoriteData(favoriteVO);
		
		
		OperationHistoryVO historyVO = (OperationHistoryVO) request.getAttribute("OperationHistoryVO");
		
		historyVO.setActionCode(ActionCode.ARTICLE);
		historyVO.setDescription(BuildDescription.get(Description.DETAIL, historyVO.getMemberId(), articleId+""));
		
		
		historyVO.setEtc(BuildDescription.get(Description.DETAIL_DESCRIPTION, article.getTitle(), article.getMemberId(), article.getDescript()));
		historyBiz.addHistory(historyVO);
		
		
		request.setAttribute("article", article);
		request.setAttribute("isExistsFavoriteData", isExistsFavoriteData);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/detail.jsp");
		rd.forward(request, response);
	}

}
