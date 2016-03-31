package com.ktds.muco.table.country.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.country.dao.CountryDAO;
import com.ktds.muco.table.country.vo.CountryVO;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.dao.PlaceDAO;
import com.ktds.muco.table.place.vo.PlaceVO;

/**
 * 
 * Country DAO
 * 
 * @author 김광민
 *
 */
public class CountryBiz {

	private CountryDAO countryDAO;
	private PlaceDAO placeDAO;

	public CountryBiz() {
		countryDAO = new CountryDAO();
		placeDAO = new PlaceDAO();
	}

	/**
	 * 
	 * 해당 나라가 DB에 존재하는지 확인 후 있으면 해당 country info 반환
	 * 
	 * @param request
	 * @return
	 * @author 김광민
	 */
	public boolean getCountryInfoByCountryName(HttpServletRequest request) {

		String selectedCountryName = request.getParameter("selectedCountryName");
		
		// CountryVO 에 나라정보 등록
		CountryVO countryVO = countryDAO.getCountryInfoByCountryName(selectedCountryName);
		
		if(countryVO != null) {
			
			int countryId = 0;
			countryId = countryVO.getCountryId();
			
			// CountryVO 에 여행지 리스트 등록
			if( countryId != 0 ) {
				List<PlaceVO> placeList = placeDAO.getPlaceListByCountryId(countryId);
				if(placeList != null) {
					countryVO.setPlaceList(placeList);
				}
			}
		}
			
		
		// 선택한 나라명과 일치하는 나라가 존재하면
		if (countryVO != null) {

			HttpSession session = request.getSession();
			MemberVO memberVO = (MemberVO) session.getAttribute("_MEMBER_");

			// 중복 체크
			if (!memberVO.isExistCountryByCountryName(selectedCountryName)) {
				// 존재하지 않으면 추가
				if (memberVO.addSelectedCountry(countryVO)) {
					session.setAttribute("_MEMBER_", memberVO);
					return true;
				}
			} else {
				// 존재하면 제거
				if (memberVO.removeSelectedCountryByCountryName(selectedCountryName)) {
					session.setAttribute("_MEMBER_", memberVO);
				}
			}
		}
		return false;
	}
}
