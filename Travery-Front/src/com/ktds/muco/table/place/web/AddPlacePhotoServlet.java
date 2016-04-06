package com.ktds.muco.table.place.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.image.biz.ImageBiz;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.util.file.MultipartFile;
import com.ktds.muco.util.file.MultipartHttpServletRequest;
import com.ktds.muco.util.root.Root;

/**
 * Servlet implementation class AddPlacePhotoServlet
 */
public class AddPlacePhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ImageBiz imageBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlacePhotoServlet() {
        super();
        
        imageBiz = new ImageBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);
		MultipartFile image = multipartRequest.getFile("image");
		
		PlaceVO place = new PlaceVO();
		place.setPlaceId( Integer.parseInt(multipartRequest.getParameter("placeId")) );
		
		if ( image.getFileName().length() > 0 ) {
			imageBiz.insertImageToss(multipartRequest, place);
			response.sendRedirect(Root.get(this) + "/detailPlace?placeId=" + place.getPlaceId());
		}
		else {
			response.sendRedirect(Root.get(this) + "/detailPlace?upload=fail&placeId=" + place.getPlaceId());
		}
	}

}
