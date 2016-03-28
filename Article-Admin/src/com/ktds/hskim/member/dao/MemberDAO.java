package com.ktds.hskim.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.hskim.article.vo.ArticleVO;
import com.ktds.hskim.member.vo.MemberSearchVO;
import com.ktds.hskim.member.vo.MemberVO;
import com.ktds.hskim.util.Const;
import com.ktds.hskim.util.xml.XML;

public class MemberDAO {
	
	/**
	 * ID & Password 확인
	 */
	public MemberVO getMemberByIdAndPassword( MemberVO member ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/member/getMemberByIdAndPassword/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getPassword());
			rs = stmt.executeQuery();
			
			MemberVO validMember = null;
			
			if ( rs.next() ) {
				
				validMember = new MemberVO();
				validMember.setMemberId(rs.getString("MEMBER_ID"));
				validMember.setNickName(rs.getString("NICK_NAME"));
				validMember.setPassword(rs.getString("PASSWORD"));
				validMember.setEmail(rs.getString("EMAIL"));
				validMember.setIsAdmin(rs.getString("IS_ADMIN"));
				validMember.setIsBlock(rs.getString("IS_BLOCK"));
				
			}
			
			return validMember;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
	} //getMemberByIdAndPassword end
	
	
	/**
	 * 회원 추가
	 */
	public int addNewMember ( MemberVO member ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/member/addNewMember/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getNickName());
			stmt.setString(3, member.getPassword());
			stmt.setString(4, member.getEmail());
			
			int addMemberAction = stmt.executeUpdate();
			
			return addMemberAction;
						
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	} //addNewMember end
	
	
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


	public int getAllMemberCount() {
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MemberVO member = new MemberVO();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/member/getAllMemberCount/text()");
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			int memberCount = 0;
			rs.next();
			memberCount = rs.getInt(1);
			
			return memberCount;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
	}


	public List<MemberVO> getMemberList(MemberSearchVO searchVO) {
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<MemberVO> members = new ArrayList<MemberVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/member/getAllMemberList/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, searchVO.getEndIndex());
			stmt.setInt(2, searchVO.getStartIndex());
			
			rs = stmt.executeQuery();
			
			MemberVO member = null;
			
			while ( rs.next() ) {
				
				member = new MemberVO();
				
				member.setMemberId(rs.getString("MEMBER_ID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setNickName(rs.getString("NICK_NAME"));
				member.setEmail(rs.getString("EMAIL"));
				member.setIsBlock(rs.getString("IS_BLOCK"));
				
				members.add(member);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
		return members;
	}


	public void dropOutMember(String memberId) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			String query = XML.getNodeString("//query/member/dropOutMember/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, memberId);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	}


	public MemberVO getDetailMember(String memberId) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MemberVO member = new MemberVO();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/member/getDetailMember/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, memberId);
			
			rs = stmt.executeQuery();
			
			if ( rs.next() ) {
				member.setMemberId(rs.getString("MEMBER_ID"));
				member.setNickName(rs.getString("NICK_NAME"));
				member.setEmail(rs.getString("EMAIL"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setIsAdmin(rs.getString("IS_ADMIN"));
				member.setIsBlock(rs.getString("IS_BLOCK"));
			}

			return member;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}		
	}
	
	public void changePassword ( MemberVO member ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/member/changePassword/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, member.getPassword());
			stmt.setString(2, member.getMemberId());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
		
	}


	public void memberBlock(MemberVO member) {

		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/member/memberBlock/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, member.getIsBlock());
			stmt.setString(2, member.getMemberId());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
		
	}
	
}
