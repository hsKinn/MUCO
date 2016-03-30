package com.ktds.muco.table.file.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.muco.util.xml.XML;

public class FileDAO {

	/**
	 * 
	 * @author 백지경
	 *
	 */
	public int uploadPackImgFile(int packId, File file) {
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		int updateCount = 0;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.225.152.191:1521:XE", "TRAVERY", "TRAVERY");
			String query = XML.getNodeString("//query/pack/uploadPackImgFile/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, file.getName());
			stmt.setString(2, file.getPath());
			stmt.setInt(3, packId);

			updateCount = stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return updateCount;
	}

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

	private void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
