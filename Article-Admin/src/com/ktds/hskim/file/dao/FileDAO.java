package com.ktds.hskim.file.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.hskim.file.vo.FileVO;
import com.ktds.hskim.util.Const;
import com.ktds.hskim.util.xml.XML;

public class FileDAO {
	
	/**
	 * 파일 추가 
	 */
	public int addFile ( FileVO file ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/file/addFile/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, file.getArticleId());
			stmt.setString(2, file.getFileName());
			stmt.setString(3, file.getFileLocation());
			
			int addFileAction = stmt.executeUpdate();
			
			return addFileAction;
						
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	}
	
	
	/**
	 * 파일 존재 여부 확인
	 */
	public int checkFile ( int articleId ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			String query = XML.getNodeString("//query/file/deleteFileCheck/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, articleId);
			
			rs = stmt.executeQuery();
			
			if ( rs.next() ) {
				return rs.getInt("FILE_ID");
			}
			
			return 0;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	} // checkFile end
	
	
	/**
	 * 파일 삭제
	 */
	public void deleteFile ( int articleId ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			String query = XML.getNodeString("//query/file/deleteFile/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, articleId);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	}
	
	
	/**
	 * 첨부파일 목록 가져오기
	 */
	public List<FileVO> getFileListByArticleId ( int articleId ) {

		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
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
			
			if ( file == null ) {
				return null;
			}
			
			return fileList;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
	}
	
	
	/**
	 * Oracle Driver
	 */
	private void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * Close DB
	 */
	private void closeDB(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if ( rs != null ) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if ( stmt != null ) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if ( conn != null ) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
}
