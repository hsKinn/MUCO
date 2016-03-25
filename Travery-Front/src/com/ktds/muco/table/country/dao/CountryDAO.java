package com.ktds.muco.table.country.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.country.vo.CountryVO;
import com.ktds.muco.table.member.dao.Const;
import com.ktds.muco.util.xml.XML;

/**
 * 
 * Country DAO
 * 
 * @author 김광민
 *
 */
public class CountryDAO {

	/**
	 * 모든 나라 정보 받기
	 * 
	 * @return
	 * @author 김광민
	 */
	public List<CountryVO> getCountryList() {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<CountryVO> countryList = new ArrayList<CountryVO>();

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/country/getCountryList/text()");
			stmt = conn.prepareStatement(query);

			rs = stmt.executeQuery();

			CountryVO countryVO = null;

			while (rs.next()) {

				countryVO = new CountryVO();

				countryVO.setCountryId(rs.getInt("COUNTRY_ID"));
				countryVO.setCountryName(rs.getString("COUNTRY_NAME"));
				countryVO.setCountryColor(rs.getString("COUNTRY_COLOR"));
				countryVO.setCountryFontColor(rs.getString("COUNTRY_FONT_COLOR"));

				countryList.add(countryVO);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}

		return countryList;

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
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
