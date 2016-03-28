package com.ktds.muco.table.place.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public List<PlaceVO> placeInfoRecommendedList(int placeId) {
		List<PlaceVO> listPlaceVO = new ArrayList<PlaceVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PlaceVO placeVO = null;
		
		loadOracleDriver();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "TRAVERY", "TRAVERY");
			String query = XML.getNodeString("//query/place/placeInfoRecommendedList/text()");
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				placeVO = new PlaceVO();
				placeVO.setPlaceId(rs.getInt("PLACE_ID"));
				placeVO.setPlaceName(rs.getString("PLACE_NAME"));
				
				listPlaceVO.add(placeVO);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
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

		int insertCount = 0;
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "TRAVERY", "TRAVERY");

			String query = XML.getNodeString("//query/place/insertPlaceInfo/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, placeVO.getPlaceName());
			stmt.setString(2, placeVO.getAddress());
			stmt.setDouble(3, placeVO.getLatitude());
			stmt.setDouble(4, placeVO.getLongitude());
			stmt.setString(5, placeVO.getDescription());
			stmt.setString(6, placeVO.getWriter().getEmail());
			
			insertCount = stmt.executeUpdate();

			if (insertCount > 0) {
				stmt.close();
				query = XML.getNodeString("//query/place/getReturnPlaceId/text()");
				stmt = conn.prepareStatement(query);

				ResultSet rs = stmt.executeQuery();

				int placeId = 0;

				if (rs.next()) {
					placeId = rs.getInt(1);
				}
				return placeId;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		return insertCount;

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
