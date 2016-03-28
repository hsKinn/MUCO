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
import com.ktds.cain.history.biz.OperationHistoryBiz;
import com.ktds.cain.history.vo.ActionCode;
import com.ktds.cain.history.vo.BuildDescription;
import com.ktds.cain.history.vo.Description;
import com.ktds.cain.history.vo.OperationHistoryVO;
import com.ktds.cain.member.vo.MemberVO;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticlesBiz biz;
	private OperationHistoryBiz historyBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListServlet() {
		super();
		biz = new ArticlesBiz();
		historyBiz = new OperationHistoryBiz();
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
		OperationHistoryVO historyVO = new OperationHistoryVO();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		historyVO.setIp(request.getRemoteHost());
        historyVO.setMemberId(member.getMemberId());
        historyVO.setUrl(request.getRequestURI());
        historyVO.setActionCode(ActionCode.ARTICLE);
		
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			

	         historyVO.setDescription( BuildDescription.get   (
	                                                Description.LIST_PAGING, member.getMemberId(), pageNo+""
	                                             )
	                           );
			
		}
		catch(NumberFormatException nfe) {
	         historyVO.setDescription( BuildDescription.get   (
	                                                Description.LIST, member.getMemberId()
	                                             )
	                           );
			
		}

		historyBiz.addHistory(historyVO);
		
		ArticleSearchVO searchVO = new ArticleSearchVO();
		searchVO.setPageNo(pageNo);

		ArticleListVO avo = biz.articlesList(searchVO);

		request.setAttribute("articles", avo);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/list.jsp");
		rd.forward(request, response);
	}

}