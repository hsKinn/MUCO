package com.ktds.muco.table.evaluation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.evaluation.vo.EvaluationVO;
import com.ktds.muco.table.member.dao.Const;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.util.xml.XML;

/**
 * 
 * @author 김광민
 *
 */
public class EvaluationDAO {

	
	/**
	 * @author 이기연
	 * evaluation 평균 구하기
	 * @param placeId
	 * @return
	 */
	public List<EvaluationVO> getAvgEvaluationByPlaceId(String placeId) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<EvaluationVO> evaluations = new ArrayList<EvaluationVO>();

		try {

			EvaluationVO evaluationVO = null;
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			// article을 꺼내온다.
			String query = XML.getNodeString("//query/place/getAvgEvaluationByPlaceId/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setString(1, placeId);
					
			rs = stmt.executeQuery();

			while (rs.next()) {
				evaluationVO = new EvaluationVO();
				evaluationVO.setScore(rs.getInt("SCORE"));
				evaluationVO.setStandardId(rs.getInt("STANDARD_ID"));
				evaluationVO.setStandardId(rs.getInt("STANDARD_ID"));

				evaluations.add(evaluationVO);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);

		} finally {
			closeDB(conn, stmt, rs);
		}

		return evaluations;
		
	}

	
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
