package com.ktds.muco.table.standard.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.member.biz.MemberBiz;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class SelectedStandardServelt
 */
public class SelectedStandardServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz memberBiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectedStandardServelt() {
		super();
		memberBiz = new MemberBiz();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isChangedStandard = memberBiz.selectedStandard(request);

		if(isChangedStandard) {
			response.sendRedirect(Root.get(this) + "/hitTheRoad");
		}
		else {
			response.sendRedirect(Root.get(this) + "/hitTheRoad");
		}
	}

}
