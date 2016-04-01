package com.ktds.muco.table.pack.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.file.biz.FileBiz;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.pack.biz.PackBiz;
import com.ktds.muco.table.pack.vo.PackVO;
import com.ktds.muco.util.file.MultipartFile;
import com.ktds.muco.util.file.MultipartHttpServletRequest;

/**
 * Servlet implementation class DoAddServlet
 */
public class DoAddPackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PackBiz packBiz;
	private FileBiz fileBiz;

	public DoAddPackServlet() {
		super();
		packBiz = new PackBiz();
		fileBiz = new FileBiz();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);

		String title = multipartRequest.getParameter("title");
		// String tag = multipartRequest.getParameter("tag");
		MultipartFile file = multipartRequest.getFile("file");

		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");

		PackVO newAddPack = new PackVO();
		newAddPack.setEmail(loginMember.getEmail());
		newAddPack.setPackTitle(title);

		int packId = packBiz.addPack(newAddPack);

		if (file != null && file.getFileName().length() > 0) {
			// file이 null이면 파일을 업로드 안한것
			File upFile = file.write("D:\\" + file.getFileName());
			fileBiz.uploadPackImgFile(packId, upFile);
		}

		response.sendRedirect("/myPack");
	}

}