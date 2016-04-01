package com.ktds.muco.table.pack.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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
		MultipartFile file = multipartRequest.getFile("image");
		String isPublic =(String)multipartRequest.getParameter("packData_IsPublic");
		String hashtags = multipartRequest.getParameter("texthashtag");
		
		System.out.println("tag:"+hashtags);


		//		String[] tags =null;
//		if (request.getParameterValues("hashtag") != null){
//			tags  = request.getParameterValues("hashtag");
//		}
//		for (String tag : tags) {
//			System.out.println(tag);
//		}
		
		/*loginMember 처리부*/
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
		
		/*isPublic 처리부*/
		int intIsPublic = 0;
		System.out.println("isPublic :" +isPublic );
		if(isPublic != null && isPublic.equals("1")){
			System.out.println("공유");
			intIsPublic = 1;
		}else{
			System.out.println("비공유");
		}
		
		/*new package 생성부*/
		PackVO newAddPack = new PackVO();
		newAddPack.setEmail(loginMember.getEmail());
		newAddPack.setPackTitle(title);
		newAddPack.setIsPublic(intIsPublic);
		int packId = packBiz.addPack(newAddPack);

		/*file 처리부*/
		File upFile = null;		
		if (file != null && file.getFileName().length() >0) {
			// file이 null이면 파일을 업로드 안한것
			upFile = file.write("D:\\travery\\" + file.getFileName());			
			fileBiz.uploadPackImgFile(packId, upFile);
		}else{
			upFile = file.write("D:\\travery\\basic1.jpg");
			fileBiz.uploadPackImgFile(packId, upFile);
		}
		
		/*hashTag 처리부*/
		if ( hashtags != null && hashtags.length()>0 ){
			int addHashTagCount = 0;
			addHashTagCount = packBiz.addHashTagInPack(packId, hashtags);
		}
		response.sendRedirect("/addPack");
	}

}
