package com.ktds.muco.table.qna.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.member.dao.Const;
import com.ktds.muco.table.qna.vo.QNASearchVO;
import com.ktds.muco.table.qna.vo.QNAVO;
import com.ktds.muco.util.xml.XML;

/**
 * 
 * @author 김광민
 *
 */
public class QNADAO {

	/**
	 * @author 이기연
	 * @return
	 */
	public int getQnaListCount() {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/qna/getQnaListCount/text()");
			stmt = conn.prepareStatement(query);

			rs = stmt.executeQuery();

			int qnaCount = 0;

			if (rs.next()) {
				qnaCount = rs.getInt(1);
			}
			return qnaCount;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	/**
	 * @author 이기연
	 * @param qnaSearchVO
	 * @param sortOption
	 * @return
	 */
	public List<QNAVO> getAllQnas(QNASearchVO qnaSearchVO, int sortOption) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<QNAVO> qnas = new ArrayList<QNAVO>();

		try {
			QNAVO qnaVO = null;

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = "";

			// 제목
			if (sortOption == 1) {
				query = XML.getNodeString("//query/qna/getAllQnasOrderByTitle/text()");
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, qnaSearchVO.getEndIndex());
				stmt.setInt(2, qnaSearchVO.getStartIndex());
			} 
			// 질문자 Email
			else if (sortOption == 2) {
				query = XML.getNodeString("//query/qna/getAllQnasOrderByEmail/text()");
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, qnaSearchVO.getEndIndex());
				stmt.setInt(2, qnaSearchVO.getStartIndex());
			} 
			// 질문 날짜 
			else if (sortOption == 3) {
				query = XML.getNodeString("//query/qna/getAllQnasOrderByQnaDate/text()");
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, qnaSearchVO.getEndIndex());
				stmt.setInt(2, qnaSearchVO.getStartIndex());
			} 
			// 답변 여부
			else if (sortOption == 4) {
				query = XML.getNodeString("//query/qna/getAllQnasOrderByIsAnswer/text()");
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, qnaSearchVO.getEndIndex());
				stmt.setInt(2, qnaSearchVO.getStartIndex());
			} 
			// FAQ 여부
			else if (sortOption == 5) {
				query = XML.getNodeString("//query/qna/getAllQnasOrderByIsFaq/text()");
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, qnaSearchVO.getEndIndex());
				stmt.setInt(2, qnaSearchVO.getStartIndex());
			} else {
				query = XML.getNodeString("//query/qna/getAllQnas/text()");
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, qnaSearchVO.getEndIndex());
				stmt.setInt(2, qnaSearchVO.getStartIndex());
			}

			rs = stmt.executeQuery();

			while (rs.next()) {
				qnaVO = new QNAVO();

				qnaVO.setQnaId(rs.getInt("QNA_ID"));
				qnaVO.setEmail(rs.getString("EMAIL"));
				qnaVO.setQndDate(rs.getString("QNA_DT"));
				qnaVO.setTitle(rs.getString("TITLE"));
				qnaVO.setDescription(rs.getString("DESCRIPTION"));
				qnaVO.setIsAnswer(rs.getInt("IS_ANSWER"));
				qnaVO.setAnswerDescription(rs.getString("ANSWER_DESCRIPTION"));
				qnaVO.setIsFaq(rs.getInt("IS_FAQ"));

				qnas.add(qnaVO);
			}

		}

		catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} 
		finally {
			closeDB(conn, stmt, rs);
		}
		return qnas;
	}

	/**
	 * @author 이기연
	 * @param qnaId
	 * @return
	 */
	public QNAVO getQNADetailByQnaId(String qnaId) {
		QNAVO qnaVO = new QNAVO();

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/qna/getQNADetailByQnaId/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, qnaId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				qnaVO.setQnaId(rs.getInt("QNA_ID"));
				qnaVO.setEmail(rs.getString("EMAIL"));
				qnaVO.setQndDate(rs.getString("QNA_DT"));
				qnaVO.setTitle(rs.getString("TITLE"));
				qnaVO.setDescription(rs.getString("DESCRIPTION"));
				qnaVO.setIsAnswer(rs.getInt("IS_ANSWER"));
				qnaVO.setAnswerDescription(rs.getString("ANSWER_DESCRIPTION"));
				qnaVO.setIsFaq(rs.getInt("IS_FAQ"));
			}
			return qnaVO;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}
	
	/**
	 * @author 이기연
	 * @param qnaId
	 */
	public void deleteQna(String qnaId) {
		int insertCount = 0;
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/qna/deleteQna/text()");
			stmt = conn.prepareStatement(query);
			System.out.println(query);

			stmt.setString(1, qnaId);

			insertCount = stmt.executeUpdate();

			if (insertCount > 0) {
				stmt.close();
				System.out.println("qnaId 삭제 성공");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}	
	}
	
	/**
	 * 답변 체크 하기
	 * 1: 답변 됨 
	 * 0: 답변 안 됨
	 * @param qnaId
	 */
	public void makeAnswer(String qnaId) {
		int insertCount = 0;
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/qna/makeAnswer/text()");
			stmt = conn.prepareStatement(query);
			System.out.println(query);

			stmt.setString(1, qnaId);

			insertCount = stmt.executeUpdate();

			if (insertCount > 0) {
				stmt.close();
				System.out.println("qnaId 답변완료 성공");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}	
	}
	
	/**
	 * FAQ 만들기
	 * @param qnaId
	 */
	public void makeFAQ(String qnaId) {
		int insertCount = 0;
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/qna/makeFAQ/text()");
			stmt = conn.prepareStatement(query);
			System.out.println(query);

			stmt.setString(1, qnaId);

			insertCount = stmt.executeUpdate();

			if (insertCount > 0) {
				stmt.close();
				System.out.println("FAQ로 돌리기 성공");
			}

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

	public void updateQnaAnswerSheet(String qnaId, String qnaAnswerSheet) {
		int insertCount = 0;
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/qna/updateQnaAnswerSheet/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, qnaAnswerSheet);
			stmt.setString(2, qnaId);

			insertCount = stmt.executeUpdate();

			if (insertCount > 0) {
				stmt.close();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}		
	}



}
