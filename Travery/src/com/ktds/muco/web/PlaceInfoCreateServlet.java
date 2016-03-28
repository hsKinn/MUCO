package com.ktds.muco.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.biz.ImageBiz;
import com.ktds.muco.biz.RecommendPlaceBiz;
import com.ktds.muco.vo.MemberVO;
import com.ktds.muco.vo.PlaceVO;
import com.ktds.muco.web.MultipartHttpServletRequest.MultipartFile;

/**
 * Servlet implementation class PlaceInfoCreateServlet
 */
public class PlaceInfoCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecommendPlaceBiz rpbiz;
	private ImageBiz ibiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceInfoCreateServlet() {
        super();
        rpbiz = new RecommendPlaceBiz();
        ibiz= new ImageBiz();
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
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);
		
		PlaceVO placeVO = new PlaceVO();
		
		String latitude = request.getParameter("lat");
		String longitude = request.getParameter("lng");
		String address = request.getParameter("address");
		
		String placeName = multipartRequest.getParameter("placeName");
		String description = multipartRequest.getParameter("description");
		MultipartFile image = multipartRequest.getFile("image");

		placeVO.setLatitude(Double.parseDouble(latitude));
		placeVO.setLongitude(Double.parseDouble(longitude));
		placeVO.setAddress(address);
		placeVO.setPlaceName(placeName);
		placeVO.setDescription(description);
		placeVO.setMemberId(member.getMemberId());
		
		int placeId = rpbiz.placeInfoCreate(placeVO);
			
		if ( image.getFileSize() > 0) {
			ibiz.insertFileToss(multipartRequest, placeId);
		}
		try {
			response.sendRedirect("/recommendPlace");
			}
		catch ( RuntimeException re ) {
			System.out.println(re.getMessage());
			response.sendRedirect("/recommendPlace?placeId=" + placeId);
		}
		return;
	}
}
