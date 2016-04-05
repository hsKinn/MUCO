package com.ktds.muco.table.history.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.history.vo.HistorySearchVO;
import com.ktds.muco.table.history.vo.HistoryVO;
import com.ktds.muco.table.member.dao.Const;
import com.ktds.muco.util.xml.XML;

/**
 * 
 * @author 김광민
 *
 */
public class HistoryDAO {

	/**
	 * Add History
	 * 
	 * @param history
	 * @author 김광민
	 */
	public void addHistory(HistoryVO history) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/history/addHistory/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, history.getIp());
			stmt.setString(2, history.getUrl());
			stmt.setString(3, history.getActionCode());
			stmt.setString(4, history.getHistoryDescription());
			stmt.setString(5, history.getEtc());
			stmt.setString(6, history.getEmail());

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}

	/**
	 * history list count
	 * 
	 * @return
	 */
	public int getAllHistoryCount() {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/history/getAllHistoryCount/text()");
			stmt = conn.prepareStatement(query);

			rs = stmt.executeQuery();

			int historyCount = 0;

			if (rs.next()) {
				historyCount = rs.getInt(1);
			}
			return historyCount;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	/**
	 * history list 받아오기
	 * 
	 * @param historySearchVO
	 * @return
	 */
	public List<HistoryVO> getAllHistoryList(HistorySearchVO historySearchVO) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<HistoryVO> histories = new ArrayList<HistoryVO>();

		try {

			HistoryVO historyVO = null;
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			// article을 꺼내온다.
			String query = XML.getNodeString("//query/history/getAllHistoryList/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, historySearchVO.getEndIndex());
			stmt.setInt(2, historySearchVO.getStartIndex());

			rs = stmt.executeQuery();

			while (rs.next()) {
				historyVO = new HistoryVO();

				historyVO.setHistoryId(rs.getInt("HISTORY_ID"));
				historyVO.setIp(rs.getString("IP"));
				historyVO.setCreatedDate(rs.getString("CRT_DT"));
				historyVO.setUrl(rs.getString("URL"));
				historyVO.setActionCode(rs.getString("ACTION_CODE"));
				historyVO.setHistoryDescription(rs.getString("DESCRIPTION"));
				historyVO.setEtc(rs.getString("ETC"));
				historyVO.setEmail(rs.getString("EMAIL"));

				histories.add(historyVO);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);

		} finally {
			closeDB(conn, stmt, rs);
		}

		return histories;
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
