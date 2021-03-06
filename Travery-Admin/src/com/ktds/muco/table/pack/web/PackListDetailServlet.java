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
import com.ktds.muco.table.place.vo.PlaceVO;

/**
 * Servlet implementation class PackListDetailServlet
 */
public class PackListDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PackBiz packBiz;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PackListDetailServlet() {
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
		String packId = request.getParameter("packId");
		System.out.println(packId);
		
		PackVO packVO = packBiz.getPackDataByPackId(Integer.parseInt(packId));
		System.out.println("check : 0405 " + packVO.getPackTitle());
		
		List<PlaceVO> packs = packBiz.getPlaceListByPackId(Integer.parseInt(packId));
		
		request.setAttribute("packs", packs);
		request.setAttribute("packVO", packVO);
		
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/pack/packListDetail.jsp");
	    rd.forward(request, response);
	}

}
