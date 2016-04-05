package com.ktds.muco.table.reportedPlace.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.muco.table.member.dao.Const;
import com.ktds.muco.table.reportedPlace.vo.ReportedPlaceVO;
import com.ktds.muco.util.xml.XML;

/**
 * 
 * @author 김현섭
 *
 */
public class ReportedPlaceDAO {

	/**
	 * Set Report Place
	 * 
	 * @author 김현섭
	 * 
	 * @param reportPlace
	 * @return
	 */
	public int setReportPlace(ReportedPlaceVO reportPlace) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/reportedPlace/setReportPlace/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setString(1, reportPlace.getEmail());
			stmt.setInt(2, reportPlace.getPlaceId());
			stmt.setString(3, reportPlace.getCategory());
			stmt.setString(4, reportPlace.getReportDescription());
			
			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	} // setReportPlace END
	
	
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
