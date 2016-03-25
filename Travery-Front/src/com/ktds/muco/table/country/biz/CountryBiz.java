package com.ktds.muco.table.country.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.country.dao.CountryDAO;
import com.ktds.muco.table.country.vo.CountryVO;
import com.ktds.muco.table.country.vo.SelectedCountryVO;

/**
 * 
 * Country DAO
 * 
 * @author 김광민
 *
 */
public class CountryBiz {
	
	CountryDAO countryDAO;
	
	public CountryBiz() {
		countryDAO = new CountryDAO();
	}

	/**
	 * 선택한 나라가 DB에 존재하는지 확인
	 * 
	 * 존재하면 오른쪽 선택된 나라 리스트에 출력하고
	 * 존재하지 않으면 아무일도 일어나지 않음
	 * 
	 * @param request
	 * @return
	 * @author 김광민
	 */
	public boolean getCountryByCountryName(HttpServletRequest request) {

		
		// 선택된 나라를 받는다.
		String selectedCountryName = request.getParameter("selectedCountryName");
		CountryVO countryVO = countryDAO.getCountryByCountryName(selectedCountryName);

		// 해당 나라가 DB에 존재하면
		if( countryVO != null ) {
			
			HttpSession session = request.getSession();
			
			// 세션 받아오기
			SelectedCountryVO selectedCountryVO = new SelectedCountryVO();
			SelectedCountryVO sessionSelectedCountryVO = (SelectedCountryVO) session.getAttribute("_SELECTED_COUNTRY_");
			
			// 현재 세션이 널이면 세션을 넣지 않음 
			if( sessionSelectedCountryVO != null ){
				selectedCountryVO = sessionSelectedCountryVO;
			}
			
			// 새로운 countryVO 추가
			selectedCountryVO.addSelectedCountry(countryVO);
			
			// 기존 세션 제거
			session.removeAttribute("_SELECTED_COUNTRY_");
			
			// 세션 새롭게 추가
			session.setAttribute("_SELECTED_COUNTRY_", selectedCountryVO);
			sessionSelectedCountryVO = (SelectedCountryVO) session.getAttribute("_SELECTED_COUNTRY_");
			
			return true;
		}
		
		// 추가 안됨, DB에 없음
		return	false; 
	}
}
