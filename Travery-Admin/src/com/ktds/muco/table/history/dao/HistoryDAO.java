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
	public int getAllHistoryCount(HistorySearchVO historySearchVO) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			// ip
			if (historySearchVO.getSearchList().equals("ip"))  {
				query = XML.getNodeString("//query/history/getAllHistoryCountSearchedByIp/text()");
				stmt = conn.prepareStatement(query);
				stmt.setString(1, historySearchVO.getSearchKeyword());
			}
			// email
			else if (historySearchVO.getSearchList().equals("email")) {
				query = XML.getNodeString("//query/history/getAllHistoryCountSearchedByEmail/text()");
				stmt = conn.prepareStatement(query);
				stmt.setString(1, historySearchVO.getSearchKeyword());
			}
			// url
			else if (historySearchVO.getSearchList().equals("url")) {
				query = XML.getNodeString("//query/history/getAllHistoryCountSearchedByURL/text()");
				stmt = conn.prepareStatement(query);
				stmt.setString(1, historySearchVO.getSearchKeyword());
			}
			//action code
			else if (historySearchVO.getSearchList().equals("actionCode")) {
				query = XML.getNodeString("//query/history/getAllHistoryCountSearchedByActioncode/text()");
				stmt = conn.prepareStatement(query);
				stmt.setString(1, historySearchVO.getSearchKeyword());
			}
			//history description
			else if (historySearchVO.getSearchList().equals("historyDescription")) {
				query = XML.getNodeString("//query/history/getAllHistoryCountSearchedByHistoryDescription/text()");
				stmt = conn.prepareStatement(query);
				stmt.setString(1, historySearchVO.getSearchKeyword());
			}
			//etc
			else if (historySearchVO.getSearchList().equals("etc")) {
				query = XML.getNodeString("//query/history/getAllHistoryCountSearchedByETC/text()");
				stmt = conn.prepareStatement(query);
				stmt.setString(1, historySearchVO.getSearchKeyword());
			}
			else {
				query = XML.getNodeString("//query/history/getAllHistoryCount/text()");
				stmt = conn.prepareStatement(query);
			}

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
	public List<HistoryVO> getAllHistoryList(HistorySearchVO historySearchVO, int sortOption) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<HistoryVO> histories = new ArrayList<HistoryVO>();

		try {

			HistoryVO historyVO = null;
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = "";

			// IP
			if (sortOption == 1) {
				if (historySearchVO.getSearchList().equals("ip")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByIpSearchedByIp/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByIpSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("url")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByIpSearchedByURL/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("actionCode")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByIpSearchedByActionCode/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("historyDescription")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByIpSearchedByHistoryDescription/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("etc")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByIpSearchedByEtc/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByIp/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, historySearchVO.getEndIndex());
					stmt.setInt(2, historySearchVO.getStartIndex());
				}

			}
			// EMAIL
			else if (sortOption == 2) {
				if (historySearchVO.getSearchList().equals("ip")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByEmailSearchedByIp/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByEmailSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("url")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByEmailSearchedByURL/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("actionCode")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByEmailSearchedByActionCode/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("historyDescription")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByEmailSearchedByHistoryDescription/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("etc")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByEmailSearchedByEtc/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, historySearchVO.getEndIndex());
					stmt.setInt(2, historySearchVO.getStartIndex());
				}

			}
			// 최근 생성일 순
			else if (sortOption == 3) {
				if (historySearchVO.getSearchList().equals("ip")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByRecentCreateDateSearchedByIp/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByRecentCreateDateSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("url")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByRecentCreateDateSearchedByURL/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("actionCode")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByRecentCreateDateSearchedByActionCode/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("historyDescription")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByRecentCreateDateSearchedByHistoryDescription/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("etc")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByRecentCreateDateSearchedByETC/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByRecentCreateDate/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, historySearchVO.getEndIndex());
					stmt.setInt(2, historySearchVO.getStartIndex());

				}

			}
			// 오래된 생성일
			else if (sortOption == 4) {
				if (historySearchVO.getSearchList().equals("ip")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByDatedDateSearchedByIp/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByDatedDateSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("url")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByDatedDateSearchedByURL/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("actionCode")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByDatedDateSearchedByActionCode/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("historyDescription")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByDatedDateSearchedByHistoryDescription/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("etc")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByDatedDateSearchedByETC/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByDatedDate/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, historySearchVO.getEndIndex());
					stmt.setInt(2, historySearchVO.getStartIndex());
				}

			}
			// 접근 URL
			else if (sortOption == 5) {
				if (historySearchVO.getSearchList().equals("ip")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByURLSearchedByIp/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByURLSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("url")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByURLSearchedByURL/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("actionCode")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByURLSearchedByActionCode/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("historyDescription")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByURLSearchedByHistoryDescription/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("etc")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByURLSearchedByETC/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByURL/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, historySearchVO.getEndIndex());
					stmt.setInt(2, historySearchVO.getStartIndex());
				}

			}
			// 액션코드
			else if (sortOption == 6) {
				if (historySearchVO.getSearchList().equals("ip")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByActionCodeSearchedByIp/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByActionCodeSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("url")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByActionCodeSearchedByURL/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("actionCode")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByActionCodeSearchedByActionCode/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("historyDescription")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByActionCodeSearchedByHistoryDescription/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("etc")) {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByActionCodeSearchedByETC/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else {
					query = XML.getNodeString("//query/history/getAllHistoryListOrderByActionCode/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, historySearchVO.getEndIndex());
					stmt.setInt(2, historySearchVO.getStartIndex());
				}
			} else {
				if (historySearchVO.getSearchList().equals("ip")) {
					query = XML.getNodeString("//query/history/getAllHistoryListSearchedByIp/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/history/getAllHistoryListSearchedByEmail/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("url")) {
					query = XML.getNodeString("//query/history/getAllHistoryListSearchedByURL/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("actionCode")) {
					query = XML.getNodeString("//query/history/getAllHistoryListSearchedByActionCode/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("historyDescription")) {
					query = XML.getNodeString("//query/history/getAllHistoryListSearchedByHistoryDescription/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else if (historySearchVO.getSearchList().equals("etc")) {
					query = XML.getNodeString("//query/history/getAllHistoryListSearchedByETC/text()");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, historySearchVO.getSearchKeyword());
					stmt.setInt(2, historySearchVO.getEndIndex());
					stmt.setInt(3, historySearchVO.getStartIndex());

				} else {
					query = XML.getNodeString("//query/history/getAllHistoryList/text()");
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, historySearchVO.getEndIndex());
					stmt.setInt(2, historySearchVO.getStartIndex());

				}
			}

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
	 * 30일 지난 히스토리 count
	 * 
	 * @return
	 */
	public int getOver30DaysHistoryListCount() {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/history/getOver30DaysHistoryListCount/text()");
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
	 * 30일 지난 history 받아오기
	 * 
	 * @param historySearchVO
	 * @return
	 */
	public List<HistoryVO> getOver30DaysHistoryList(HistorySearchVO historySearchVO) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<HistoryVO> histories = new ArrayList<HistoryVO>();

		try {

			HistoryVO historyVO = null;
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			// article을 꺼내온다.
			String query = XML.getNodeString("//query/history/getOver30DaysHistoryList/text()");
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
	 * 일괄삭제
	 */
	public void deleteAllHistories() {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/history/deleteAllHistories/text()");
			stmt = conn.prepareStatement(query);

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}

	/**
	 * 하나씩 삭제
	 * 
	 * @param parseInt
	 */
	public void deleteHistoryByHisotryId(int hisotryId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/history/deleteHistoryByHistoryId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, hisotryId);
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
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
