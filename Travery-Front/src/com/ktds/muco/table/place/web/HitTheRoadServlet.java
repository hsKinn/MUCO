package com.ktds.muco.table.place.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.country.vo.CountryVO;
import com.ktds.muco.table.history.biz.HistoryBiz;
import com.ktds.muco.table.history.vo.ActionCode;
import com.ktds.muco.table.history.vo.BuildDescription;
import com.ktds.muco.table.history.vo.Description;
import com.ktds.muco.table.history.vo.HistoryVO;
import com.ktds.muco.table.image.biz.ImageBiz;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.pack.biz.PackBiz;
import com.ktds.muco.table.pack.vo.PackVO;
import com.ktds.muco.table.place.vo.PlaceVO;

/**
 * 
 * Servlet implementation class HitTheRoadServlet
 * 
 * @author 김광민
 * 
 */
public class HitTheRoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PackBiz packBiz;
	private ImageBiz imageBiz;
	private HistoryBiz historyBiz;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HitTheRoadServlet() {
		super();
		packBiz = new PackBiz();
		imageBiz = new ImageBiz();
		historyBiz = new HistoryBiz();
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

		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("_MEMBER_");
		
		if(memberVO != null) {
			// 나라 리스트가 존재하면
			if( !memberVO.getSelectedCountryList().isEmpty() ) {
				List<CountryVO> selectedCountryList = memberVO.getSelectedCountryList();
				request.setAttribute("selectedCountryList", selectedCountryList);
				
				List<PlaceVO> selectedAllPlaceList = new ArrayList<PlaceVO>();
				for (CountryVO selectedCountryVO : selectedCountryList) {
					// 나라의 여행지 리스트가 존재하면
					if( !selectedCountryVO.getPlaceList().isEmpty() ) {
							for (PlaceVO placeVO : selectedCountryVO.getPlaceList()) {
								selectedAllPlaceList.add(placeVO);
							}
					}
				}
				request.setAttribute("selectedAllPlaceList", selectedAllPlaceList);
			}
			
			// 여행지 리스트가 존재하면
			if( !memberVO.getTempSelectedPlaceList().isEmpty() ) {
				List<PlaceVO> tempSelectedPlaceList = memberVO.getTempSelectedPlaceList();
				request.setAttribute("tempSelectedPlaceList", tempSelectedPlaceList);	
			}
			
		}
		
		if (request.getParameter("selectedPlaceId") != null ) {
			
			int errorCodeSecond = 0;
			
			try {
				errorCodeSecond = Integer.parseInt(request.getParameter("selectedPlaceId"));
			} catch (NumberFormatException nfe) {}
			
			if( errorCodeSecond != 0 ) {
				request.setAttribute("removePlaceId", errorCodeSecond);
			}
		}
		
		// 유저가 가진 패키지들 뿌려주기
		List<PackVO> loginUserPackList = new ArrayList<PackVO>(); 
		
		if(memberVO != null){
			
			loginUserPackList = packBiz.getPackListByEmail(memberVO.getEmail());
			if(loginUserPackList != null){
				request.setAttribute("loginUserPackList", loginUserPackList);
				
			}
		}
		
		// 팩 아이디 받아서 그 안에 있는 모든 여행지들 list로 묶어서 보낸다.
		String packIdString = request.getParameter("selectedPackageId");
		
		if( packIdString != null){
			
			// History
			HistoryVO history = new HistoryVO();
			history.setIp(request.getRemoteHost());
			history.setEmail(memberVO.getEmail());
			history.setUrl(request.getRequestURI());
			history.setActionCode(ActionCode.SELECT_PACKAGE);
			history.setHistoryDescription(BuildDescription.get(Description.SELECT_PACKAGE, memberVO.getEmail(), packIdString + ""));
			historyBiz.addHistory(history);
		}
		
		int packId = packBiz.convertPackIdStringToInteger(packIdString);
		
		session = request.getSession();
		memberVO = (MemberVO) session.getAttribute("_MEMBER_");
		
		if( packId != 0 ){
			memberVO.setRecentViewPack(packId);
		}
		else {
			packId = memberVO.getRecentViewPack();
		}
		
		PackVO packVO = packBiz.getPackDataByPackId(packId);
		request.setAttribute("placeListByPackId", packVO.getPlaceList());
		
		// placeId로 여행지 대표 이미지 보냄
		String placeMainImage = imageBiz.getPlaceMainImageByPlaceId(request);
		request.setAttribute("placeMainImage", placeMainImage);
		System.out.println(placeMainImage);
		
		// History
		HistoryVO history = new HistoryVO();
		history.setIp(request.getRemoteHost());
		history.setEmail(memberVO.getEmail());
		history.setUrl(request.getRequestURI());
		history.setActionCode(ActionCode.HIT_THE_ROAD);
		history.setHistoryDescription(BuildDescription.get(Description.HIT_THE_ROAD, memberVO.getEmail()));
		historyBiz.addHistory(history);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/place/hitTheRoad.jsp");
		rd.forward(request, response);

	}
}








