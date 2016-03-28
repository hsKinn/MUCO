package com.ktds.muco.table.pack.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.pack.biz.PackBiz;
import com.ktds.muco.util.root.Root;

public class DoDeletePackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PackBiz packBiz;

	public DoDeletePackServlet() {
		super();
		packBiz = new PackBiz();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] deletePackIds = request.getParameterValues("deletePackId");
		for (String string : deletePackIds) {
			System.out.println(string);
		}

		int deleteCount = 0;
		deleteCount = packBiz.deletePacks(deletePackIds);
		response.sendRedirect(Root.get(this) + "/myPack");
	}

}
