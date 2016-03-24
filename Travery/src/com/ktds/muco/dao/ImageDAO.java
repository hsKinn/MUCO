package com.ktds.muco.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.util.xml.XML;
import com.ktds.muco.vo.ImageVO;

public class ImageDAO {
	public void insertFile(ImageVO imageVO) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/file/insertFile/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, imageVO.getImageId());
			stmt.setString(2, imageVO.getImageName());
			stmt.setString(3, imageVO.getImageLocation());

			stmt.executeUpdate();


		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}
	
	public List<ImageVO> getFileListByArticleId(int articleId) {
		
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ImageVO> fileList = new ArrayList<ImageVO>();
		ImageVO file = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/file/getFileListByArticleId/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, articleId);
			rs = stmt.executeQuery();
			
			while ( rs.next() ) {
				file = new ImageVO();
				file.setImageId(rs.getInt("IMAGE_ID"));
				file.setImageName(rs.getString("IMAGE_NAME"));
				file.setImageLocation(rs.getString("IMAGE_LOCATION"));
				fileList.add(file);
			}
			if ( file == null ) {
				return null;
			}

			return fileList;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}
	
	
	
	public void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
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
}
