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
 * Servlet implementation class DoModifyPackServlet
 */
public class DoModifyPackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PackBiz packBiz;
	private FileBiz fileBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoModifyPackServlet() {
        super();
        packBiz = new PackBiz();
        fileBiz = new FileBiz();
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

		
		String title = multipartRequest.getParameter("packData_Title");
		int packId = Integer.parseInt(multipartRequest.getParameter("curpackId"));
		String isPublic =(String)multipartRequest.getParameter("packData_IsPublic");
		//String tag = multipartRequest.getParameter("tag");
		MultipartFile file = multipartRequest.getFile("file");

		int intIsPublic = 0;
		
		System.out.println("servlet title :" +title +"packid : "+packId);
		System.out.println("isPublic :" +isPublic );
		if(isPublic != null && isPublic.equals("1")){
			System.out.println("공유");
			intIsPublic = 1;
		}else{
			System.out.println("비공유");
		}
		
		PackVO modifyPack = new PackVO();
		modifyPack.setPackTitle(title);
		modifyPack.setPackId(packId);
		modifyPack.setIsPublic(intIsPublic);

		int modifyCount = packBiz.modifyPack(modifyPack);
		
		System.out.println("modyyyyCount"+modifyCount);

		if (file != null && file.getFileName().length() >0) {
			// file이 null이면 파일을 업로드 안한것
			File upFile = file.write("D:\\travery\\" + file.getFileName());			
			fileBiz.uploadPackImgFile(packId, upFile);
		}

		response.sendRedirect("/detailPack");
	}

}
