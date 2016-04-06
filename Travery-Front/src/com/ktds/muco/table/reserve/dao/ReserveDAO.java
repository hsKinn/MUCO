package com.ktds.muco.table.reserve.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.member.dao.Const;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.table.placeLike.vo.PlaceLikeVO;
import com.ktds.muco.table.rent.vo.RentVO;
import com.ktds.muco.table.reserve.vo.ReserveVO;
import com.ktds.muco.table.stay.vo.StayVO;
import com.ktds.muco.table.transport.vo.TransportVO;
import com.ktds.muco.util.xml.XML;

/**
 * 
 * @author 김광민
 *
 */
public class ReserveDAO {
	
	/**
	 * 예약 정보 등록
	 * @param reserveVO
	 * @return
	 * @author 유병훈
	 */
	public int getReserveId(ReserveVO reserveVO) {
		
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		int insertCount = 0;
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			String query = XML.getNodeString("//query/reserve/addNewReserve/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, reserveVO.getPackId());
			stmt.setString(2, reserveVO.getDepartureName());
			stmt.setInt(3, reserveVO.getPersonCount());
			stmt.setString(4, reserveVO.getDepartDate());
			stmt.setString(5, reserveVO.getArriveDate());
			
			insertCount = stmt.executeUpdate();

			if ( insertCount > 0 ) {
				
				stmt.close();
				query = XML.getNodeString("//query/reserve/getReserveId/text()");
				stmt = conn.prepareStatement(query);
				
				ResultSet rs = stmt.executeQuery();
				
				int reserveId = 0;
				
				if (rs.next()) {
					reserveId = rs.getInt(1);
				}
				rs.close();
				
				return reserveId;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		
		return insertCount;
		
	}
	
	/**
	 * 예약 정보 교통 등록
	 * @param transportVO
	 * @return
	 * @author 유병훈
	 */
	public int getTransportId(TransportVO transportVO) {
		
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		int insertCount = 0;
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			String query = XML.getNodeString("//query/reserve/addNewReserveTransport/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setString(1, transportVO.getTransportClass());
			
			
			insertCount = stmt.executeUpdate();

			if ( insertCount > 0 ) {
				
				stmt.close();
				query = XML.getNodeString("//query/reserve/getTransportId/text()");
				stmt = conn.prepareStatement(query);
				
				ResultSet rs = stmt.executeQuery();
				
				int transportId = 0;
				
				if (rs.next()) {
					transportId = rs.getInt(1);
				}
				rs.close();
				
				return transportId;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		
		return insertCount;
	}
	
	
	/**
	 * 예약 정보 숙박 등록
	 * @param stayVO
	 * @return
	 * @author 유병훈
	 */
	public int getStayId(StayVO stayVO) {
		
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		int insertCount = 0;
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			String query = XML.getNodeString("//query/reserve/addNewReserveStay/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setString(1, stayVO.getStayType());
			stmt.setString(2, stayVO.getStayClass());
			stmt.setInt(3, stayVO.getPersonCount());
			stmt.setString(4, stayVO.getCheckInDate());
			stmt.setString(5, stayVO.getCheckOutDate());
			
			insertCount = stmt.executeUpdate();

			if ( insertCount > 0 ) {
				
				stmt.close();
				query = XML.getNodeString("//query/reserve/getStayId/text()");
				stmt = conn.prepareStatement(query);
				
				ResultSet rs = stmt.executeQuery();
				
				int stayId = 0;
				
				if (rs.next()) {
					stayId = rs.getInt(1);
				}
				rs.close();
				
				return stayId;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		
		return insertCount;
		
	}

	/**
	 * 예약 정보 렌트 등록
	 * @param rentVO
	 * @return
	 * @author 유병훈
	 */
	public int getRentId(RentVO rentVO) {
		
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		int insertCount = 0;
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			String query = XML.getNodeString("//query/reserve/addNewReserveRent/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setString(1, rentVO.getRentType());
			stmt.setString(2, rentVO.getRentStartDate());
			stmt.setString(3, rentVO.getRentEndDate());
			stmt.setInt(4, rentVO.getPersonCount());
			
			insertCount = stmt.executeUpdate();

			if ( insertCount > 0 ) {
				
				stmt.close();
				query = XML.getNodeString("//query/reserve/getRentId/text()");
				stmt = conn.prepareStatement(query);
				
				ResultSet rs = stmt.executeQuery();
				
				int rentId = 0;
				
				if (rs.next()) {
					rentId = rs.getInt(1);
				}
				rs.close();
				
				return rentId;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		
		return insertCount;
		
	}
	
	/**
	 * reserveTransport 해소 테이블 입력
	 * @param reserveId
	 * @param transportId
	 * @return
	 * @author 유병훈
	 */
	public int getReserveTransport(int reserveId, int transportId) {
		
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;


		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			String query = XML.getNodeString("//query/reserve/getReserveTransport/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, reserveId);
			stmt.setInt(2, transportId);

			return stmt.executeUpdate();
			

			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		
	}
	
	/**
	 * reserveStay 해소 테이블 입력
	 * @param reserveId
	 * @param stayId
	 * @return
	 * @author 유병훈
	 */
	public int getReserveStay(int reserveId, int stayId) {
		
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;


		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			String query = XML.getNodeString("//query/reserve/getReserveStay/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, reserveId);
			stmt.setInt(2, stayId);

			return stmt.executeUpdate();
			

			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		
	}
	
	/**
	 * reserveRent 해소 테이블 입력
	 * @param reserveId
	 * @param rentId
	 * @return
	 * @author 유병훈
	 */
	public int getReserveRent(int reserveId, int rentId) {

		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;


		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			String query = XML.getNodeString("//query/reserve/getReserveRent/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, reserveId);
			stmt.setInt(2, rentId);

			return stmt.executeUpdate();
			

			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		
	}
	
	public ReserveVO getReserveInfo(String email) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/reserve/getReserveInfo/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, email);

			rs = stmt.executeQuery();

			ReserveVO reserveVO = null;

			if (rs.next()) {

				reserveVO = new ReserveVO();

				reserveVO.setPackId(rs.getInt("PACK_ID"));
				reserveVO.setPackTitle(rs.getString("PACK_TITLE"));
				reserveVO.setReserveId(rs.getInt("RESERVE_ID"));
				reserveVO.setDepartureName(rs.getString("DEPARTURE_NAME"));
				reserveVO.setPersonCount(rs.getInt("PERSON_COUNT"));
				reserveVO.setDepartDate(rs.getString("DEPART_DT"));
				reserveVO.setArriveDate(rs.getString("ARRIVE_DT"));

			}

			return reserveVO;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}
	
	
	public TransportVO getTransportInfo(String email) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/reserve/getTransportInfo/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, email);

			rs = stmt.executeQuery();

			TransportVO transportVO = null;

			if (rs.next()) {

				transportVO = new TransportVO();

				transportVO.setTransportClass(rs.getString("TRANSPORT_CLASS"));

			}

			return transportVO;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}
	
	
	public StayVO getStayInfo(String email) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/reserve/getStayInfo/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, email);

			rs = stmt.executeQuery();

			StayVO stayVO = null;

			if (rs.next()) {

				stayVO = new StayVO();

				stayVO.setStayType(rs.getString("STAY_TYPE"));
				stayVO.setStayClass(rs.getString("STAY_CLASS"));
				stayVO.setPersonCount(rs.getInt("PERSON_COUNT"));
				stayVO.setCheckInDate(rs.getString("CHECK_IN_DT"));
				stayVO.setCheckOutDate(rs.getString("CHECK_OUT_DT"));

			}

			return stayVO;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}
	
	
	public RentVO getRentInfo(String email) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/reserve/getRentInfo/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, email);

			rs = stmt.executeQuery();

			RentVO rentVO = null;

			if (rs.next()) {

				rentVO = new RentVO();

				rentVO.setRentType(rs.getString("RENT_TYPE"));
				rentVO.setPersonCount(rs.getInt("PERSON_COUNT"));
				rentVO.setRentStartDate(rs.getString("RENT_START_DT"));
				rentVO.setRentEndDate(rs.getString("RENT_END_DT"));

			}

			return rentVO;

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
