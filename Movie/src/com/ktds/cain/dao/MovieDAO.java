package com.ktds.cain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.cain.util.xml.XML;
import com.ktds.cain.vo.MovieVO;

public class MovieDAO {
	
	public List<MovieVO> allMovie() {
		
		List<MovieVO> mvo = new ArrayList<MovieVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MovieVO vo = null;
		
		
		loadOracleDriver();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PWD);
		//	String query = "SELECT M.* , G.GRADE_TITLE, AC.ACTOR_COUNT FROM MOVIE M, GRADE G, ( SELECT MOVIE_ID, COUNT(ACTOR_LIST_ID) ACTOR_COUNT FROM ACTOR_LIST GROUP BY MOVIE_ID) AC WHERE M.GRADE_ID = G.GRADE_ID AND AC. MOVIE_ID(+) = M.MOVIE_ID ORDER BY M.MOVIE_ID ASC";
			String query = XML.getNodeString("//query/movie/getAllMovie/text()");
//			System.out.println(query);
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				vo = new MovieVO();
				vo.setMovieId(rs.getInt("MOVIE_ID"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setStartDate(rs.getString("START_DATE"));
				vo.setRate(rs.getDouble("RATE"));
				vo.setRunTime(rs.getString("RUN_TIME"));
				vo.setGradeId(rs.getInt("GRADE_ID"));
				vo.setGradeTitle(rs.getString("GRADE_TITLE"));
				vo.setActorCount(rs.getInt("ACTOR_COUNT"));
				
				mvo.add(vo);
			}	//	if	data is done finish.
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		return mvo;
	}

	public	MovieVO getOneMovieInfoByMovieId(int movieId) {
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MovieVO movie = new MovieVO();
		
		loadOracleDriver();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PWD);
			String query = XML.getNodeString("//query/movie/getOneMovieInfoByMovieId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, movieId);
			// stmt.setInt(parameterIndex, x);
			// if you don't know info setting to info.
			// * this skill is SQL Parameter Mapping *
			rs = stmt.executeQuery();
			
			if ( rs.next()) {
				movie.setMovieId(rs.getInt("MOVIE_ID"));
				movie.setTitle(rs.getString("TITLE"));
				movie.setStartDate(rs.getString("START_DATE"));
				movie.setRate(rs.getDouble("RATE"));
				movie.setRunTime(rs.getString("RUN_TIME"));
				movie.setGradeId(rs.getInt("GRADE_ID"));
				movie.setGradeTitle(rs.getString("GRADE_TITLE"));
			}	//	if have a data run.
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		return movie;
	}
	public int insertNewMovie( MovieVO movie) {
		int insertCount = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		loadOracleDriver();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PWD);
			String query = XML.getNodeString("//query/movie/insertNewMovie/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setString(1, movie.getTitle());
			stmt.setDouble(2, movie.getRate());
			stmt.setString(3, movie.getRunTime());
			stmt.setString(4, movie.getStartDate());
			stmt.setInt(5, movie.getGradeId());
			
			insertCount = stmt.executeUpdate();
			
			if( insertCount > 0 ) {
				
				stmt.close();
				query = XML.getNodeString("//query/movie/getLatestMovieId/text()");
				stmt = conn.prepareStatement(query);
				
				ResultSet rs = stmt.executeQuery();
				
				
				// rs는 메모리에 닫히지 않고 상주해 있기 떄문에 닫아줘야한다.
				int movieId = 0;
				
				if ( rs.next() ) {
					movieId = rs.getInt(1);
				}
				rs.close();
				return movieId;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
		return insertCount;
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
