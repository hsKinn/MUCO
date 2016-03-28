package com.ktds.cain.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.cain.article.vo.ArticleSearchVO;
import com.ktds.cain.member.vo.MemberVO;
import com.ktds.cain.util.xml.XML;

public class MemberDAO {

	public MemberVO getMemberByIdAndPassword(MemberVO member) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		loadOracleDriver();

		try {
			// conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER,
			// Const.DB_PWD);
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/member/getMemberByIdAndPassword/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getPassword());

			rs = stmt.executeQuery();

			MemberVO validMember = null;
			// 한건만 가지고 올 것이므로 if문을 쓴다.
			// 세션은 노출될 위험은 없지만, 도난위험존재. 누구도 세션에 있는 정보 꺼내 볼 수 없음.

			if (rs.next()) {
				validMember = new MemberVO();
				validMember.setMemberId(rs.getString("MEMBER_ID"));
				validMember.setNickName(rs.getString("NICK_NAME"));
				validMember.setPassword(rs.getString("PASSWORD"));
				validMember.setEmail(rs.getString("EMAIL"));
				validMember.setIsAdmin(rs.getString("IS_ADMIN"));
			}
			return validMember;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	public void insertNewMember(MemberVO member) {

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
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}

	public List<MemberVO> allMember(ArticleSearchVO searchVO) {
		List<MemberVO> mvo = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MemberVO vo = null;

		loadOracleDriver();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/member/allMember/text()");
			stmt = conn.prepareStatement(query);
			// 인덱스 추가부분
			stmt.setString(1, searchVO.getSearchKeyword());
			stmt.setString(2, searchVO.getSearchKeyword());
			stmt.setInt(3, searchVO.getEndIndex());
			stmt.setInt(4, searchVO.getStartIndex());

			rs = stmt.executeQuery();

			while (rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("MEMBER_ID"));
				vo.setNickName(rs.getString("NICK_NAME"));
				vo.setPassword(rs.getString("PASSWORD"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setIsAdmin(rs.getString("IS_ADMIN"));

				mvo.add(vo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return mvo;
	}

	public List<MemberVO> searchNickName(ArticleSearchVO searchVO) {
		List<MemberVO> mvo = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MemberVO vo = null;

		loadOracleDriver();
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/member/searchNickName/text()");
			stmt = conn.prepareStatement(query);
			// 인덱스 추가부분
			stmt.setString(1, searchVO.getSearchKeyword());
			stmt.setInt(2, searchVO.getEndIndex());
			stmt.setInt(3, searchVO.getStartIndex());

			rs = stmt.executeQuery();

			while (rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("MEMBER_ID"));
				vo.setNickName(rs.getString("NICK_NAME"));
				vo.setPassword(rs.getString("PASSWORD"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setIsAdmin(rs.getString("IS_ADMIN"));

				mvo.add(vo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return mvo;
	}

	public List<MemberVO> searchEmail(ArticleSearchVO searchVO) {
		List<MemberVO> mvo = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MemberVO vo = null;

		loadOracleDriver();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/member/searchEmail/text()");
			stmt = conn.prepareStatement(query);
			// 인덱스 추가부분
			stmt.setString(1, searchVO.getSearchKeyword());
			stmt.setInt(2, searchVO.getEndIndex());
			stmt.setInt(3, searchVO.getStartIndex());

			rs = stmt.executeQuery();

			while (rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("MEMBER_ID"));
				vo.setNickName(rs.getString("NICK_NAME"));
				vo.setPassword(rs.getString("PASSWORD"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setIsAdmin(rs.getString("IS_ADMIN"));

				mvo.add(vo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return mvo;
	}

	public List<MemberVO> searchAdmin(ArticleSearchVO searchVO) {
		List<MemberVO> mvo = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MemberVO vo = null;

		loadOracleDriver();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/member/searchAdmin/text()");
			stmt = conn.prepareStatement(query);
			// 인덱스 추가부분
			stmt.setString(1, searchVO.getSearchKeyword());
			stmt.setInt(2, searchVO.getEndIndex());
			stmt.setInt(3, searchVO.getStartIndex());

			rs = stmt.executeQuery();

			while (rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("MEMBER_ID"));
				vo.setNickName(rs.getString("NICK_NAME"));
				vo.setPassword(rs.getString("PASSWORD"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setIsAdmin(rs.getString("IS_ADMIN"));

				mvo.add(vo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return mvo;
	}

	public int allMemberCount(ArticleSearchVO searchVO) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		loadOracleDriver();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/member/allMemberCount/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, searchVO.getSearchKeyword());
			stmt.setString(2, searchVO.getSearchKeyword());

			rs = stmt.executeQuery();

			int articleCount = 0;
			rs.next();
			articleCount = rs.getInt(1);
			return articleCount;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	public int searchNickNameCount(ArticleSearchVO searchVO) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		loadOracleDriver();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/member/searchNickNameCount/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, searchVO.getSearchKeyword());

			rs = stmt.executeQuery();

			int articleCount = 0;
			rs.next();
			articleCount = rs.getInt(1);
			return articleCount;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	public int searchEmailCount(ArticleSearchVO searchVO) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		loadOracleDriver();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/member/searchEmailCount/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, searchVO.getSearchKeyword());

			rs = stmt.executeQuery();

			int articleCount = 0;
			rs.next();
			articleCount = rs.getInt(1);
			return articleCount;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	public int searchAdminCount(ArticleSearchVO searchVO) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		loadOracleDriver();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/member/searchAdminCount/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, searchVO.getSearchKeyword());

			rs = stmt.executeQuery();

			int articleCount = 0;
			rs.next();
			articleCount = rs.getInt(1);
			return articleCount;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	public int invalidCheckNickName(MemberVO memberVO) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		loadOracleDriver();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/member/invalidCheckNickName/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, memberVO.getNickName());

			rs = stmt.executeQuery();
			
			rs.next();
			return rs.getInt(1);
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}
	public MemberVO getInfoDetail(String memberId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MemberVO memberVO = null;

		loadOracleDriver();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/member/getInfoDetail/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, memberId);

			rs = stmt.executeQuery();

			if (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberId(rs.getString("MEMBER_ID"));
				memberVO.setNickName(rs.getString("NICK_NAME"));
				memberVO.setPassword(rs.getString("PASSWORD"));
				memberVO.setEmail(rs.getString("EMAIL"));
				memberVO.setIsAdmin(rs.getString("IS_ADMIN"));
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return memberVO;
	}

	public void singleDeleteInfo(String memberId) {
		
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");

			String query = XML.getNodeString("//query/member/singleDeleteInfo/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, memberId);

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		
	}

	public void multiDeleteInfo(String memberId) {
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");

			String query = XML.getNodeString("//query/member/multiDeleteInfo/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, memberId);

			stmt.executeUpdate();

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
