/**
 * @author 이기연
 */

package com.ktds.muco.table.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.util.file.DownloadUtil;

/**
 * Servlet implementation class ProfileImgDownload
 */
public class ProfileImgDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileImgDownload() {
        super();
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
		
		//1. 세션정보
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("_MEMBER_");
		
		DownloadUtil downloadUtil = DownloadUtil.getInstance("D:\\");
		downloadUtil.download(request, response,   memberVO.getMainImageName(), memberVO.getMainImageName());
	
	}

}
