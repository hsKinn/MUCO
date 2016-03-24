package com.ktds.cain.file.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.cain.file.vo.FileVO;
import com.ktds.cain.util.xml.XML;

public class FileDAO {
	
	public void insertFile(FileVO vo) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/file/insertFile/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, vo.getArticleId());
			stmt.setString(2, vo.getFileName());
			stmt.setString(3, vo.getFileLocation());

			stmt.executeUpdate();


		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}
	
	public List<FileVO> getFileListByArticleId(int articleId) {
		
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<FileVO> fileList = new ArrayList<FileVO>();
		FileVO file = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/file/getFileListByArticleId/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, articleId);
			rs = stmt.executeQuery();
			
			while ( rs.next() ) {
				file = new FileVO();
				file.setFileId(rs.getInt("FILE_ID"));
				file.setFileName(rs.getString("FILE_NAME"));
				file.setFileLocation(rs.getString("FILE_LOCATION"));
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
