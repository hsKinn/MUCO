package com.ktds.muco.table.standard.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.muco.table.member.biz.MemberBiz;

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

		String firstStandard;
		String secondStandard;
		boolean isChangedStandard;

		String[] selectedStandard = memberBiz.selectedStandard(request);

		if (selectedStandard != null) {

			firstStandard = selectedStandard[0];
			secondStandard = selectedStandard[1];
			isChangedStandard = true;
		} else {

			firstStandard = null;
			secondStandard = null;
			isChangedStandard = false;
		}

		// JSON
		StringBuffer json = new StringBuffer();
		json.append("{");
		json.append("\"result\" : true");
		json.append(", \"isChangedStandard\" : " + isChangedStandard);
		json.append(", \"firstStandard\" : \"" + firstStandard + "\"");
		json.append(", \"secondStandard\" : \"" + secondStandard + "\"");
		json.append("}");

		// Print Writer
		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();

		System.out.println(json.toString());

	}

}
