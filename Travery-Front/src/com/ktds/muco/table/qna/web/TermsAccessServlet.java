package com.ktds.muco.table.qna.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.qna.biz.QNABiz;
import com.ktds.muco.table.qna.vo.QNAListVO;
import com.ktds.muco.table.qna.vo.QNASearchVO;

/**
 * Servlet implementation class TermsAccessServlet
 */
public class TermsAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private QNABiz qnaBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TermsAccessServlet() {
        super();
        qnaBiz = new QNABiz();
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
		QNASearchVO searchVO = new QNASearchVO();
		HttpSession session = request.getSession();
		
		int menuNo = Integer.parseInt(request.getParameter("menuNo"));
		
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			searchVO.setPageNo(pageNo);
			searchVO.setSearchKeyword(request.getParameter("searchKeyword"));
			searchVO.setSearchType(request.getParameter("searchType"));
		}
		catch(NumberFormatException nfe){
			searchVO = (QNASearchVO) session.getAttribute("_SEARCH_");
			if ( searchVO == null ) {
				searchVO = new QNASearchVO();
				searchVO.setPageNo(0);
				searchVO.setSearchKeyword("");
				searchVO.setSearchType("1");
			}
		}
		
		session.setAttribute("_SEARCH_", searchVO);
		
		
		QNAListVO faqs = qnaBiz.getFAQList(searchVO);

		
		request.setAttribute("menuNo", menuNo);
		request.setAttribute("searchVO", searchVO);
		request.setAttribute("faqs", faqs);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/common/termsAccess.jsp");
		rd.forward(request, response);
		
	}

}
