package com.ktds.muco.table.country.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.country.dao.CountryDAO;
import com.ktds.muco.table.country.vo.CountryVO;
import com.ktds.muco.table.member.vo.MemberVO;

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
	 * 
	 * 해당 나라가 DB에 존재하는지 확인 후 있으면 해당 country info 반환
	 * 
	 * @param request
	 * @return
	 * @author 김광민
	 */
	public CountryVO getCountryInfoByCountryName(HttpServletRequest request) {

		String selectedCountryName = request.getParameter("selectedCountryName");
		CountryVO countryVO = countryDAO.getCountryInfoByCountryName(selectedCountryName);

		System.out.println("Biz : " + selectedCountryName);
		
		// 선택한 나라명과 일치하는 나라가 존재하면
		if ( countryVO != null ) {
			
			HttpSession session = request.getSession();
			MemberVO memberVO = (MemberVO) session.getAttribute("_MEMBER_");
			memberVO.addSelectedCountry(countryVO);
			session.setAttribute("_MEMBER_", memberVO);
			
			return countryVO;
		}

		return null;
	}
}
