package com.ktds.muco.table.place.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.member.dao.Const;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.vo.PlaceSearchVO;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.util.xml.XML;

/**
 * 
 * @author 김광민
 *
 */
public class PlaceDAO {
	/**
	 * 
	 * placeInfoRecommendedList
	 * 
	 * @author 김동규
	 * 
	 */
	public List<PlaceVO> placeInfoRecommendedList() {
		List<PlaceVO> listPlaceVO = new ArrayList<PlaceVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PlaceVO placeVO = null;

		loadOracleDriver();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/place/placeInfoRecommendedList/text()");
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();

			while (rs.next()) {
				placeVO = new PlaceVO();
				placeVO.setPlaceId(rs.getInt("PLACE_ID"));
				placeVO.setPlaceName(rs.getString("PLACE_NAME"));
				// placeVO.set(rs.getString("START_DATE"));

				listPlaceVO.add(placeVO);
			} // if data is done finish.
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return listPlaceVO;
	}

	/**
	 * 
	 * insertPlaceInfo
	 * 
	 * @author 김동규
	 * 
	 */
	public int insertPlaceInfo(PlaceVO placeVO) {

		int placeId = 0;
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/place/insertPlaceInfo/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, placeVO.getPlaceName());
			stmt.setString(2, placeVO.getAddress());
			stmt.setDouble(3, placeVO.getLatitude());
			stmt.setDouble(4, placeVO.getLongitude());
			stmt.setString(5, placeVO.getDescription());

			placeId = stmt.executeUpdate();

			if (placeId > 0) {
				stmt.close();
				query = XML.getNodeString("//query/place/getReturnPlaceId/text()");
				stmt = conn.prepareStatement(query);

				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					placeId = rs.getInt(placeId);
				}
				return placeId;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		return placeId;

	}
	
	/** 
	 * @author 이기연
	 * @return
	 */
	public List<PlaceVO> getAllOriginPlaces(PlaceSearchVO placeSearchVO) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<PlaceVO> places = new ArrayList<PlaceVO>();

		try {

			PlaceVO placeVO = null;
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			// article을 꺼내온다.
			String query = XML.getNodeString("//query/place/getAllOriginPlaces/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, placeSearchVO.getEndIndex());
			stmt.setInt(2, placeSearchVO.getStartIndex());
					
			rs = stmt.executeQuery();

			while (rs.next()) {
				placeVO = new PlaceVO();
				placeVO.setPlaceId(rs.getInt("PLACE_ID"));
				placeVO.setPlaceName(rs.getString("PLACE_NAME"));
				placeVO.setLatitude(rs.getInt("LATITUDE"));
				placeVO.setLongitude(rs.getInt("LONGITUDE"));
				placeVO.setAddress(rs.getString("ADDRESS"));
				placeVO.setViewCount(rs.getInt("VIEW_COUNT"));
				placeVO.setLikeCount(rs.getInt("LIKE_COUNT"));
				placeVO.setDescription(rs.getString("DESCRIPTION"));
				placeVO.setIsNewPlace(rs.getInt("IS_NEW_PLACE"));
				String email = rs.getString("EMAIL");
				placeVO.setCountryId(rs.getInt("COUNTRY_ID"));
				
				MemberVO member = new MemberVO();
				
				member.setEmail(email);
				placeVO.setWriter(member);
				
				places.add(placeVO);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);

		} finally {
			closeDB(conn, stmt, rs);
		}

		return places;
		
	}

	/** 
	 * 
	 * 모든 Origin Place 총 개수 출력
	 * @author 이기연
	 * @return
	 */
	public int getAllOriginPlaceCount() {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/place/getAllOriginPlaceCount/text()");
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();

			int placeCount = 0;
			
			if ( rs.next() ) {
				placeCount = rs.getInt(1);
			}
			return placeCount;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		
	}
	
	/**
	 * place Detail 보여주기
	 * @author 이기연
	 * @param placeId
	 * @return
	 */
	public PlaceVO getPlaceDetailByPlaceId(String placeId) {
		
		PlaceVO placeVO = new PlaceVO();
		
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/place/getPlaceDetailByPlaceId/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setString(1, placeId);
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				
				placeVO.setPlaceId(rs.getInt("PLACE_ID"));
				placeVO.setPlaceName(rs.getString("PLACE_NAME"));
				placeVO.setLatitude(rs.getInt("LATITUDE"));
				placeVO.setLongitude(rs.getInt("LONGITUDE"));
				placeVO.setAddress(rs.getString("ADDRESS"));
				placeVO.setViewCount(rs.getInt("VIEW_COUNT"));
				placeVO.setLikeCount(rs.getInt("LIKE_COUNT"));
				placeVO.setDescription(rs.getString("DESCRIPTION"));
				placeVO.setIsNewPlace(rs.getInt("IS_NEW_PLACE"));
				String email = rs.getString("EMAIL");
				placeVO.setCountryId(rs.getInt("COUNTRY_ID"));
				
				MemberVO member = new MemberVO();
				
				member.setEmail(email);
				placeVO.setWriter(member);
							
			}
			return placeVO;
			
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
