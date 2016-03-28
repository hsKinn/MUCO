package com.ktds.jgbaek.file.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jgbaek.file.vo.FileVO;
import com.ktds.jgbaek.util.xml.XML;

public class FileDAO {
	
	public void uploadFile(int articleId, File file) {
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "ARTICLE");
			String query = XML.getNodeString("//query/file/uploadFile/text()");
			stmt = conn.prepareStatement(query);
			
			
			stmt.setInt(1, articleId);
			stmt.setString(2, file.getName());
			stmt.setString(3, file.getPath());

			rs = stmt.executeQuery();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}
	
	public List<FileVO> getFileListByArticleId ( int articleId ) {
		
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "ARTICLE");
			String query = XML.getNodeString("//query/file/getFileListByArticleId/text()");
			stmt = conn.prepareStatement(query);			
			stmt.setInt(1, articleId);

			rs = stmt.executeQuery();

			List<FileVO> fileList = new ArrayList<FileVO>();
			FileVO file = null;
			while ( rs.next() ) {
				file = new FileVO();
				file.setFileId(rs.getInt("FILE_ID"));
				file.setFileName(rs.getString("FILE_NAME"));
				file.setFileLocation(rs.getString("FILE_LOCATION"));
				fileList.add(file);				
			}
			if(file == null){
				return null;
			}

			return fileList;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
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

	private void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}


}
