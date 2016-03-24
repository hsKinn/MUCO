package com.ktds.muco.table.pack.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.pack.vo.PackVO;
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

				packs.add(pack);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return packs;
	}

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
