package com.ktds.cain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.cain.util.xml.XML;
import com.ktds.cain.vo.GenreVO;

public class GenreDAO {
	public List<GenreVO> getGenreByMovieId(int movieId) {
		
		List<GenreVO> gvo = new ArrayList<GenreVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		GenreVO vo = null;
		
		loadOracleDriver();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PWD);
			String query = XML.getNodeString("//query/movie/getGenreByMovieId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, movieId);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				vo = new GenreVO();
				vo.setGenreId(rs.getInt("GENRE_ID"));
				vo.setGenreTitle(rs.getString("GENRE_TITLE"));
				
				gvo.add(vo);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		return gvo;
	}
	
	public List<GenreVO> getAllGenres() {
		
		List<GenreVO> gvo = new ArrayList<GenreVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		GenreVO vo = null;
		
		loadOracleDriver();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PWD);
			String query = XML.getNodeString("//query/movie/getAllGenres/text()");
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				vo = new GenreVO();
				vo.setGenreId(rs.getInt("GENRE_ID"));
				vo.setGenreTitle(rs.getString("GENRE_TITLE"));
				
				gvo.add(vo);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		return gvo;
	}
	
	public int insertNewGenreOfNewMovie( GenreVO genre) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		loadOracleDriver();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PWD);
			String query = XML.getNodeString("//query/movie/insertNewGenre/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, genre.getGenreId());
			stmt.setInt(2, genre.getMovieId());

			int insertCount = stmt.executeUpdate();
			return insertCount;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	}
	
	public void loadOracleDriver(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}
	
	private void closeDB(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if( rs != null ) {
			try {
				rs.close();
			} catch (SQLException e) {}
		}
		if( stmt != null ) {
			try {
				stmt.close();
			} catch (SQLException e) {}
		}
		if( conn !=null ) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
}
