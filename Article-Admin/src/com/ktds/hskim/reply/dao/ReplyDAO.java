package com.ktds.hskim.reply.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.hskim.file.vo.FileVO;
import com.ktds.hskim.reply.vo.ReplyVO;
import com.ktds.hskim.util.Const;
import com.ktds.hskim.util.xml.XML;

public class ReplyDAO {
	
	public List<ReplyVO> getReplyListByArticleId ( int articleId ) {

		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			String query = XML.getNodeString("//query/reply/getReplyListByArticleId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, articleId);
			
			rs = stmt.executeQuery();
			
			List<ReplyVO> replyList = new ArrayList<ReplyVO>();
			
			ReplyVO reply = null;
			while ( rs.next() ) {
				
				reply = new ReplyVO();
				reply.setReplyId(rs.getInt("REPLY_ID"));
				reply.setArticleId(rs.getInt("ARTICLE_ID"));
				reply.setMemberId(rs.getString("MEMBER_ID"));
				reply.setNickName(rs.getString("NICK_NAME"));
				reply.setDescription(rs.getString("DESCRIPTION"));
				reply.setGroupId(rs.getInt("GROUP_ID"));
				reply.setParentReplyId(rs.getInt("PARENT_REPLY_ID"));
				reply.setDepth(rs.getInt("DEPTH"));
				reply.setOrderNo(rs.getInt("ORDER_NO"));
				
				replyList.add(reply);
			}
			
			if ( reply == null ) {
				return null;
			}
			
			return replyList;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
	}
	
	/**
	 * 댓글 작성 
	 */
	public int insertReply (ReplyVO reply) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/reply/insertReply/text()");
			
			if ( reply.getParentReplyId() > 0 ) {
				query = XML.getNodeString("//query/reply/insertReReply/text()");
			}
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, reply.getArticleId());
			stmt.setString(2, reply.getMemberId());
			stmt.setString(3, reply.getDescription());
			
			if ( reply.getParentReplyId() > 0 ) {
				stmt.setInt(4, reply.getGroupId());
				stmt.setInt(5, reply.getParentReplyId());
				stmt.setInt(6, reply.getDepth());
				stmt.setInt(7, reply.getOrderNo());
			}
			
			int insertCount = stmt.executeUpdate();
			
			return insertCount;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	}
	
	
	/**
	 * 부모 댓글 여부 
	 */
	public int selectCountParentReplyId(ReplyVO reply) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/reply/selectCountParentReplyId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, reply.getParentReplyId());
			
			rs = stmt.executeQuery();
			rs.next();	
			
			return rs.getInt(1);
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
	}
	
	
	/**
	 * 최대 오더 넘버 값 가져오기
	 */
	public int selectMaxOrderNoByParentReplyId(ReplyVO reply) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/reply/selectMaxOrderNoByParentReplyId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, reply.getReplyId());
			
			rs = stmt.executeQuery();
			
			if ( rs.next() ) {
				return rs.getInt(1);
			}
			else {
				return 0;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}		
	}

	
	/**
	 * 최신 오더 넘버 
	 */
	public int selectLatestOrderNoByParentReplyId(ReplyVO reply) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/reply/selectLatestOrderNoByParentReplyId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, reply.getParentReplyId());
			
			rs = stmt.executeQuery();
			rs.next();
			
			return rs.getInt(1);
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}			
	}

	
	/**
	 * 업데이트 오더 넘버
	 */
	public void updateOrderNoByGroupId(ReplyVO reply) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/reply/updateOrderNoByGroupId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, reply.getOrderNo());
			stmt.setInt(2, reply.getGroupId());
			stmt.executeQuery();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
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
