package com.ktds.muco.table.reserve.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.member.dao.Const;
import com.ktds.muco.table.reserve.vo.ReserveSearchVO;
import com.ktds.muco.table.reserve.vo.ReserveVO;
import com.ktds.muco.util.xml.XML;

/**
 * 
 * @author 김광민
 *
 */
public class ReserveDAO {
	
	
	
	public int getAllReserveListCount() {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/reserve/getReserveCount/text()");
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();

			int reserveCount = 0;
			
			if ( rs.next() ) {
				reserveCount = rs.getInt(1);
			}
			return reserveCount;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	public List<ReserveVO> getAllReservation(ReserveSearchVO reserveSearchVO, int sortOption) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<ReserveVO> reserves = new ArrayList<ReserveVO>();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/reserve/getAllReservation/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, reserveSearchVO.getEndIndex());
			stmt.setInt(2, reserveSearchVO.getStartIndex());

			rs = stmt.executeQuery();

			ReserveVO reserveVO = null;

			while (rs.next()) {
				reserveVO = new ReserveVO();
				
				reserveVO.setReserveId(rs.getInt("RESERVE_ID"));
				reserveVO.setDepartDate(rs.getString("DEPART_DT"));
				reserveVO.setArriveDate(rs.getString("ARRIVE_DT"));
				reserveVO.setIsOneWay(rs.getInt("IS_ONE_WAY"));
				reserveVO.setPackId(rs.getInt("PACK_ID"));
				reserveVO.setDerpartureName(rs.getString("DEPARTURE_NAME"));
				reserveVO.setPersonCount(rs.getInt("PERSON_COUNT"));
				
				reserves.add(reserveVO);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return reserves;
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