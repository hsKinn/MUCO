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
	public List<PlaceVO> getPlaceInPackage(int packId) {

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

			while (rs.next()) {

				place = new PlaceVO();

				place.setPlaceId(rs.getInt("PLACE_ID"));
				place.setPlaceName(rs.getString("PLACE_NAME"));
				place.setAddress(rs.getString("ADDRESS"));

				placeList.add(place);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}

		return placeList;

	} // getHashTagOfPackage END

	/**
	 * 
	 * getUserRecommendPlaceList
	 * 
	 * @author 김동규
	 * 
	 */

	public List<PlaceVO> getUserRecommendPlaceList(MemberVO member) {
		List<PlaceVO> placeList = new ArrayList<PlaceVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		loadOracleDriver();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/place/getUserRecommendPlaceList/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, member.getEmail());

			rs = stmt.executeQuery();
			PlaceVO placeVO = null;

			while (rs.next()) {
				placeVO = new PlaceVO();
				placeVO.setPlaceName(rs.getString("PLACE_NAME"));
				placeList.add(placeVO);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return placeList;
	}

	/**
	 * 
	 * insertPlaceInfo
	 * 
	 * @author 김동규
	 * 
	 */
	public PlaceVO insertPlaceInfo(PlaceVO placeVO) {

		int insertCount = 0;
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
			stmt.setString(5, placeVO.getPlaceDescription());
			stmt.setString(6, placeVO.getWriter().getEmail());

			insertCount = stmt.executeUpdate();
			stmt.close();

			if (insertCount > 0) {
				query = XML.getNodeString("//query/place/getReturnPlaceId/text()");
				stmt = conn.prepareStatement(query);

				ResultSet rs = stmt.executeQuery();

				int placeId = 0;

				if (rs.next()) {
					placeId = rs.getInt(1);
					placeVO.setPlaceId(placeId);
				}
				return placeVO;
			}

			return placeVO;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}

	}

	/**
	 * 나라 리스트 가져오기
	 * 
	 * By Country ID
	 * 
	 * @param countryId
	 * @return
	 * @author 김광민
	 */
	public List<PlaceVO> getPlaceListByCountryId(int countryId) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<PlaceVO> placeList = new ArrayList<PlaceVO>();

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/place/getPlaceListByCountryId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, countryId);

			rs = stmt.executeQuery();

			PlaceVO placeVO = null;

			while (rs.next()) {

				placeVO = new PlaceVO();

				placeVO.setPlaceId(rs.getInt("PLACE_ID"));
				placeVO.setPlaceName(rs.getString("PLACE_NAME"));
				placeVO.setLatitude(rs.getDouble("LATITUDE"));
				placeVO.setLongitude(rs.getDouble("LONGITUDE"));
				placeVO.setAddress(rs.getString("ADDRESS"));
				placeVO.setViewCount(rs.getInt("VIEW_COUNT"));
				placeVO.setPlaceDescription(rs.getString("DESCRIPTION"));
				placeVO.setIsNewPlace(rs.getInt("IS_NEW_PLACE"));
				placeVO.setCountryId(rs.getInt("COUNTRY_ID"));
				
				// 각 기준에 대한 평균값 입력
				placeVO.setAvgActiveCalmScore( rs.getDouble("AVG_ACTIVE_SCORE") );
				placeVO.setAvgBrightDarkScore( rs.getDouble("AVG_BRIGHT_SCORE") );
				placeVO.setAvgHighPriceLowPriceScore( rs.getDouble("AVG_HIGH_PRICE_SCORE") );

				placeList.add(placeVO);

			} // if data is done finish.
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return placeList;
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
