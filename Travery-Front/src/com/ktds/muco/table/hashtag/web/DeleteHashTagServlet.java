package com.ktds.muco.table.hashtag.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.hashtag.dao.HashTagDAO;
import com.ktds.muco.util.file.MultipartHttpServletRequest;

/**
 * Servlet implementation class DeleteHashTagServlet
 */
public class DeleteHashTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashTagDAO hashTagDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteHashTagServlet() {
        super();
        hashTagDAO = new HashTagDAO();
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
		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);
		int packId = Integer.parseInt(multipartRequest.getParameter("curpackId"));
		
		int deleteCount = hashTagDAO.deleteAllHashTagByPackId(packId);
		
		response.sendRedirect("/detailPack");
	}

}
