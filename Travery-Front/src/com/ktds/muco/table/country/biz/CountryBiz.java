package com.ktds.muco.table.country.biz;

import com.ktds.muco.table.country.dao.CountryDAO;
import com.ktds.muco.table.country.vo.CountryVO;

/**
 * 
 * @author 김광민
 *
 */
public class CountryBiz {
	
	private CountryDAO countryDAO;
	
	public CountryBiz() {
		countryDAO = new CountryDAO();
	}

	public CountryVO getCountryList(String checkCountry) {
		CountryVO countryVO = new CountryVO();
		countryVO = countryDAO.getCountryList(checkCountry);
		return countryVO;
	}

}
