package com.ktds.muco.table.country.biz;

import java.util.List;

import com.ktds.muco.table.country.dao.CountryDAO;
import com.ktds.muco.table.country.vo.CountryVO;

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
	 * 모든 나라 정보 받기
	 * 
	 * @return
	 * @author 김광민
	 */
	public List<CountryVO> getCountryList() {
		
		return countryDAO.getCountryList();
		
	}
}
