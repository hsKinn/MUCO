package com.ktds.cain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.cain.util.xml.XML;
import com.ktds.cain.vo.ActorVO;

public class ActorDAO {

	/**
	 * @param movieId
	 * @return
	 */
	public List<ActorVO> getActorsByMovieId(int movieId) {
		List<ActorVO> avo = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ActorVO vo = null;

		loadOracleDriver();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PWD);
			String query = XML.getNodeString("//query/movie/getActorsByMovieId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, movieId);
			rs = stmt.executeQuery();

			while (rs.next()) {
				vo = new ActorVO();
				vo.setActorId(rs.getInt("ACTOR_ID"));
				vo.setActorName(rs.getString("ACTOR_NAME"));

				avo.add(vo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return avo;
	}

	public boolean addNewActor(String actorName) {
		loadOracleDriver();
		Connection conn = null;

		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PWD);

			String query = XML.getNodeString("//query/movie/addNewActor/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, actorName);

			int insertCount = stmt.executeUpdate();

			return insertCount > 0;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}

	public List<ActorVO> getAllActors() {
		List<ActorVO> avo = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ActorVO vo = null;

		loadOracleDriver();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PWD);
			String query = XML.getNodeString("//query/movie/getAllActors/text()");
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();

			while (rs.next()) {
				vo = new ActorVO();
				vo.setActorId(rs.getInt("ACTOR_ID"));
				vo.setActorName(rs.getString("ACTOR_NAME"));

				avo.add(vo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return avo;
	}

	public int insertNewActorOfNewMovie(ActorVO actors) {

		Connection conn = null;
		PreparedStatement stmt = null;

		loadOracleDriver();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PWD);
			String query = XML.getNodeString("//query/movie/insertNewActor/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, actors.getActorId());
			stmt.setInt(2, actors.getMovieId());

			int insertCount = stmt.executeUpdate();
			return insertCount;
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
