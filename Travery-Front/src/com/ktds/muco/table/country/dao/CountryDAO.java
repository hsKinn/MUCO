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
	
	
	public CountryVO getCountryList(String checkCountry) {
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		CountryVO countryVO = null;
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			String query = XML.getNodeString("//query/country/getCountryList/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, checkCountry);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				countryVO = new CountryVO();
				countryVO.setCountryId(rs.getInt("COUNTRY_ID"));
				countryVO.setCountryName(rs.getString("COUNTRY_NAME"));
				countryVO.setCountryColor(rs.getString("COUNTRY_COLOR"));
				countryVO.setCountryFontColor(rs.getString("COUNTRY_FONT_COLOR"));
				
				
			}
			return countryVO;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		finally {
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
