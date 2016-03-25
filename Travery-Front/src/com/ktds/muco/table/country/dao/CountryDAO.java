package com.ktds.muco.table.country.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.muco.table.country.vo.CountryVO;
import com.ktds.muco.table.member.dao.Const;
import com.ktds.muco.util.xml.XML;

/**
 * 
 * @author 김광민
 *
 */
public class CountryDAO {
	
	/**
	 * 나라 이름으로 해당 나라가 존재하는지 확인 후 있으면 나라 VO 반환
	 * 
	 * @param selectedCountry
	 * @return
	 * @author 김광민
	 */
	public CountryVO getCountryByCountryName(String selectedCountry) {
		
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/country/getCountryByCountryName/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, selectedCountry);
			rs = stmt.executeQuery();

			CountryVO countryVO = null;

			if (rs.next()) {

				countryVO = new CountryVO();

				countryVO.setCountryId(rs.getInt("COUNTRY_ID"));
				countryVO.setCountryName(rs.getString("COUNTRY_NAME"));
				countryVO.setCountryColor(rs.getString("COUNTRY_COLOR"));
				countryVO.setCountryFontColor(rs.getString("COUNTRY_FONT_COLOR"));
			}
			return countryVO;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		
	}
	
	/**
	 * 
	 * Load Oracle Driver
	 * 
	 * @author 김광민
	 * 
	 */
	private void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * 
	 * Close DB
	 * 
	 * @author 김광민
	 * 
	 */
	private void closeDB(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if ( rs != null ) {
			try {
				rs.close();
			} catch (SQLException e) {}
		}
		if ( stmt != null ) {
			try {
				stmt.close();
			} catch (SQLException e) {}
		}
		if ( conn != null ) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}

}
