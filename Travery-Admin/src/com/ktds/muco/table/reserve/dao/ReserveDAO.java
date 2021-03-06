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
	
	
	
	public int getAllReserveListCount(ReserveSearchVO reserveSearchVO) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			if(reserveSearchVO.getSearchList().equals("email")) {
				query = XML.getNodeString("//query/reserve/getReserveCountSearchedByEmail/text()");
				stmt = conn.prepareStatement(query);
				stmt.setString(1, reserveSearchVO.getSearchKeyword());
			}
			else if (reserveSearchVO.getSearchList().equals("packId")) {
				query = XML.getNodeString("//query/reserve/getReserveCountSearchedByPackId/text()");
				stmt = conn.prepareStatement(query);
				stmt.setString(1, reserveSearchVO.getSearchKeyword());
			}
			else if (reserveSearchVO.getSearchList().equals("departureName")) {
				query = XML.getNodeString("//query/reserve/getReserveCountSearchedByDepartureName/text()");
				stmt = conn.prepareStatement(query);
				stmt.setString(1, reserveSearchVO.getSearchKeyword());
			}
			else  {
				query = XML.getNodeString("//query/reserve/getReserveCount/text()");
				stmt = conn.prepareStatement(query);
			}
			
			
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
			String query = "";
			//예약ID
			if( sortOption==1 ) {
				if(reserveSearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/reserve/getAllReservationOrderByReserveIdSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, reserveSearchVO.getSearchKeyword());
					stmt.setInt(2, reserveSearchVO.getEndIndex());
					stmt.setInt(3, reserveSearchVO.getStartIndex());
				}
				else if (reserveSearchVO.getSearchList().equals("packId")) {
					query = XML.getNodeString("//query/reserve/getAllReservationOrderByReserveIdSearchedByPackId/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, reserveSearchVO.getSearchKeyword());
					stmt.setInt(2, reserveSearchVO.getEndIndex());
					stmt.setInt(3, reserveSearchVO.getStartIndex());
				}
				else if (reserveSearchVO.getSearchList().equals("departureName")) {
					query = XML.getNodeString("//query/reserve/getAllReservationOrderByReserveIdSearchedByDepartureName/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, reserveSearchVO.getSearchKeyword());
					stmt.setInt(2, reserveSearchVO.getEndIndex());
					stmt.setInt(3, reserveSearchVO.getStartIndex());
				}
				else  {
					query = XML.getNodeString("//query/reserve/getAllReservationOrderByReserveId/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, reserveSearchVO.getEndIndex());
					stmt.setInt(2, reserveSearchVO.getStartIndex());
				}
			}
			//예약 Email
			else if (sortOption==2) {
				if(reserveSearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/reserve/getAllReservationOrderByEmailSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, reserveSearchVO.getSearchKeyword());
					stmt.setInt(2, reserveSearchVO.getEndIndex());
					stmt.setInt(3, reserveSearchVO.getStartIndex());
				}
				else if (reserveSearchVO.getSearchList().equals("packId")) {
					query = XML.getNodeString("//query/reserve/getAllReservationOrderByEmailSearchedByPhoneNumber/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, reserveSearchVO.getSearchKeyword());
					stmt.setInt(2, reserveSearchVO.getEndIndex());
					stmt.setInt(3, reserveSearchVO.getStartIndex());
				}
				else if (reserveSearchVO.getSearchList().equals("departureName")) {
					query = XML.getNodeString("//query/reserve/getAllReservationOrderByEmailSearchedByDepartureName/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, reserveSearchVO.getSearchKeyword());
					stmt.setInt(2, reserveSearchVO.getEndIndex());
					stmt.setInt(3, reserveSearchVO.getStartIndex());
				}
				else  {
					query = XML.getNodeString("//query/reserve/getAllReservationOrderByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, reserveSearchVO.getEndIndex());
					stmt.setInt(2, reserveSearchVO.getStartIndex());
				}
			}
			//패키지Id 
			else if (sortOption==3) {
				if(reserveSearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/reserve/getAllReservationOrderByPackIdSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, reserveSearchVO.getSearchKeyword());
					stmt.setInt(2, reserveSearchVO.getEndIndex());
					stmt.setInt(3, reserveSearchVO.getStartIndex());
				}
				else if (reserveSearchVO.getSearchList().equals("packId")) {
					query = XML.getNodeString("//query/reserve/getAllReservationOrderByPackIdSearchedByPackId/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, reserveSearchVO.getSearchKeyword());
					stmt.setInt(2, reserveSearchVO.getEndIndex());
					stmt.setInt(3, reserveSearchVO.getStartIndex());
				}
				else if (reserveSearchVO.getSearchList().equals("departureName")) {
					query = XML.getNodeString("//query/reserve/getAllReservationOrderByPackIdSearchedByDepartureName/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, reserveSearchVO.getSearchKeyword());
					stmt.setInt(2, reserveSearchVO.getEndIndex());
					stmt.setInt(3, reserveSearchVO.getStartIndex());
				}
				else  {
					query = XML.getNodeString("//query/reserve/getAllReservationOrderByPackId/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, reserveSearchVO.getEndIndex());
					stmt.setInt(2, reserveSearchVO.getStartIndex());
				}
			}
			//동행수
			else if (sortOption==4) {
				if(reserveSearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/reserve/getAllReservationOrderByPersonCountSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, reserveSearchVO.getSearchKeyword());
					stmt.setInt(2, reserveSearchVO.getEndIndex());
					stmt.setInt(3, reserveSearchVO.getStartIndex());
				}
				else if (reserveSearchVO.getSearchList().equals("packId")) {
					query = XML.getNodeString("//query/reserve/getAllReservationOrderByPersonCountSearchedByPackId/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, reserveSearchVO.getSearchKeyword());
					stmt.setInt(2, reserveSearchVO.getEndIndex());
					stmt.setInt(3, reserveSearchVO.getStartIndex());
				}
				else if (reserveSearchVO.getSearchList().equals("departureName")) {
					query = XML.getNodeString("//query/reserve/getAllReservationOrderByPersonCountSearchedByDepartureName/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, reserveSearchVO.getSearchKeyword());
					stmt.setInt(2, reserveSearchVO.getEndIndex());
					stmt.setInt(3, reserveSearchVO.getStartIndex());
				}
				else  {
					query = XML.getNodeString("//query/reserve/getAllReservationOrderByPersonCount/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, reserveSearchVO.getEndIndex());
					stmt.setInt(2, reserveSearchVO.getStartIndex());
				}
			}
			else {
				if(reserveSearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/reserve/getAllReservationSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, reserveSearchVO.getSearchKeyword());
					stmt.setInt(2, reserveSearchVO.getEndIndex());
					stmt.setInt(3, reserveSearchVO.getStartIndex());
				}
				else if (reserveSearchVO.getSearchList().equals("phoneNumber")) {
					query = XML.getNodeString("//query/reserve/getAllReservationSearchedByPhoneNumber/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, reserveSearchVO.getSearchKeyword());
					stmt.setInt(2, reserveSearchVO.getEndIndex());
					stmt.setInt(3, reserveSearchVO.getStartIndex());
				}
				else if (reserveSearchVO.getSearchList().equals("name")) {
					query = XML.getNodeString("//query/reserve/getAllReservationSearchedByName/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, reserveSearchVO.getSearchKeyword());
					stmt.setInt(2, reserveSearchVO.getEndIndex());
					stmt.setInt(3, reserveSearchVO.getStartIndex());
				}
				else  {
					query = XML.getNodeString("//query/reserve/getAllReservation/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, reserveSearchVO.getEndIndex());
					stmt.setInt(2, reserveSearchVO.getStartIndex());
				}
			}

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
