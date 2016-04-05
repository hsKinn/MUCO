package com.ktds.muco.table.evaluation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.muco.table.evaluation.vo.EvaluationVO;
import com.ktds.muco.table.member.dao.Const;
import com.ktds.muco.util.xml.XML;

/**
 * 
 * @author 김광민
 *
 */
public class EvaluationDAO {

	/**
	 * Set Vote Score
	 * 
	 * @author 김현섭
	 * 
	 * @param voteScore
	 * @param member
	 * @return
	 */
	public int setVoteScore( EvaluationVO evaluation ) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/evaluation/setVoteScore/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, evaluation.getScore());
			stmt.setInt(2, evaluation.getPlaceId());
			stmt.setInt(3, evaluation.getStandardId());
			stmt.setString(4, evaluation.getEmail());
			
			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}

	} // setVoteScore END
	

	/**
	 * Exist Vote By PlaceId & Member
	 * 
	 * @author 김현섭
	 * 
	 * @param evaluation
	 * @return
	 */
	public int isExistVote(EvaluationVO evaluation) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/evaluation/isExistVote/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, evaluation.getPlaceId());
			stmt.setString(2, evaluation.getEmail());
			
			rs = stmt.executeQuery();
			
			rs.next();
			
			return rs.getInt(1);
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
	} // isExistVote END
	
	
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
	}

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
	}

}
