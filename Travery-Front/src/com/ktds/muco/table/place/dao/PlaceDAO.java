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
import com.ktds.muco.table.placeLike.biz.PlaceLikeBiz;
import com.ktds.muco.table.placeLike.vo.PlaceLikeVO;
import com.ktds.muco.table.placeReply.dao.PlaceReplyDAO;
import com.ktds.muco.util.xml.XML;

/**
 * 
 * @author 김광민
 *
 */
public class PlaceDAO {
	
	/**
	 * Constructor 
	 * @author 김동규
	 * 
	 * @param 
	 * @return
	 */
	private PlaceReplyDAO placeReplyDAO;
	private PlaceLikeBiz placeLikeBiz;
	
	public PlaceDAO() {
		placeReplyDAO = new PlaceReplyDAO();
		placeLikeBiz = new PlaceLikeBiz();
	}
	
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
	 * getUserRecommendPlaceList
	 * 
	 * @author 김동규
	 * 
	 * @param memberVO
	 * @return
	 */
	public List<PlaceVO> getUserRecommendPlaceList(MemberVO memberVO) {
		List<PlaceVO> placeList = new ArrayList<PlaceVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		loadOracleDriver();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/place/getUserRecommendPlaceList/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, memberVO.getEmail());

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
	 * insertPlaceInfo
	 * 
	 * @author 김동규
	 * 
	 * @param placeVO
	 * @return
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
	 * viewCountRecommendPlace
	 * 
	 * @author 김동규
	 * 
	 * @param placeId
	 * @return
	 */
	public int viewCountRecommendPlace(int placeId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/place/viewCountRecommendPlace/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, placeId);

			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}
	/**
	 * getPlaceByCountryName
	 * 
	 * @author 김광민
	 * 
	 * @param countryName
	 * @return
	 */
	public List<PlaceVO> getPlaceByCountryName(String countryName) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<PlaceVO> placeList = new ArrayList<PlaceVO>();

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/place/getPlaceByCountryName/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, countryName);

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

	
	/**
	 * getAllPlaceList
	 * 
	 * @author 김동규
	 * 
	 * @param placeSearchVO / memberVO
	 * @return
	 */
	/*	Get All Package List Order By Like DESC*/
	public List<PlaceVO> getAllPlaceList(PlaceSearchVO placeSearchVO, MemberVO memberVO) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		PlaceLikeVO placeLikeVO = new PlaceLikeVO();
		placeLikeVO.setWriter(memberVO);

		List<PlaceVO> placeList = new ArrayList<PlaceVO>();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/place/getAllPlaceList/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, placeSearchVO.getEndIndex());
			stmt.setInt(2, placeSearchVO.getStartIndex());

			rs = stmt.executeQuery();

			PlaceVO placeVO = null;

			while (rs.next()) {

				placeVO = new PlaceVO();

				placeVO.setPlaceId(rs.getInt("PLACE_ID"));
				placeVO.setPlaceName(rs.getString("PLACE_NAME"));
				placeVO.setViewCount(rs.getInt("VIEW_COUNT"));
				placeVO.setLikeCount(rs.getInt("LIKE_COUNT"));
				placeVO.setName(rs.getString("NAME"));
			
				placeVO.setImageLocation(rs.getString("IMAGE_LOCATION"));
								
				placeVO.setPlaceList(getPlaceInPackage(placeVO.getPlaceId()));
				
								
				placeLikeVO.setPlaceId(placeVO.getPlaceId());
				placeVO.setExistPlaceLike(placeLikeBiz.isExistPlaceLike(placeLikeVO));

				placeVO.setPlaceReplyList(placeReplyDAO.getReplyListByplaceId(placeVO.getPlaceId()));

				placeList.add(placeVO);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return placeList;
	}
	
	public int getAllPlaceCount(PlaceSearchVO placeSearchVO) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/place/getAllPlaceCount/text()");
			stmt = conn.prepareStatement(query);

			rs = stmt.executeQuery();

			int placeCount = 0;
			rs.next();
			placeCount = rs.getInt(1);

			return placeCount;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	public List<PlaceVO> getAllPlaceListOrderByView(PlaceSearchVO placeSearchVO, MemberVO memberVO) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		PlaceLikeVO placeLikeVO = new PlaceLikeVO();
		placeLikeVO.setWriter(memberVO);

		List<PlaceVO> placeList = new ArrayList<PlaceVO>();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/place/getAllPlaceListOrderByView/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, placeSearchVO.getEndIndex());
			stmt.setInt(2, placeSearchVO.getStartIndex());

			rs = stmt.executeQuery();

			PlaceVO placeVO = null;

			while (rs.next()) {


				placeVO = new PlaceVO();

				placeVO.setPlaceId(rs.getInt("PLACE_ID"));
				placeVO.setPlaceName(rs.getString("PLACE_NAME"));
				placeVO.setViewCount(rs.getInt("VIEW_COUNT"));
				placeVO.setLikeCount(rs.getInt("LIKE_COUNT"));
				placeVO.setName(rs.getString("NAME"));
			
				placeVO.setImageLocation(rs.getString("IMAGE_LOCATION"));
				
				placeVO.setPlaceList(getPlaceInPackage(placeVO.getPlaceId()));
				
								
				placeLikeVO.setPlaceId(placeVO.getPlaceId());
				
				boolean a = placeLikeBiz.isExistPlaceLike(placeLikeVO);
				
				placeVO.setExistPlaceLike(a);
				
				placeVO.setPlaceReplyList(placeReplyDAO.getReplyListByplaceId(placeVO.getPlaceId()));

				placeList.add(placeVO);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return placeList;
	}

	public List<PlaceVO> getAllPlaceListOrderByDate(PlaceSearchVO placeSearchVO, MemberVO memberVO) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		PlaceLikeVO placeLikeVO = new PlaceLikeVO();
		placeLikeVO.setWriter(memberVO);

		List<PlaceVO> placeList = new ArrayList<PlaceVO>();
		

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/sharePack/getAllPackageListOrderByDate/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, placeSearchVO.getEndIndex());
			stmt.setInt(2, placeSearchVO.getStartIndex());

			rs = stmt.executeQuery();

			PlaceVO placeVO = null;

			while (rs.next()) {

				placeVO = new PlaceVO();

				placeVO.setPlaceId(rs.getInt("PLACE_ID"));
				placeVO.setPlaceName(rs.getString("PLACE_NAME"));
				placeVO.setViewCount(rs.getInt("VIEW_COUNT"));
				placeVO.setLikeCount(rs.getInt("LIKE_COUNT"));
				placeVO.setName(rs.getString("NAME"));
			
				placeVO.setImageLocation(rs.getString("IMAGE_LOCATION"));
				
				placeVO.setPlaceList(getPlaceInPackage(placeVO.getPlaceId()));
				
								
				placeLikeVO.setPlaceId(placeVO.getPlaceId());
				placeVO.setExistPlaceLike(placeLikeBiz.isExistPlaceLike(placeLikeVO));

				placeVO.setPlaceReplyList(placeReplyDAO.getReplyListByplaceId(placeVO.getPlaceId()));

				placeList.add(placeVO);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return placeList;
	}
}
