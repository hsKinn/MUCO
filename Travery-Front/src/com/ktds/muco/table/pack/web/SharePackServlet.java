package com.ktds.muco.table.pack.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.pack.biz.SharePackBiz;
import com.ktds.muco.table.pack.vo.PackListVO;
import com.ktds.muco.table.pack.vo.PackSearchVO;
import com.ktds.muco.table.packLike.biz.PackLikeBiz;

/**
 * 
 * Servlet implementation class SharePackServlet
 * 
 * @author 김광민
 * 
 */
public class SharePackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	
	private SharePackBiz sharePackBiz;
    private PackLikeBiz packLikeBiz;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SharePackServlet() {
        super();
        
        sharePackBiz = new SharePackBiz();
        packLikeBiz = new PackLikeBiz();
    }
=======
>>>>>>> origin/leina_1603251225

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SharePackServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
<<<<<<< HEAD
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sortOption = 1;
		
		try {
			sortOption = Integer.parseInt(request.getParameter("sortOption"));
		}
		catch (NumberFormatException nfe) {
		}
		
		int pageNo = 0;
		PackSearchVO packSearchVO = new PackSearchVO();

		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
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
		
		PackListVO packages = sharePackBiz.getAllPackageList(packSearchVO, member, sortOption);
		
		request.setAttribute("packages", packages);
		request.setAttribute("packSearchVO", packSearchVO);
		
=======
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
>>>>>>> origin/leina_1603251225
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/pack/sharePack.jsp");
		rd.forward(request, response);
	}

}
