package com.ktds.cain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.cain.util.xml.XML;
import com.ktds.cain.vo.DirectorVO;

public class DirectorDAO {

	public List<DirectorVO>	getDirectorsByMovieId(int movieId) {
		
		List<DirectorVO> dvo = new ArrayList<DirectorVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DirectorVO vo = null;
		
		loadOracleDriver();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PWD);
			String query = XML.getNodeString("//query/movie/getDirectorsByMovieId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, movieId);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				vo = new DirectorVO();
				vo.setDirectorId(rs.getInt("DIRECTOR_ID"));
				vo.setDirectorName(rs.getString("DIRECTOR_NAME"));
				
				dvo.add(vo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		return dvo;		
	}
	
	
	public List<DirectorVO>	getAllDirectors() {
		
		List<DirectorVO> dvo = new ArrayList<DirectorVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DirectorVO vo = null;
		
		loadOracleDriver();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PWD);
			String query = XML.getNodeString("//query/movie/getAllDirectors/text()");
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				vo = new DirectorVO();
				vo.setDirectorId(rs.getInt("DIRECTOR_ID"));
				vo.setDirectorName(rs.getString("DIRECTOR_NAME"));
				
				dvo.add(vo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		return dvo;		
	}
	
	public int insertNewDirectorOfNewMovie( DirectorVO director) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		loadOracleDriver();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PWD);
			String query = XML.getNodeString("//query/movie/insertNewDirector/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, director.getDirectorId());
			stmt.setInt(2, director.getMovieId());
			
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
