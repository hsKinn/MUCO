package com.ktds.muco.table.place.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.hashtag.vo.HashTagVO;
import com.ktds.muco.table.member.dao.Const;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.util.xml.XML;

/**
 * 
 * @author 김광민
 *
 */
public class PlaceDAO {
	
	
	/**
	 * Get Place in Package
	 * 
	 * @author 김현섭
	 * 
	 * @param packId
	 * @return
	 */
	public List<PlaceVO> getPlaceInPackage ( int packId ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<PlaceVO> placeList = new ArrayList<PlaceVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/place/getPlaceInPackage/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, packId);
			
			rs = stmt.executeQuery();
			
			PlaceVO place = null;
			
			while ( rs.next() ) {
				
				place = new PlaceVO();
				
				place.setPlaceId(rs.getInt("PLACE_ID"));
				place.setPlaceName(rs.getString("PLACE_NAME"));
				place.setAddress(rs.getString("ADDRESS"));
				place.setLikeCount(rs.getInt("LIKE_COUNT"));
				place.setCountryName(rs.getString("COUNTRY_NAME"));
				
				placeList.add(place);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
		return placeList;
		
	} // getHashTagOfPackage END	
	
	
	
	
	
	
	
	
	
	
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
