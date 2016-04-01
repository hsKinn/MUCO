package com.ktds.muco.table.pack.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.pack.biz.PackBiz;
import com.ktds.muco.table.pack.vo.PackListVO;
import com.ktds.muco.table.pack.vo.PackSearchVO;

/**
 * Servlet implementation class PackListServlet
 */
public class PackListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PackBiz packBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PackListServlet() {
        super();
        packBiz = new PackBiz();
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
		int pageNO = 0;
		
		try {
			pageNO = Integer.parseInt(request.getParameter("pageNO"));
		} catch (NumberFormatException nfe) {
		}
		
		PackSearchVO packSearchVO = new PackSearchVO();
		packSearchVO.setPageNO(pageNO);
		
		PackListVO packListVO = packBiz.getPackList(packSearchVO);
		
		request.setAttribute("packs", packListVO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/pack/packList.jsp");
		rd.forward(request, response);
	}

}