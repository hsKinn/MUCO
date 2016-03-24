package com.ktds.cain.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.cain.member.vo.MemberVO;
import com.ktds.cain.util.xml.XML;

public class MemberDAO {

	public MemberVO getMemberByIdAndPassword(MemberVO member) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		loadOracleDriver();
		
		try {
//			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PWD);
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/member/getMemberByIdAndPassword/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getPassword());
			
			rs = stmt.executeQuery();
			
			MemberVO validMember = null;
			if ( rs.next()) {
				validMember = new MemberVO(); 
				validMember.setMemberId(rs.getString("MEMBER_ID"));
				validMember.setNickName(rs.getString("NICK_NAME"));
				validMember.setPassword(rs.getString("PASSWORD"));
				validMember.setEmail(rs.getString("EMAIL"));			
			}
			return validMember;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
	}
	public int insertNewMember(MemberVO member) {

		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");

			String query = XML.getNodeString("//query/member/insertNewMember/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, member.getNickName());
			stmt.setString(2, member.getPassword());
			stmt.setString(3, member.getEmail());
			
			return stmt.executeUpdate();

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
