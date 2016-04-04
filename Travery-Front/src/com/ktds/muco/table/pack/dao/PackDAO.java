package com.ktds.muco.table.pack.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.225.152.191:1521:XE", "TRAVERY", "TRAVERY");

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

		PackVO pack = new PackVO();
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.225.152.191:1521:XE", "TRAVERY", "TRAVERY");

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

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return pack;
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
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.225.152.191:1521:XE", "TRAVERY", "TRAVERY");
			String query = XML.getNodeString("//query/pack/addPack/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, newAddPack.getPackTitle());
			stmt.setString(2, newAddPack.getEmail());
			stmt.setInt(3, newAddPack.getIsPublic());

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
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.225.152.191:1521:XE", "TRAVERY", "TRAVERY");
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
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.225.152.191:1521:XE", "TRAVERY", "TRAVERY");

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
				placeVO.setPlaceDescription(rs.getString("DESCRIPTION"));
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

	public int deletePlaceOfPack(int placeId, int packId) {
		int deletePlaceOfPackCount = 0;

		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.225.152.191:1521:XE", "TRAVERY", "TRAVERY");
			String query = XML.getNodeString("//query/pack/deletePlaceOfPack/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, placeId);
			stmt.setInt(2, packId);

			deletePlaceOfPackCount = stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		return deletePlaceOfPackCount;
	}

	public int modifyPack(PackVO modifyPack) {
		int modifyCount = 0;

		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;

		System.out.println("dao" + modifyPack.getPackTitle());
		String title = modifyPack.getPackTitle();
		int isPublic = modifyPack.getIsPublic();
		int packId = modifyPack.getPackId();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.225.152.191:1521:XE", "TRAVERY", "TRAVERY");
			String query = XML.getNodeString("//query/pack/modifyPack/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, title);
			stmt.setInt(2, isPublic);
			stmt.setInt(3, packId);

			modifyCount = stmt.executeUpdate();

			System.out.println("modyCount" + modifyCount);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		return modifyCount;
	}
	
	
	/**
	 * 
	 * 선택한 여행지 myPack에 추가
	 * 
	 * @author 유병훈
	 * 
	 */
	public int getAddMyPackByPlace(int ori_placeId, int packId) {
		
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;


		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.225.152.191:1521:XE", "TRAVERY", "TRAVERY");
			String query = XML.getNodeString("//query/pack/getAddMyPackByPlace/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, packId);
			stmt.setInt(2, ori_placeId);

			return stmt.executeUpdate();
			

			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
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