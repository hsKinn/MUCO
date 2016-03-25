package com.ktds.muco.table.pack.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.pack.biz.SharePackBiz;
import com.ktds.muco.table.pack.vo.PackListVO;
import com.ktds.muco.table.pack.vo.PackSearchVO;

/**
 * 
 * Servlet implementation class SharePackServlet
 * 
 * @author 김광민
 * 
 */
public class SharePackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SharePackBiz sharePackBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SharePackServlet() {
        super();
        
        sharePackBiz = new SharePackBiz();
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
		PackSearchVO packSearchVO = new PackSearchVO();
		HttpSession session = request.getSession();
		
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			packSearchVO.setPageNo(pageNo);
			packSearchVO.setSearchKeyword(request.getParameter("searchKeyword"));
		}
		catch(NumberFormatException nfe) {
			
			packSearchVO = (PackSearchVO) session.getAttribute("_SEARCH_");
			
			if ( packSearchVO == null ) {
				packSearchVO = new PackSearchVO();
				packSearchVO.setPageNo(0);
				packSearchVO.setSearchKeyword("");
			}			
		}
		
		session.setAttribute("_SEARCH_", packSearchVO);
		
		PackListVO packages = sharePackBiz.getAllPackageList(packSearchVO);
		
		request.setAttribute("packages", packages);
		request.setAttribute("packSearchVO", packSearchVO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/pack/sharePack.jsp");
		rd.forward(request, response);
	}

}
