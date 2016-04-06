package com.ktds.muco.table.reportedPlace.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.member.dao.Const;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.table.reportedPlace.vo.ReportedPlaceSearchVO;
import com.ktds.muco.table.reportedPlace.vo.ReportedPlaceVO;
import com.ktds.muco.util.xml.XML;

/**
 * 
 * @author 김광민
 *
 */
public class ReportedPlaceDAO {

	/**
	 * 신고된 place list 카운트 받아오기
	 * @return
	 */
	public int getAllReportedPlaceCount() {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/reportedPlace/getAllReportedPlaceCount/text()");
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();

			int ReportedPlaceCount = 0;
			
			if ( rs.next() ) {
				ReportedPlaceCount = rs.getInt(1);
			}
			return ReportedPlaceCount;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}
	
	public List<ReportedPlaceVO> getAllReportedPlaces(ReportedPlaceSearchVO reportedPlaceSearchVO) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<ReportedPlaceVO> reportedPlaces = new ArrayList<ReportedPlaceVO>();

		try {

			ReportedPlaceVO reportedPlaceVO = null;
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			// article을 꺼내온다.
			String query = XML.getNodeString("//query/reportedPlace/getAllReportedPlaces/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, reportedPlaceSearchVO.getEndIndex());
			stmt.setInt(2, reportedPlaceSearchVO.getStartIndex());
					
			rs = stmt.executeQuery();

			while (rs.next()) {
				reportedPlaceVO = new ReportedPlaceVO();
				
				reportedPlaceVO.setReportedId(rs.getInt("REPORT_ID"));
				reportedPlaceVO.setEmail(rs.getString("EMAIL"));
				reportedPlaceVO.setPlaceId(rs.getInt("PLACE_ID"));
				reportedPlaceVO.setReportedDate(rs.getString("REPORT_DT"));
				reportedPlaceVO.setCategory(rs.getString("CATEGORY"));
				reportedPlaceVO.setDescription(rs.getString("DESCRIPTION"));
				
				reportedPlaces.add(reportedPlaceVO);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);

		} finally {
			closeDB(conn, stmt, rs);
		}

		return reportedPlaces;
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
