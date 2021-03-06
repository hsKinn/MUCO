package com.ktds.muco.table.pack.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.member.dao.Const;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.pack.vo.PackSearchVO;
import com.ktds.muco.table.pack.vo.PackVO;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.util.xml.XML;

/**
 * 
 * @author 김광민
 *
 */
public class PackDAO {

	/**
	 * 
	 * @param memberVO
	 * @author 백지경
	 * 
	 */
	public List<PackVO> getPackListByEmail(String email) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<PackVO> packs = new ArrayList<PackVO>();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/pack/getPackListByEmail/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, email);

			rs = stmt.executeQuery();

			PackVO pack = null;

			while (rs.next()) {
				pack = new PackVO();
				pack.setPackId(rs.getInt("PACK_ID"));
				pack.setPackTitle(rs.getString("PACK_TITLE"));
				pack.setViewCount(rs.getInt("VIEW_COUNT"));
				pack.setLikeCount(rs.getInt("LIKE_COUNT"));
				pack.setEmail(rs.getString("EMAIL"));
				pack.setIsPublic(rs.getInt("IS_PUBLIC"));
				pack.setShareImageName(rs.getString("SHARE_IMAGE_NAME"));
				pack.setShareImageLocation(rs.getString("SHARE_IMAGE_LOCATION"));

				packs.add(pack);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return packs;
	}

	/**
	 * 
	 * @param packId
	 * @author 백지경
	 */
	public PackVO getPackDataByPackId(int packId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		System.out.println("DAO까지 잘 가니? " + packId);
		PackVO pack = new PackVO();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/pack/getPackDataByPackId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, packId);

			rs = stmt.executeQuery();

			if (rs.next()) {
				pack.setPackId(rs.getInt("PACK_ID"));
				pack.setPackTitle(rs.getString("PACK_TITLE"));
				pack.setViewCount(rs.getInt("VIEW_COUNT"));
				pack.setLikeCount(rs.getInt("LIKE_COUNT"));
				pack.setEmail(rs.getString("EMAIL"));
				pack.setIsPublic(rs.getInt("IS_PUBLIC"));
				pack.setShareImageName(rs.getString("SHARE_IMAGE_NAME"));
				pack.setShareImageLocation(rs.getString("SHARE_IMAGE_LOCATION"));
				
			}
			
			return pack;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		
	}

	/**
	 * 
	 * @param newAddPack
	 * @author 백지경
	 */
	public int addPack(PackVO newAddPack) {
		int insertCount = 0;

		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/pack/addPack/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, newAddPack.getPackTitle());
			stmt.setString(2, newAddPack.getEmail());

			insertCount = stmt.executeUpdate();

			if (insertCount > 0) {

				stmt.close();
				// close
				String query1 = XML.getNodeString("//query/pack/getLatesPackId/text()");
				stmt = conn.prepareStatement(query1);

				rs = stmt.executeQuery();

				int packId = 0;

				if (rs.next()) {
					packId = rs.getInt(1);
				}
				rs.close();
				return packId;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return insertCount;
	}

	/**
	 * 
	 * @param packId
	 * @author 백지경
	 */
	public int deletePack(int packId) {
		int deleteCount = 0;

		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/pack/deletePack/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, packId);

			deleteCount = stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		return deleteCount;

	}

	/**
	 * 
	 * @param packId
	 * @author 백지경
	 */
	public List<PlaceVO> getPlaceListByPackId(int packId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<PlaceVO> places = new ArrayList<PlaceVO>();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/pack/getPlaceListByPackId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, packId);

			rs = stmt.executeQuery();

			PlaceVO placeVO = null;

			while (rs.next()) {
				placeVO = new PlaceVO();
				placeVO.setPlaceId(rs.getInt("PLACE_ID"));
				placeVO.setPlaceName(rs.getString("PLACE_NAME"));
				placeVO.setLatitude(rs.getInt("LATITUDE"));
				placeVO.setLongitude(rs.getInt("LONGITUDE"));
				placeVO.setAddress(rs.getString("ADDRESS"));
				placeVO.setViewCount(rs.getInt("VIEW_COUNT"));
				placeVO.setDescription(rs.getString("DESCRIPTION"));
				placeVO.setIsNewPlace(rs.getInt("IS_NEW_PLACE"));
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
	 * 모든 패키지 받아오는 method
	 * 
	 * @author 이기연
	 * @param packSearchVO
	 * @return
	 */
	public List<PackVO> getAllPackage(PackSearchVO packSearchVO, int sortOption) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<PackVO> packs = new ArrayList<PackVO>();

		try {

			PackVO packVO = null;
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = "";
			
			// 패키지명
			if (sortOption == 1) {
				if (packSearchVO.getSearchList().equals("packTitle")) {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageOrderByPackTitleSearchedByPackTitle/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, packSearchVO.getSearchKeyword());
					stmt.setInt(2, packSearchVO.getEndIndex());
					stmt.setInt(3, packSearchVO.getStartIndex());
				} else if (packSearchVO.getSearchList().equals("email")) {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageOrderByPackTitleSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, packSearchVO.getSearchKeyword());
					stmt.setInt(2, packSearchVO.getEndIndex());
					stmt.setInt(3, packSearchVO.getStartIndex());
					
				} else {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageOrderByPackTitle/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, packSearchVO.getEndIndex());
					stmt.setInt(2, packSearchVO.getStartIndex());
				}
			} 
			// 등록자 이메일
			else if (sortOption==2) {
				if (packSearchVO.getSearchList().equals("packTitle")) {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageOrderByEmailSearchedByPackTitle/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, packSearchVO.getSearchKeyword());
					stmt.setInt(2, packSearchVO.getEndIndex());
					stmt.setInt(3, packSearchVO.getStartIndex());					
				} else if (packSearchVO.getSearchList().equals("email")) {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageOrderByEmailSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, packSearchVO.getSearchKeyword());
					stmt.setInt(2, packSearchVO.getEndIndex());
					stmt.setInt(3, packSearchVO.getStartIndex());					
					
				} else {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageOrderByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, packSearchVO.getEndIndex());
					stmt.setInt(2, packSearchVO.getStartIndex());
				}
			} 
			// 공개 여부
			else if (sortOption==3) {
				if (packSearchVO.getSearchList().equals("packTitle")) {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageOrderByIsPublicSearachedByPackTitle/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, packSearchVO.getSearchKeyword());
					stmt.setInt(2, packSearchVO.getEndIndex());
					stmt.setInt(3, packSearchVO.getStartIndex());						
				} else if (packSearchVO.getSearchList().equals("email")) {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageOrderByIsPublicSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, packSearchVO.getSearchKeyword());
					stmt.setInt(2, packSearchVO.getEndIndex());
					stmt.setInt(3, packSearchVO.getStartIndex());						
					
				} else {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageOrderByIsPublic/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, packSearchVO.getEndIndex());
					stmt.setInt(2, packSearchVO.getStartIndex());
				}
			} 
			// 추천수
			else if (sortOption==4) {
				if (packSearchVO.getSearchList().equals("packTitle")) {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageOrderByLikeCountSearchedByPackTitle/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, packSearchVO.getSearchKeyword());
					stmt.setInt(2, packSearchVO.getEndIndex());
					stmt.setInt(3, packSearchVO.getStartIndex());						
				} else if (packSearchVO.getSearchList().equals("email")) {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageOrderByLikeCountSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, packSearchVO.getSearchKeyword());
					stmt.setInt(2, packSearchVO.getEndIndex());
					stmt.setInt(3, packSearchVO.getStartIndex());						
					
				} else {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageOrderByLikeCount/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, packSearchVO.getEndIndex());
					stmt.setInt(2, packSearchVO.getStartIndex());
				}
			} 
			// 조회수
			else if (sortOption==5) {
				if (packSearchVO.getSearchList().equals("packTitle")) {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageOrderByViewCountSearchedByPackTitle/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, packSearchVO.getSearchKeyword());
					stmt.setInt(2, packSearchVO.getEndIndex());
					stmt.setInt(3, packSearchVO.getStartIndex());						
				} else if (packSearchVO.getSearchList().equals("email")) {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageOrderByViewCountSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, packSearchVO.getSearchKeyword());
					stmt.setInt(2, packSearchVO.getEndIndex());
					stmt.setInt(3, packSearchVO.getStartIndex());						
					
				} else {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageOrderByViewCount/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, packSearchVO.getEndIndex());
					stmt.setInt(2, packSearchVO.getStartIndex());
				}
			} else {
				if (packSearchVO.getSearchList().equals("packTitle")) {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageSearchedByPackTitle/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, packSearchVO.getSearchKeyword());
					stmt.setInt(2, packSearchVO.getEndIndex());
					stmt.setInt(3, packSearchVO.getStartIndex());						
				} else if (packSearchVO.getSearchList().equals("email")) {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackageSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, packSearchVO.getSearchKeyword());
					stmt.setInt(2, packSearchVO.getEndIndex());
					stmt.setInt(3, packSearchVO.getStartIndex());						
					
				} else {
					// article을 꺼내온다.
					query = XML.getNodeString("//query/pack/getAllPackage/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, packSearchVO.getEndIndex());
					stmt.setInt(2, packSearchVO.getStartIndex());
				}
			}
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				packVO = new PackVO();

				packVO.setPackId(rs.getInt("PACK_ID"));
				packVO.setPackTitle(rs.getString("PACK_TITLE"));
				packVO.setViewCount(rs.getInt("VIEW_COUNT"));
				packVO.setLikeCount(rs.getInt("LIKE_COUNT"));
				packVO.setEmail(rs.getString("EMAIL"));
				packVO.setIsPublic(rs.getInt("IS_PUBLIC"));
				packVO.setShareImageName(rs.getString("SHARE_IMAGE_NAME"));
				packVO.setShareImageLocation(rs.getString("SHARE_IMAGE_LOCATION"));

				packs.add(packVO);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);

		} finally {
			closeDB(conn, stmt, rs);
		}

		return packs;
	}

	/**
	 * package count 받아오는 method
	 * 
	 * @author 이기연
	 * @return
	 */
	public int getPackListCount(PackSearchVO packSearchVO) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			if(packSearchVO.getSearchList().equals("packTitle")) {
				query = XML.getNodeString("//query/pack/getPackListCountSearchedByPackTitle/text()");
				stmt = conn.prepareStatement(query);
				stmt.setString(1, packSearchVO.getSearchKeyword());
			} 
			else if (packSearchVO.getSearchList().equals("email")) {
				query = XML.getNodeString("//query/pack/getPackListCountSearchedByEmail/text()");
				stmt = conn.prepareStatement(query);
				stmt.setString(1, packSearchVO.getSearchKeyword());
			}
			else {
				query = XML.getNodeString("//query/pack/getPackListCount/text()");
				stmt = conn.prepareStatement(query);
			}

			rs = stmt.executeQuery();

			int placeCount = 0;

			if (rs.next()) {
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
