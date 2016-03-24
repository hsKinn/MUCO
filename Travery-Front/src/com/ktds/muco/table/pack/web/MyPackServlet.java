package com.ktds.muco.table.pack.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.pack.biz.PackBiz;
import com.ktds.muco.table.pack.vo.PackVO;

/**
 * 
 * Servlet implementation class MyListServlet
 * 
 * @author 김광민
 * 
 */
public class MyPackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PackBiz packBiz;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPackServlet() {
        super();
        packBiz = new PackBiz();
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
		String email="1";
		List<PackVO> packs = packBiz.getPackListByEmail(email);
		
		request.setAttribute("packs", packs);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/pack/myPack.jsp");
		rd.forward(request, response);
	}

}
