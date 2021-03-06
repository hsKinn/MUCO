package com.ktds.muco.table.hashtag.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.hashtag.vo.HashTagVO;
import com.ktds.muco.table.member.dao.Const;
import com.ktds.muco.util.xml.XML;

public class HashTagDAO {

	/**
	 * Get HashTag of Package
	 * 
	 * @author 김현섭
	 * 
	 * @param packId
	 * @return
	 */
	public List<HashTagVO> getHashTagOfPackage(int packId) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<HashTagVO> hashtagList = new ArrayList<HashTagVO>();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/hashtag/getHashTagOfPackage/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, packId);

			rs = stmt.executeQuery();

			HashTagVO hashtag = null;

			while (rs.next()) {

				hashtag = new HashTagVO();

				hashtag.setHashtagId(rs.getInt("HASH_TAG_ID"));
				hashtag.setHashtagName(rs.getString("HASH_TAG_NAME"));

				hashtagList.add(hashtag);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}

		return hashtagList;

	} // getHashTagOfPackage END
	
	/**
	 * @author 백지경
	 * @param tag
	 * @return
	 */
	public int addHashTagInPack(HashTagVO tag) {
		int insertCount = 0;
		
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		System.out.println(tag.getPackId()+" "+tag.getHashtagName());

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.225.152.191:1521:XE", "TRAVERY", "TRAVERY");
			String query = XML.getNodeString("//query/hashtag/addHashTagInPack/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, tag.getPackId());
			stmt.setString(2, tag.getHashtagName());
			
			stmt.executeUpdate();

			return insertCount;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}
	
	/**
	 * 		
	 * @param packId
	 * @author 백지경
	 * @return
	 */
	public int deleteAllHashTagByPackId(int packId) {
		int deleteCount = 0;

		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.225.152.191:1521:XE", "TRAVERY", "TRAVERY");
			String query = XML.getNodeString("//query/hashtag/deleteAllHashTagByPackId/text()");
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
	} // loadOracleDriver END

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
	} // closeDB END


} // Class END
