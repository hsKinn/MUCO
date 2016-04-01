package com.ktds.muco.table.pack.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.pack.biz.PackBiz;
import com.ktds.muco.table.pack.vo.PackVO;

/**
 * Servlet implementation class PackInfoServlet
 */
public class PackInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PackBiz packBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PackInfoServlet() {
		super();
		packBiz = new PackBiz();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int packId = Integer.parseInt(request.getParameter("packId"));

		PackVO packVO = packBiz.getPackDataByPackId(packId);
		String packName = packVO.getPackTitle();
		int isPublic = packVO.getIsPublic();
		int viewCount = packVO.getViewCount();
		int likeCount = packVO.getLikeCount();				
		String imageName = packVO.getShareImageName();
		
		String hashtags = packBiz.getHashTagsByPackId(packId);
		
		System.out.println("isPublic : " + isPublic);
		
		StringBuffer json = new StringBuffer();
		json.append("{");
		json.append("\"result\" : true");
		json.append(", \"title\" : \""+packName+"\"");
		json.append(", \"isPublic\" : \""+isPublic+"\"");
		json.append(", \"viewCount\" : \""+viewCount+"\"");
		json.append(", \"likeCount\" : \""+likeCount+"\"");
		json.append(", \"imageName\" : \""+imageName+"\"");
		json.append(", \"packId\" : \""+packId+"\"");
		json.append(", \"hashtags\" : \""+hashtags+"\"");
		json.append("}");

		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();

	}

}
